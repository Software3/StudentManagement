package org.csu.sm.web;

import org.csu.sm.domain.Signon;
import org.csu.sm.domain.Student;
import org.csu.sm.domain.Teacher;
import org.csu.sm.exception.action.HandleAccountServiceException;
import org.csu.sm.exception.service.AccountServiceException;
import org.csu.sm.exception.service.InfoManageServiceException;
import org.csu.sm.service.AccountService;
import org.csu.sm.service.InfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ltaoj on 2017/8/8.
 */
@Controller
public class AccountActionBean extends AbstractActionBean {
    private static final int STUDENT = 0;
    private static final int TEACHER = 1;

    private AccountService accountService;

    @Autowired
    public AccountActionBean(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public String showLoginForm() {
        return "signin";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String account, String password, Integer type) {
        Object object = null;
        try {
            switch (type) {
                case STUDENT:
                    object = accountService.studentLogin(new Signon(Long.parseLong(account), password));
                    break;
                case TEACHER:
                    object = accountService.teacherLogin(new Teacher(account, password));
                    break;
            }
            if (object == null) {
                return "redirect:/";
            }
            return type == 0 ? ("redirect:/basicInfo?userid=" + account + "&authenticated=true") : "redirect:/teacherhome";
        } catch (AccountServiceException e) {
            throw new HandleAccountServiceException(e);
        }
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
