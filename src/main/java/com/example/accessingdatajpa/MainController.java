package com.example.accessingdatajpa;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private BuddyInfoRepo buddyInfoRepo;


    @RequestMapping(value = "/home")
    public String home(Model model) {
        List<BuddyInfo> buddyInfoList = (List<BuddyInfo>) buddyInfoRepo.findAll();
        System.out.println(buddyInfoList);
        System.out.println("Controller: Passing through...");
        model.addAttribute("BuddyList", buddyInfoList);
        return "view";
    }
}

