package com.scriptizergs.ribenteuer.interceptors;

import com.scriptizergs.ribenteuer.model.User.UserService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter {

    private UserService userService;

    public UserInterceptor(UserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        try {
            request.setAttribute("currentUser", userService.findUserByLogin(request.getUserPrincipal().getName()).get());
        } catch (Exception ignore) {
        }

        return true;

    }
}
