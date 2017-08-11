package org.csu.sm.web;

import org.csu.sm.domain.*;
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

import java.util.List;

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

    /************************************** 页面跳转action ************************************/
    @RequestMapping(value = "/basicInfo", method = RequestMethod.GET)
    public String showBasicInfo(@RequestParam(value = "userid", defaultValue = "") long studentId,
                                @RequestParam(value = "authenticated", defaultValue = "true") boolean authenticated,
                                Model model) {
        try {
            Student student = infoManageService.getBasicInfo(studentId);
            model.addAttribute("student", student);
            model.addAttribute("collegeList", Constant.getColleges());
            return "student/basicInfo";
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "/parentsInfo", method = RequestMethod.GET)
    public String showParentsInfo(@RequestParam(value = "userid", defaultValue = "") long studentId,
                                  @RequestParam(value = "authenticated", defaultValue = "true") boolean authenticated,
                                  Model model) {
        try {
            List<Parent> parentList = infoManageService.getParentList(studentId);
            model.addAttribute("parentList", parentList);
            return "student/parentsInfo";
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "/awardSitu", method = RequestMethod.GET)
    public String showAwardSitu(@RequestParam(value = "userid", defaultValue = "") long studentId,
                                @RequestParam(value = "authenticated", defaultValue = "true") boolean authenticated,
                                Model model) {
        try {
            List<AwardRecord> awardList = infoManageService.getAwardList(studentId);
            model.addAttribute("awardList", awardList);
            return "student/awardSitu";
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "/failexamSitu", method = RequestMethod.GET)
    public String showFailexamSitu(@RequestParam(value = "userid", defaultValue = "") long studentId,
                                @RequestParam(value = "authenticated", defaultValue = "true") boolean authenticated,
                                Model model) {
        try {
            List<FailexamRecord> failedList = infoManageService.getFailexamList(studentId);
            model.addAttribute("failedList", failedList);
            return "student/failexamSitu";
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    /************************************ json交互action **************************************/

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
