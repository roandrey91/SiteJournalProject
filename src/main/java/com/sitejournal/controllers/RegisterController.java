package com.sitejournal.controllers;

import com.sitejournal.data.Account;
import com.sitejournal.data.AccountRole;
import com.sitejournal.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.NoResultException;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public String registerPage() {
        return "register";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String registerAccount(@ModelAttribute("existingAccount") Account newAccount, Model model) {
        Account existingAccount = null;
        try {
            existingAccount = adminService.findAccountByEmail(newAccount.getEmail());
        } catch (NoResultException exc) {
            String rawPassword = newAccount.getPassword();
            newAccount.setPassword(passwordEncoder.encodePassword(rawPassword, null));
            newAccount.setRole(AccountRole.USER);
            adminService.saveAccount(newAccount);
            return "login";
        }
        model.addAttribute("error", new Object());
        model.addAttribute("newAccount", newAccount);
        return "register";
    }
}
