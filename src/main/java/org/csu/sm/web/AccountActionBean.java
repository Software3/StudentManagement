package org.csu.sm.web;

import org.csu.sm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ltaoj on 2017/8/8.
 */
@Controller
public class AccountActionBean extends AbstractActionBean{
    private AccountService accountService;
    @Autowired
    public AccountActionBean(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginForm() {
        return "index";
    }

    @RequestMapping(value = "/basicInfo", method = RequestMethod.GET)
    public String showBasicInfo() {
        return "student/basicInfo";
    }

    @RequestMapping(value = "teacherhome", method = RequestMethod.GET)
    public String showTeacherHome() {
        return "teacher/index";
    }
}
