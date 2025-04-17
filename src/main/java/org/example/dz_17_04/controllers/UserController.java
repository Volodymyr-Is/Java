package org.example.dz_17_04.controllers;

import models.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String index(Model model)
    {
        User user = new User();
        model.addAttribute("user",user);
        return "user/index";
    }
    @PostMapping("/confirm")
    public String submitUser(@ModelAttribute("user") User user)
    {
        return "user/confirmation";
    }

    @ModelAttribute("roleList")
    public List<String> getRoleList()
    {
        List<String> roleList = new ArrayList<>();
        roleList.add("Admin");
        roleList.add("Engineer");
        roleList.add("Manager");
        roleList.add("Guest");
        return roleList;
    }

    @ModelAttribute("signList")
    public List<String> getSignList()
    {
        List<String> signList = new ArrayList<>();
        signList.add("Mail");
        signList.add("Payroll");
        signList.add("Self-service");
        return signList;
    }

    @ModelAttribute("serverList")
    public List<String> getServerList() {
        List<String> serverList = new ArrayList<>();
        serverList.add("Apache");
        serverList.add("Nginx");
        serverList.add("WildFly");
        serverList.add("Tomcat");
        return serverList;
    }
}
