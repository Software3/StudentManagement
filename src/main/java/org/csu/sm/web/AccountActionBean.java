package org.csu.sm.web;

import org.csu.sm.domain.*;
import org.csu.sm.exception.action.HandleAccountServiceException;
import org.csu.sm.exception.action.HandleInfoServiceException;
import org.csu.sm.exception.service.AccountServiceException;
import org.csu.sm.exception.service.InfoManageServiceException;
import org.csu.sm.service.AccountService;
import org.csu.sm.service.InfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

//    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
//    public String showLoginForm() {
//        return "signin";
//    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String login(String account, String password, Integer type) {
//        Object object = null;
//        try {
//            switch (type) {
//                case STUDENT:
//                    object = accountService.studentLogin(new Signon(Long.parseLong(account), password));
//                    break;
//                case TEACHER:
//                    object = accountService.teacherLogin(new Teacher(account, password));
//                    break;
//            }
//            if (object == null) {
//                return "redirect:/";
//            }
//            return type == 0 ? ("redirect:/basicInfo?userid=" + getPrincipal() + "&authenticated=true") : ("redirect:/teacherhome?teacherId=" + account);
//        } catch (AccountServiceException e) {
//            throw new HandleAccountServiceException(e);
//        }
//    }

//    @RequestMapping(value = "loginCheck", method = RequestMethod.POST)
//    public ResponseEntity<Result> loginCheck(@RequestBody LoginMessage loginMessage) {
//        Object object = null;
//        try {
//            switch (loginMessage.getType()) {
//                case STUDENT:
//                    object = accountService.studentLogin(new Signon(Long.parseLong(loginMessage.getAccount()), loginMessage.getPassword()));
//                    break;
//                case TEACHER:
//                    object = accountService.teacherLogin(new Teacher(loginMessage.getAccount(), loginMessage.getPassword()));
//                    ((Teacher) object).setPassword("");
//                    break;
//            }
//            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "登录成功", object), HttpStatus.OK);
//        } catch (AccountServiceException e) {
//            throw new HandleAccountServiceException(e);
//        }
//    }

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String showSignin() {
        return "signin";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/signin?logout";
    }

    @RequestMapping(value = "checkPassword", method = RequestMethod.POST)
    public ResponseEntity<Result> checkPassword(@RequestBody Signon signon) {
        try {
            Student student=accountService.studentLogin(signon);
            if(student!=null) {
                return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "核对密码成功"), HttpStatus.OK);
            }else{
                return new ResponseEntity<Result>(new Result(Result.RESULT_ERROR, "核对密码失败"), HttpStatus.OK);
            }
        } catch (AccountServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "changeStuPassword", method = RequestMethod.POST)
    public ResponseEntity<Result> changeStuPassword(@RequestBody Signon signon) {
        try {
            accountService.changeStudPassword(signon.getStudentId(),signon.getPassword());
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "修改密码成功"), HttpStatus.OK);
        } catch (AccountServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }
}
