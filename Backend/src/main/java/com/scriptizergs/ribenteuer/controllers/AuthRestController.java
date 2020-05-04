package com.scriptizergs.ribenteuer.controllers;

import com.scriptizergs.ribenteuer.exceptions.BadRequestException;
import com.scriptizergs.ribenteuer.exceptions.NotFoundException;
import com.scriptizergs.ribenteuer.helpers.RequestHelper;
import lombok.RequiredArgsConstructor;
import model.User.User;
import model.User.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.scriptizergs.ribenteuer.security.AuthenticationManager;
import com.scriptizergs.ribenteuer.security.TokenProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthRestController {

    private final AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder passwordEncoder;

    private final TokenProvider tokenProvider;

    private final RequestHelper requestHelper;

    private final UserService userService;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String HEADER_STRING = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";


    @PostMapping("/sign-in")
    public ResponseEntity<User> signUserIn(@Valid @RequestBody User userLoginData, HttpServletResponse response) throws NotFoundException {
        User user = userService.findUserByLogin(userLoginData.getLogin())
                .orElseThrow(() -> new NotFoundException("No user with login: " + userLoginData.getLogin()));

        if (passwordEncoder.matches(userLoginData.getPassword(), user.getPassword())) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getLogin(),
                            user.getPassword()
                    )
            );

            log.info("User #" + user.getId() + " signed in");

            String jwt = tokenProvider.generateToken(authentication, false);
            response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);

            return ResponseEntity.ok(user);

        } else {
            throw new NotFoundException("Invalid credentials were provided");
        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUserUp(@RequestBody User user) throws BadRequestException {
        if (userService.findUserByLogin(user.getLogin()).isPresent()) {
            throw new BadRequestException("User with this login already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.createUser(user.getMail(), user.getPassword(), user.getLogin(), user.getActiveRole());

        log.info("User #" + user.getId() + " signed up");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getLogin(),
                        user.getPassword()
                )
        );

        String jwt = tokenProvider.generateToken(authentication, false);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HEADER_STRING, TOKEN_PREFIX + jwt);

        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).build();
    }

    @PostMapping("/log-out")
    public void logUserOut(HttpServletRequest request) {
        User currentUser = requestHelper.getCurrentUser(request);
        log.info("User #" + currentUser.getId() + " logged out");

        request.getSession().invalidate();
    }
}
