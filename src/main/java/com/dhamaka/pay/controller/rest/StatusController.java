package com.dhamaka.pay.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class StatusController {
    @GetMapping("/status/success")
    public ModelAndView getSuccessUrl() {
        return new ModelAndView("status/success");
    }
    @GetMapping("/status/fail")
    public ModelAndView getFailPage() {
        return new ModelAndView("status/fail");
    }
    @GetMapping("/status/cancel")
    public ModelAndView getCancelPage() {
        return new ModelAndView("status/cancel");
    }
}
