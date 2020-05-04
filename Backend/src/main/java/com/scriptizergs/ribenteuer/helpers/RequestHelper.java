package com.scriptizergs.ribenteuer.helpers;


import com.scriptizergs.ribenteuer.model.User.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Some common methods to work with request
 */
@Component
public class RequestHelper {

    /*
     * Get current user from the request
     */
    public User getCurrentUser(HttpServletRequest request) {
        return (User) request.getAttribute("currentUser");
    }
}
