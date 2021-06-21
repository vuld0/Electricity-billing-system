
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
import com.cts.ebilling.service.ConsumerService;
import com.cts.ebilling.service.OutageService;

@Controller
public class ConsumerController {
	
	 @Autowired
	    private ConsumerService service;
	 @Autowired
	 	private OutageService oservice;

	    @GetMapping("/ind")
	    public String viewHomePage(Model model) {
	        List<Consumer> listconsumer = service.listAll();
	        model.addAttribute("listconsumer", listconsumer);
	        System.out.print("Get / ");	
	        return "ind";
	    }

	    @GetMapping("/addnewconsumers")
	    public String add(Model model) {
	        model.addAttribute("consumer", new Consumer());
	        return "addnewconsumers";
	    }
	   
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveConsumer(@ModelAttribute("consumer") Consumer con) {
	        service.save(con);
	        return "redirect:/ind";
	    }
	   
	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditConsumerPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("addnewconsumers");
	        Consumer con = service.get(id);
	        mav.addObject("consumer", con);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{id}")
	    public String deleteconsumer(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/ind";
	    }

	   
	 @GetMapping("/GenerateBill")
	    public String add1(Model model) {
	        model.addAttribute("bill", new Consumer());
	        return "generatebill";
	    }
	   
	    /*@RequestMapping("/update")
	    public ModelAndView showEditConsumerPage1(@PathVariable(name = "uscNo") long id) {
	        ModelAndView mav = new ModelAndView("GenerateBill");
	        Consumer con = service.get(id);
	        mav.addObject("bill", con);
	        return "home";
	        
	    }*/
	 @RequestMapping("/update")
	    public String showEditConsumerPage1(@PathVariable(name = "uscNo") long id) {
	        ModelAndView mav = new ModelAndView("GenerateBill");
	        Consumer con = service.get(id);
	        mav.addObject("bill", con);
	        return "redirect:home";
	    }
	 @GetMapping("/viewoutage")
	    public String viewHomePage1(Model model) {
	        List<Outage> listoutage = oservice.listAll();
	        model.addAttribute("listoutage", listoutage);
	        System.out.print("Get / ");	
	        return "viewoutage";
	    }
}

