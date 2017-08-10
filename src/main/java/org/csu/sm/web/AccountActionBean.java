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
public class AccountActionBean extends AbstractActionBean {
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


    @RequestMapping(value = "parentsInfo", method = RequestMethod.GET)
    public String showParentInfo() {
        return "student/parentsInfo";
    }

    @RequestMapping(value = "awardSitu", method = RequestMethod.GET)
    public String showAwardSitu() {
        return "student/awardSitu";
    }

    @RequestMapping(value = "failexamSitu", method = RequestMethod.GET)
    public String showFailexamSitu() {
        return "student/failexamSitu";
    }


    @RequestMapping(value = "teacherhome", method = RequestMethod.GET)
    public String showTeacherHome() {
        return "teacher/index";
    }

    @RequestMapping(value = "noAudited", method = RequestMethod.GET)
    public String showNoAudited() {
        return "teacher/noAudited";
    }

    @RequestMapping(value = "teacherBasicInfo", method = RequestMethod.GET)
    public String showteacherBasicInfo() {
        return "teacher/teacherBasicInfo";
    }

    @RequestMapping(value = "audited", method = RequestMethod.GET)
    public String showAudited() {
        return "teacher/audited";
    }

    @RequestMapping(value = "uncommitted", method = RequestMethod.GET)
    public String showUncommitted() {
        return "teacher/uncommitted";
    }

    @RequestMapping(value = "auditedLog", method = RequestMethod.GET)
    public String showAuditedLog() {
        return "teacher/auditedLog";
    }

    @RequestMapping(value = "auditInformation", method = RequestMethod.GET)
    public String showAuditInformation() {
        return "teacher/auditInformation";
    }

    @RequestMapping(value = "studentInformation", method = RequestMethod.GET)
    public String showStudentInformation() {
        return "teacher/studentInformation";
    }

    @RequestMapping(value = "studentList", method = RequestMethod.GET)
    public String showStudentList() {
        return "teacher/studentList";
    }
}
