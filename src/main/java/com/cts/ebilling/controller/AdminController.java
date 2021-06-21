package com.cts.ebilling.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.ebilling.model.Consumer;
import com.cts.ebilling.model.Outage;
import com.cts.ebilling.model.Tariff;
import com.cts.ebilling.service.OutageService;
import com.cts.ebilling.service.TariffService;
@Controller
public class AdminController {
	@Autowired
    private TariffService service;
	@Autowired
	private OutageService oservice;

    @GetMapping("/tariff")
    public String viewHomePage(Model model) {
        List<Tariff> listtariff = service.listAll();
        model.addAttribute("listtariff", listtariff);
        System.out.print("Get / ");	
        return "tariff";
    }

    @GetMapping("/tariffedit")
    public String addtariff(Model model) {
        model.addAttribute("tariff", new Tariff());
        return "tariffedit";
    }
   
    @RequestMapping(value = "/saving", method = RequestMethod.POST)
    public String updateTariff(@ModelAttribute("tariff") Tariff con) {
        service.save(con);
        return "redirect:/tariff";
    }
   
    @RequestMapping("/editing/{id}")
    public ModelAndView showEditAdminPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("tariffedit");
        Tariff con = service.get(id);
        mav.addObject("tariff", con);
        return mav;
        
    }
    
    
    
    @GetMapping("/outage")
    public String viewHomePage1(Model model) {
        List<Outage> listoutage = oservice.listAll();
        model.addAttribute("listoutage", listoutage);
        System.out.print("Get / ");	
        return "outage";
    }
    

    @GetMapping("/addoutage")
    public String addoutage(Model model) {
        model.addAttribute("outage", new Outage());
        return "addoutage";
    }
   
    @RequestMapping(value = "/save3", method = RequestMethod.POST)
    public String saveOutage(@ModelAttribute("outage") Outage con) {
        oservice.save(con);
        return "redirect:/outage";
    }
   
    @RequestMapping("/edit3/{id}")
    public ModelAndView showEditOutagePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("addoutage");
        Outage con = oservice.get(id);
        mav.addObject("outage", con);
        return mav;
        
    }
    @RequestMapping("/delete3/{id}")
    public String deleteoutage(@PathVariable(name = "id") int id) {
        oservice.delete(id);
        return "redirect:/outage";
    }
    
}
