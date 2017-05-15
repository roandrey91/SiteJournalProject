package com.sitejournal.controllers;

import com.sitejournal.data.Account;

import com.sitejournal.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.NoResultException;
import java.security.Principal;
import java.util.Set;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public String showAccountInfo(Model model, Principal principal) {
        String email = principal.getName();
        Account account = adminService.findAccountByEmail(email);
        model.addAttribute("existingAccount", account);
        return "account";
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeAccountDetails(
            @ModelAttribute("changedAccount") Account changedAccount,
            Model model,
            Principal principal)
    {
        if (isChangedEmailOccupied(changedAccount, principal)) {
            returnError(changedAccount, model);
        } else {
            updateAccount(changedAccount, model, principal);
        }
        return "account";
    }

    private void updateAccount(Account changedAccount, Model model, Principal principal) {
        Account existingAccount = null;
        try {
            existingAccount = adminService.findAccountByEmail(principal.getName());
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        String existingPw = existingAccount.getPassword();

        if (!changedAccount.getPassword().equals(existingPw)) {
            String newEncodedPw = passwordEncoder.encodePassword(changedAccount.getPassword(), null);
            changedAccount.setPassword(newEncodedPw);
        }

        changedAccount.setId(existingAccount.getId());
        changedAccount.setRole(existingAccount.getRole());
        adminService.saveAccount(changedAccount);

        model.addAttribute("existingAccount", changedAccount);
    }

    private void returnError(Account changedAccount, Model model) {
        changedAccount.setPassword("");
        model.addAttribute("error", new Object());
        model.addAttribute("existingAccount", changedAccount);
    }

    private boolean isChangedEmailOccupied(Account changedAccount, Principal principal) {
        String changedEmail = changedAccount.getEmail();
        String existingEmail = principal.getName();
        if (changedEmail.equals(existingEmail))
            return false;
        Account accountByEmail = null;
        try {
            accountByEmail = adminService.findAccountByEmail(changedEmail);
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }

}
