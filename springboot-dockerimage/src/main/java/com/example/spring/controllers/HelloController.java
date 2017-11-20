package com.example.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Simple Spring MVC controller that says hello.
 */
@Controller
public class HelloController {
    /* Constant(s): */
    protected static final String HELLO_VIEW_NAME = "hello";
    protected static final String GREETING_PLACEHOLDER = "greeting";

    @RequestMapping("/hello")
    public String hello(
        @RequestParam(value="name", required=false, defaultValue="Anonymous")
        final String inName,
        final Model inModel) {
        final StringBuilder theMessageBuilder = new StringBuilder();
        theMessageBuilder
            .append("Hello ")
            .append(inName)
            .append(", the time is now ")
            .append(new Date().toString())
            .append(".");
        inModel.addAttribute(GREETING_PLACEHOLDER, theMessageBuilder.toString());
        return HELLO_VIEW_NAME;
    }

}