package com.sitejournal.controllers;

import com.sitejournal.data.Account;
import com.sitejournal.data.Employee;
import com.sitejournal.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(method = RequestMethod.GET)
    public String admin(
            Model model) {

        return "admin";
    }


    @RequestMapping("/account")
    public String inspectAccount(
            HttpServletRequest request,
            @RequestParam String userEmail
    ) {
        Account account = adminService.findAccountByEmail(userEmail);
        request.setAttribute("existingAccount", account);
        return "account";
    }


    @RequestMapping(value = "/dropAccounts", method = RequestMethod.POST)
    public String dropAccounts(Model model) {
        int numAccountsDeleted = adminService.deleteAllAccountsExceptAdmin();
        model.addAttribute("numAccountsDeleted", numAccountsDeleted);
        return "admin";
    }




}
