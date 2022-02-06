package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class homeController {
    @RequestMapping("home")
    public ModelAndView home(@RequestParam("name") String myName)
    {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",myName);
        mv.setViewName("home");
        return mv;
    }
}
