package com.cts.osp.kt.fsd.fsdservice.controller;



import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.osp.kt.fsd.fsdservice.auth.service.SecurityService;
import com.cts.osp.kt.fsd.fsdservice.auth.service.UserService;
import com.cts.osp.kt.fsd.fsdservice.entity.FsdRole;
import com.cts.osp.kt.fsd.fsdservice.entity.FsdUser;
import com.cts.osp.kt.fsd.fsdservice.validator.UserValidator;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    //@Autowired
    //private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
    	
        model.addAttribute("userForm", new FsdUser());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") FsdUser userForm, BindingResult bindingResult, Model model) {
     //  userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        Set<FsdRole> fsdRoles= userForm.getFsdRoles();
        if(fsdRoles!=null) {
        	System.out.println("Roles are null & set defualt role");
        	fsdRoles=new HashSet<FsdRole>();
        	FsdRole fsdRole=new FsdRole();
        	fsdRole.setRoleName("USER");
        	fsdRoles.add(fsdRole);
        
        	
        }
        userForm.setFsdRoles(fsdRoles);
        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
