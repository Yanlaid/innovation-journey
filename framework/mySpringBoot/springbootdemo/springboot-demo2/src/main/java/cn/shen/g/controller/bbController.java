package cn.shen.g.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shen")
public class bbController {
    @RequestMapping("Hello")
    public String ss(){
        return "fadfasdf";

    }
}
