package org.csu.sm.web;

import org.csu.sm.domain.Constant;
import org.csu.sm.domain.Result;
import org.csu.sm.domain.Student;
import org.csu.sm.exception.action.HandleAccountServiceException;
import org.csu.sm.exception.action.HandleInfoServiceException;
import org.csu.sm.exception.service.InfoManageServiceException;
import org.csu.sm.service.InfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ltaoj on 2017/8/8.
 */
@Controller
public class InfoManageActionBean extends AbstractActionBean{

    private InfoManageService infoManageService;

    @Autowired
    public InfoManageActionBean(InfoManageService infoManageService) {
        this.infoManageService = infoManageService;
    }

    @RequestMapping(value = "/basicInfo", method = RequestMethod.GET)
    public String showBasicInfo(@RequestParam(value = "userid", defaultValue = "") long studentId,
                                @RequestParam(value = "authenticated", defaultValue = "true") boolean authenticated,
                                Model model) {
        try {
            Student student = infoManageService.getBasicInfo(studentId);
            System.out.println("访问dao");
            model.addAttribute("student", student);
            model.addAttribute("collegeList", Constant.getColleges());
            return "student/basicInfo";
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "/upBasicInfo", method = RequestMethod.POST)
    public ResponseEntity<Result> updateBasicInfo(@RequestBody Student student) {
        try {
            infoManageService.modifyBasicInfo(student);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "学生基本信息更新成功",null ), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }
}
