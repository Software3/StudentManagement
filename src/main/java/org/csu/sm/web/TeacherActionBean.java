package org.csu.sm.web;

import org.csu.sm.domain.*;
import org.csu.sm.exception.action.HandleAccountServiceException;
import org.csu.sm.exception.action.HandleInfoServiceException;
import org.csu.sm.exception.service.InfoManageServiceException;
import org.csu.sm.exception.service.TeacherServiceException;
import org.csu.sm.exception.service.VerifyServiceException;
import org.csu.sm.service.InfoManageService;
import org.csu.sm.service.TeacherService;
import org.csu.sm.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.ParagraphView;
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

    public String getPrincipal() {
        String userId = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userId = ((UserDetails) principal).getUsername();
        } else {
            userId = principal.toString();
        }
        return userId;
    }

    @RequestMapping(value = "teacherhome", method = RequestMethod.GET)
    public String showTeacherHome(
//            @RequestParam(value = "teacherId", defaultValue = "") String teacherId,
            Model model) {
        model.addAttribute("teacherId", Long.valueOf(getPrincipal()));
        return "teacher/index";
    }

    @RequestMapping(value = "teacherBasicInfo", method = RequestMethod.GET)
    public String showteacherBasicInfo(
//            @RequestParam(value = "teacherId", defaultValue = "") String teacherId,
            Model model) {
        try {
            Teacher teacher = infoManageService.getTeacherInfo(getPrincipal());
            System.out.println(teacher.getName() + " " + teacher.getEmail());
            model.addAttribute("teacher", teacher);
            model.addAttribute("collegeList", Constant.getColleges());
            model.addAttribute("teacherId", Long.valueOf(getPrincipal()));
        } catch (InfoManageServiceException e) {
            e.printStackTrace();
        }
        return "teacher/teacherBasicInfo";

    }

    /**
     * 审核学生
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public String showAudited(
//            @RequestParam(value = "teacherId", defaultValue = "") String teacherId,
            @RequestParam(value = "state", defaultValue = "") String state,
            Model model) {
        try {
            List<Student> students = teacherService.getStudentListByTeacherIdAndState(getPrincipal(), state);
            model.addAttribute("students", students);
            model.addAttribute("teacherId", getPrincipal());
        } catch (TeacherServiceException e) {
            e.printStackTrace();
        }
        return state.equals("0") ? "teacher/uncommitted" : (state.equals("1") ? "teacher/noAudited" : "teacher/audited");
    }

    @RequestMapping(value = "auditedLog", method = RequestMethod.GET)
    public String showAuditedLog(
//            @RequestParam(value = "teacherId", defaultValue = "") String teacherId,
            Model model) {
        model.addAttribute("teacherId", getPrincipal());
        return "teacher/auditedLog";
    }

    /**
     * 不可修改信息界面跳转
     *
     * @param studentId
     * @param model
     * @return
     */
    @RequestMapping(value = "auditInformation", method = RequestMethod.GET)
    public String showAuditInformation(@RequestParam(value = "studentId", defaultValue = "") long studentId, @RequestParam(value = "teacherId", defaultValue = "") String teacherId, Model model) {
        try {
            Student student = infoManageService.getBasicInfo(studentId);
            List<Parent> parents = infoManageService.getParentList(studentId);
            List<AwardRecord> awardRecords = infoManageService.getAwardList(studentId);
            List<FailexamRecord> failexamRecords = infoManageService.getFailexamList(studentId);
            List<WithdrawInst> withdrawInsts = infoManageService.getWithdrawInstList(studentId);
            model.addAttribute("student", student);
            model.addAttribute("parents", parents);
            model.addAttribute("awardRecords", awardRecords);
            model.addAttribute("failexamRecords", failexamRecords);
            model.addAttribute("withdrawInsts", withdrawInsts);
            model.addAttribute("teacherId", teacherId);
        } catch (InfoManageServiceException e) {
            e.printStackTrace();
        }
        return "teacher/auditInformation";
    }

    @RequestMapping(value = "studentInformation", method = RequestMethod.GET)
    public String showStudentInformation(
//            @RequestParam(value = "teacherId", defaultValue = "") String teacherId,
            Model model) {
        model.addAttribute("teacherId", getPrincipal());
        return "teacher/studentInformation";
    }

    @RequestMapping(value = "studentList", method = RequestMethod.GET)
    public String showStudentList(
//            @RequestParam(value = "teacherId", defaultValue = "") String teacherId,
            Model model) {
        model.addAttribute("teacherId", getPrincipal());
        return "teacher/studentList";
    }

    /**
     * 可修改信息界面跳转
     *
     * @param studentId
     * @param model
     * @return
     */
    @RequestMapping(value = "auditInformationModifiable", method = RequestMethod.GET)
    public String showauditInformationModifiable(@RequestParam(value = "studentId", defaultValue = "") long studentId,
                                                 @RequestParam(value = "teacherId", defaultValue = "") String teacherId,
                                                 Model model) {
        try {
            Student student = infoManageService.getBasicInfo(studentId);
            List<Parent> parents = infoManageService.getParentList(studentId);
            List<AwardRecord> awardRecords = infoManageService.getAwardList(studentId);
            List<FailexamRecord> failexamRecords = infoManageService.getFailexamList(studentId);
            List<WithdrawInst> withdrawInsts = infoManageService.getWithdrawInstList(studentId);
            model.addAttribute("student", student);
            model.addAttribute("parents", parents);
            model.addAttribute("awardRecords", awardRecords);
            model.addAttribute("failexamRecords", failexamRecords);
            model.addAttribute("withdrawInsts", withdrawInsts);
            model.addAttribute("teacherId", teacherId);
        } catch (InfoManageServiceException e) {
            e.printStackTrace();
        }
        return "teacher/auditInformationModifiable";
    }

    @RequestMapping(value = "searchStudent", method = RequestMethod.GET)
    public String showSearchStudent(
//            @RequestParam(value = "teacherId", defaultValue = "") String teacherId,
            Model model) {
        model.addAttribute("teacherId", getPrincipal());
        return "teacher/searchStudents";
    }

    /**
     * 老师请求老师管理界面
     *
     * @return
     */
    @RequestMapping(value = "studentManagement", method = RequestMethod.GET)
    public String showauditInformationModifiable() {
        return "teacher/studentManagement";
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

    /**
     * 学生列表
     *
     * @param teacherId
     * @return
     */
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

    @RequestMapping(value = "auditedPass", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Result> auditedPass(@RequestBody VerifyLog verifyLog) {
        try {
            teacherService.auditedPass(verifyLog);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS), HttpStatus.OK);
        } catch (TeacherServiceException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Result>(new Result(Result.RESULT_ERROR), HttpStatus.OK);
    }

    @RequestMapping(value = "auditedFail", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Result> auditedFail(@RequestBody VerifyLog verifyLog) {
        try {
            teacherService.auditedFail(verifyLog);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS), HttpStatus.OK);
        } catch (TeacherServiceException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Result>(new Result(Result.RESULT_ERROR), HttpStatus.OK);
    }

    @RequestMapping(value = "searchStudentInfo", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<Student>> searchStudentInfo(@RequestBody SearchInfo searchInfo) {
        try {
            searchInfo.setCounselorName(getPrincipal());
            List<Student> list = teacherService.getSearchStudents(searchInfo);
            return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
        } catch (TeacherServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "importInfo", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Result> importInfo(@RequestBody List<Student> students) {
        try {
            teacherService.insertStudentList(students);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS), HttpStatus.OK);
        } catch (TeacherServiceException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Result>(new Result(Result.RESULT_ERROR), HttpStatus.OK);
    }
}
