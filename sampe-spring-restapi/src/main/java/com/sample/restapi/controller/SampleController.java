package com.sample.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class SampleController {

    @GetMapping("/sample-test")
    public String test() {
        return "Came in Authorize";
    }
}
