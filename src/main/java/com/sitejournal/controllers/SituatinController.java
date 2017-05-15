package com.sitejournal.controllers;

import com.sitejournal.data.DaySituatiation;
import com.sitejournal.services.SituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("situation")
public class SituatinController {

    @Autowired
    private SituationService situationService;

    @RequestMapping(method = RequestMethod.GET)
    public String showSituation(){
        return "situation";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSituation(@ModelAttribute("situation")DaySituatiation situationDay, Model model){
        situationService.saveSituationDay(situationDay);
        model.addAttribute("situationDay",model);
        return "situation";
    }
}
