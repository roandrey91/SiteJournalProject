package com.sitejournal.services;

import com.sitejournal.data.Account;
import com.sitejournal.persistence.AccountDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class AdminService {

    @Autowired
    private AccountDAO accountDAO;

    @Transactional
    public Account findAccountById(long id) {
        return accountDAO.findAccountById(id);
    }

    @Transactional
    public Account findAccountByEmail(String email) {
        return accountDAO.findAccountByEmail(email);
    }

    @Transactional
    public Account saveAccount(Account account) {
        return accountDAO.saveAccount(account);
    }

    @Transactional
    public void deleteAccount(Account account) {
        accountDAO.deleteAccount(account);
    }

    @Transactional
    public int deleteAllAccountsExceptAdmin() {
        return accountDAO.deleteAllAccountsExceptAdmin();
    }


}
