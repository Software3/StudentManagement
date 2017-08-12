package org.csu.sm.web;

import com.sun.org.apache.regexp.internal.RE;
import org.csu.sm.domain.*;
import org.csu.sm.exception.action.HandleAccountServiceException;
import org.csu.sm.exception.action.HandleFileUploadException;
import org.csu.sm.exception.action.HandleInfoServiceException;
import org.csu.sm.exception.service.InfoManageServiceException;
import org.csu.sm.service.InfoManageService;
import org.csu.sm.util.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by ltaoj on 2017/8/8.
 */
@Controller
public class InfoManageActionBean extends AbstractActionBean {

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
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "学生基本信息更新成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "addMember", method = RequestMethod.POST)
    public ResponseEntity<Result> insertParent(@RequestBody Parent parent) {
        try {
            infoManageService.addParentInfo(parent);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "成员添加成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "upMember", method = RequestMethod.POST)
    public ResponseEntity<Result> updateParent(@RequestBody Parent parent) {
        try {
            infoManageService.modifyParentInfo(parent);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "更新成员信息成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "delMember", method = RequestMethod.POST)
    public ResponseEntity<Result> deleteMember(@RequestBody Parent parent) {
        try {
            List<Parent> parentList = infoManageService.deleteParentInfo(parent);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "成员删除成功", parentList), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "addAward", method = RequestMethod.POST)
    public ResponseEntity<Result> insertAward(@RequestBody AwardRecord awardRecord) {
        try {
            infoManageService.addAwardInfo(awardRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "奖励记录添加成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "upAward", method = RequestMethod.POST)
    public ResponseEntity<Result> updateAward(@RequestBody AwardRecord awardRecord) {
        try {
            infoManageService.modifyAwardInfo(awardRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "获奖记录更新成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "delAward", method = RequestMethod.POST)
    public ResponseEntity<Result> deleteAward(@RequestBody AwardRecord awardRecord) {
        try {
            List<AwardRecord> awardList = infoManageService.deleteAwardInfo(awardRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "删除获奖记录成功", awardList), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "addFailed", method = RequestMethod.POST)
    public ResponseEntity<Result> insertFailed(@RequestBody FailexamRecord failexamRecord) {
        try {
            infoManageService.addFailexamInfo(failexamRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "挂科记录添加成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "upFailed", method = RequestMethod.POST)
    public ResponseEntity<Result> updateFailed(@RequestBody FailexamRecord failexamRecord) {
        try {
            infoManageService.modifyFailexamInfo(failexamRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "挂科记录修改成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "delFailed", method = RequestMethod.POST)
    public ResponseEntity<Result> deleteAward(@RequestBody FailexamRecord failexamRecord) {
        try {
            List<FailexamRecord> failedList = infoManageService.deleteFailexamInfo(failexamRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "挂科记录删除成功", failedList), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "addWithdrawInst", method = RequestMethod.POST)
    public ResponseEntity<Result> insertWithdrawInst(@RequestPart("instPicture") MultipartFile instPicture,
                                                     WithdrawInst withdrawInst, HttpServletRequest request) throws HandleFileUploadException {
        try {
            String path = request.getSession().getServletContext().getRealPath("upImg");
            String fileName = instPicture.getOriginalFilename();
            String targetName = (new Date().getTime()) + "_" + fileName + "_" + withdrawInst.getStudentId();
            IOUtil.saveFile(targetName, path, instPicture);
            List<WithdrawInst> withdrawInstList =  infoManageService.addWithdrawInstInfo(withdrawInst);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "运动员退队信息添加成功", withdrawInstList), HttpStatus.OK);
        } catch (IOException e) {
            throw new HandleFileUploadException(e);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "upWithdrawInst", method = RequestMethod.POST)
    public ResponseEntity<Result> upWithdrawInst(@RequestPart("instPicture") MultipartFile instPicture,
                                                 WithdrawInst withdrawInst, HttpServletRequest request) throws HandleFileUploadException {
        try {
            String path = request.getSession().getServletContext().getRealPath("upImg");
            String fileName = instPicture.getOriginalFilename();
            String targetName = (new Date().getTime()) + "_" + fileName + "_" + withdrawInst.getStudentId();
            IOUtil.saveFile(targetName, path, instPicture);
            withdrawInst.setDescribe("upImg/" + targetName);
            infoManageService.modifyWithdrawInstInfo(withdrawInst);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "运动员退队信息修改成功", null), HttpStatus.OK);
        } catch (IOException e) {
            throw new HandleFileUploadException(e);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "delWithdrawInst", method = RequestMethod.POST)
    public ResponseEntity<Result> deleteWithdrawInst(@RequestBody WithdrawInst withdrawInst, HttpServletRequest request) {
        try {
            WithdrawInst withdrawInst1 = infoManageService.getWithdrawInst(withdrawInst.getInstId());
            WithdrawInst deletedInst = infoManageService.deleteWithdrawInstInfo(withdrawInst);
            String path = request.getSession().getServletContext().getRealPath("upImg");
            IOUtil.removeFile(deletedInst.getDescribe(), path);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "退队说明删除成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

}