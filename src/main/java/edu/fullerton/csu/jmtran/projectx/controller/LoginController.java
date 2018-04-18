package edu.fullerton.csu.jmtran.projectx.controller;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginPayload login(HttpServletRequest httpRequest, @RequestBody LoginPayload loginRequest) {
        String userId = loginRequest.getUserId();

        LoginPayload response = new LoginPayload();

        if(userId.isEmpty()) {
            return response;
        }

        HttpSession session = httpRequest.getSession(true);

        session.setAttribute("userId", userId);

        response.setUserId(userId);

        return response;
    }

    static class LoginPayload {
        private String userId;

        public LoginPayload() {
            // Do nothing
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
