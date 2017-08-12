package org.csu.sm.web;

import org.csu.sm.domain.Result;
import org.csu.sm.domain.Teacher;
import org.csu.sm.exception.service.InfoManageServiceException;
import org.csu.sm.service.InfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 51157 on 2017/8/11.
 */
@Controller
public class TeacherActionBean {
    private InfoManageService infoManageService;

    @Autowired
    public TeacherActionBean(InfoManageService infoManageService) {
        this.infoManageService = infoManageService;
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

    @RequestMapping(value = "auditInformationModifiable", method = RequestMethod.GET)
    public String showauditInformationModifiable() {
        return "teacher/auditInformationModifiable";
    }

    /*******************************************异步请求****************************************************/
    @RequestMapping(value = "editTeacherInfo", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Result> editTeacherInfo(@RequestBody Teacher teacher) {
        try {
            infoManageService.modifyTeacherInfo(teacher);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Result>(new Result(Result.RESULT_ERROR), HttpStatus.OK);
    }

}
