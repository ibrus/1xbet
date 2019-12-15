package com.example.hillel.xbet.controller;

import com.example.hillel.xbet.model.Costumer;
import com.example.hillel.xbet.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    CostumerRepository costumerRepository;

    @GetMapping
    public String main(){
        return "main";
    }

    @PostMapping
    public String addNewCostumer(@RequestParam String firstName, @RequestParam String lastName,
                                 @RequestParam String phoneNumber, @RequestParam String email){
        Costumer costumer = new Costumer();
        costumer.setFirstName(firstName);
        costumer.setLastName(lastName);
        costumer.setEmail(email);
        costumer.setPhoneNumber(phoneNumber);
        costumerRepository.save(costumer);
        return "main";
    }
}
