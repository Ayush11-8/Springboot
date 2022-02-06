package com.example.demo.controller;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class AlienController {

    @Autowired
    AlienRepo repo;
    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien)
    {
        repo.save(alien);
        return "home.jsp";
    }

    @RequestMapping(path="/aliens", produces={"application/xml"})
    @ResponseBody
    public List<Alien> getAliens()
    {

          return repo.findAll();

    }

    @RequestMapping("/alien/{aid}")
    @ResponseBody
    public Optional<Alien> getAlien(@PathVariable("aid") int aid)
    {
        return repo.findById(aid);
    }
}
