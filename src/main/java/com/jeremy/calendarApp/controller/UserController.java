package com.jeremy.calendarApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {
        @RequestMapping("/welcome")
        public String user() {
            return ("<h1>Welcome User</h1>");
        }
}