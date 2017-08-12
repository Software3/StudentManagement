package org.csu.sm.web;

import org.csu.sm.domain.Result;
import org.csu.sm.domain.Student;
import org.csu.sm.domain.Teacher;
import org.csu.sm.domain.VerifyLog;
import org.csu.sm.exception.service.InfoManageServiceException;
import org.csu.sm.exception.service.TeacherServiceException;
import org.csu.sm.exception.service.VerifyServiceException;
import org.csu.sm.service.InfoManageService;
import org.csu.sm.service.TeacherService;
import org.csu.sm.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 51157 on 2017/8/11.
 */
@Controller
public class TeacherActionBean {
    private InfoManageService infoManageService;
    private VerifyService verifyService;
    private TeacherService teacherService;

    @Autowired
    public TeacherActionBean(InfoManageService infoManageService, VerifyService verifyService, TeacherService teacherService) {
        this.infoManageService = infoManageService;
        this.verifyService = verifyService;
        this.teacherService = teacherService;
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
    /**
     * 修改老师信息
     *
     * @param teacher
     * @return
     */
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

    /**
     * 教师查看审核日志
     *
     * @param teacherId
     * @return
     */
    @RequestMapping(value = "getAuditedLog", method = RequestMethod.GET)
    public ResponseEntity<Result> getAuditedLog(@RequestParam String teacherId) {

        try {
            List<VerifyLog> verifyLogs = verifyService.getVerifyLogListForTeacher(teacherId);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, verifyLogs), HttpStatus.OK);
        } catch (VerifyServiceException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Result>(new Result(Result.RESULT_ERROR), HttpStatus.OK);
    }

    @RequestMapping(value = "getStudentList", method = RequestMethod.GET)
    public ResponseEntity<Result> getStudentList(@RequestParam String teacherId) {
        try {
            List<Student> students = teacherService.getStudentList(teacherId);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, students), HttpStatus.OK);
        } catch (TeacherServiceException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Result>(new Result(Result.RESULT_ERROR), HttpStatus.OK);
    }
}
