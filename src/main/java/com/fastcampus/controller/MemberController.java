package com.fastcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    @RequestMapping(value = {"/member/loginView", "/member/login"})
    public String loginView() { return "login"; }
}
