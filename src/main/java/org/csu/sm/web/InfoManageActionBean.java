package org.csu.sm.web;

import org.csu.sm.domain.*;
import org.csu.sm.exception.action.HandleFileUploadException;
import org.csu.sm.exception.action.HandleInfoServiceException;
import org.csu.sm.exception.action.HandleTransationException;
import org.csu.sm.exception.service.AccountServiceException;
import org.csu.sm.exception.service.InfoManageServiceException;
import org.csu.sm.exception.service.TransationException;
import org.csu.sm.service.AccountService;
import org.csu.sm.service.InfoManageService;
import org.csu.sm.util.ConfigUtil;
import org.csu.sm.util.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    public String getPrincipal(){
        String userId=null;
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            userId=((UserDetails) principal).getUsername();
        }else{
            userId=principal.toString();
        }
        return userId;
    }
    /************************************** 页面跳转action ************************************/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showStudentHome() {
        return "student/basicInfo";
    }

    @RequestMapping(value = "/basicInfo", method = RequestMethod.GET)
    public String showBasicInfo(
//            @RequestParam(value = "userid", defaultValue = "") long studentId,
//                                @RequestParam(value = "authenticated", defaultValue = "true") boolean authenticated,
                                Model model) {
        try {
            Student student = infoManageService.getBasicInfo(Long.valueOf(getPrincipal()));
            model.addAttribute("student", student);
            model.addAttribute("collegeList", Constant.getColleges());
            return "student/basicInfo";
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "/parentsInfo", method = RequestMethod.GET)
    public String showParentsInfo(
//            @RequestParam(value = "userid", defaultValue = "") long studentId,
//                                  @RequestParam(value = "authenticated", defaultValue = "true") boolean authenticated,
                                  Model model) {
        try {
            List<Parent> parentList = infoManageService.getParentList(Long.valueOf(getPrincipal()));
            model.addAttribute("parentList", parentList);
            return "student/parentsInfo";
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "/awardSitu", method = RequestMethod.GET)
    public String showAwardSitu(
//            @RequestParam(value = "userid", defaultValue = "") long studentId,
//                                @RequestParam(value = "authenticated", defaultValue = "true") boolean authenticated,
                                Model model) {
        try {
            List<AwardRecord> awardList = infoManageService.getAwardList(Long.valueOf(getPrincipal()));
            model.addAttribute("awardList", awardList);
            return "student/awardSitu";
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "/failexamSitu", method = RequestMethod.GET)
    public String showFailexamSitu(
//            @RequestParam(value = "userid", defaultValue = "") long studentId,
//                                   @RequestParam(value = "authenticated", defaultValue = "true") boolean authenticated,
                                   Model model) {
        try {
            List<FailexamRecord> failedList = infoManageService.getFailexamList(Long.valueOf(getPrincipal()));
            model.addAttribute("failedList", failedList);
            return "student/failexamSitu";
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "withdrawInst", method = RequestMethod.GET)
    public String showWithdrawInst(
//            @RequestParam(value = "userid", defaultValue = "") long studentId,
//                                   @RequestParam(value = "authenticated", defaultValue = "true") boolean authenticated,
                                   Model model) {
        try {
            List<WithdrawInst> withdrawInstList = infoManageService.getWithdrawInstList(Long.valueOf(getPrincipal()));
            model.addAttribute("withdrawInstList", withdrawInstList);
            return "student/withdrawInst";
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.GET)
    public String showChangePassword(Model model){
        try {
            Student student = infoManageService.getBasicInfo(Long.valueOf(getPrincipal()));
            model.addAttribute("student", student);
            return "student/changePassword";
        }catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }
    /************************************ json交互action **************************************/

    @RequestMapping(value = "/upBasicInfo", method = RequestMethod.POST)
    public ResponseEntity<Result> updateBasicInfo(@RequestBody Student student) {
        try {
            student.setStudentId(Long.valueOf(getPrincipal()));
            infoManageService.modifyBasicInfo(student);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "学生基本信息更新成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "addMember", method = RequestMethod.POST)
    public ResponseEntity<Result> insertParent(@RequestBody Parent parent) {
        try {
            parent.setStudentId(Long.valueOf(getPrincipal()));
            infoManageService.addParentInfo(parent);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "成员添加成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "upMember", method = RequestMethod.POST)
    public ResponseEntity<Result> updateParent(@RequestBody Parent parent) {
        try {
            parent.setStudentId(Long.valueOf(getPrincipal()));
            infoManageService.modifyParentInfo(parent);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "更新成员信息成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "delMember", method = RequestMethod.POST)
    public ResponseEntity<Result> deleteMember(@RequestBody Parent parent) {
        try {
            parent.setStudentId(Long.valueOf(getPrincipal()));
            List<Parent> parentList = infoManageService.deleteParentInfo(parent);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "成员删除成功", parentList), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "/addAward", method = RequestMethod.POST)
    public ResponseEntity<Result> insertAward(@RequestBody AwardRecord awardRecord) {
        try {
            awardRecord.setStudentId(Long.valueOf(getPrincipal()));
            infoManageService.addAwardInfo(awardRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "奖励记录添加成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "upAward", method = RequestMethod.POST)
    public ResponseEntity<Result> updateAward(@RequestBody AwardRecord awardRecord) {
        try {
            awardRecord.setStudentId(Long.valueOf(getPrincipal()));
            infoManageService.modifyAwardInfo(awardRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "获奖记录更新成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "delAward", method = RequestMethod.POST)
    public ResponseEntity<Result> deleteAward(@RequestBody AwardRecord awardRecord) {
        try {
            awardRecord.setStudentId(Long.valueOf(getPrincipal()));
            List<AwardRecord> awardList = infoManageService.deleteAwardInfo(awardRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "删除获奖记录成功", awardList), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "addFailed", method = RequestMethod.POST)
    public ResponseEntity<Result> insertFailed(@RequestBody FailexamRecord failexamRecord) {
        try {
            failexamRecord.setStudentId(Long.valueOf(getPrincipal()));
            infoManageService.addFailexamInfo(failexamRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "挂科记录添加成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "upFailed", method = RequestMethod.POST)
    public ResponseEntity<Result> updateFailed(@RequestBody FailexamRecord failexamRecord) {
        try {
            failexamRecord.setStudentId(Long.valueOf(getPrincipal()));
            infoManageService.modifyFailexamInfo(failexamRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "挂科记录修改成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "delFailed", method = RequestMethod.POST)
    public ResponseEntity<Result> deleteAward(@RequestBody FailexamRecord failexamRecord) {
        try {
            failexamRecord.setStudentId(Long.valueOf(getPrincipal()));
            List<FailexamRecord> failedList = infoManageService.deleteFailexamInfo(failexamRecord);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "挂科记录删除成功", failedList), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }

    @RequestMapping(value = "addWithdrawInst", method = RequestMethod.POST)
    public ResponseEntity<Result> insertWithdrawInst(@RequestPart("instPicture") MultipartFile instPicture,
                                                     WithdrawInst withdrawInst, HttpServletRequest request) throws HandleFileUploadException {
        String path = request.getSession().getServletContext().getRealPath("upImg");
        ConfigUtil.setPath(path);
        try {
            withdrawInst.setStudentId(Long.valueOf(getPrincipal()));
            String fileName = instPicture.getOriginalFilename();
            String targetName = (new Date().getTime()) + "_" + withdrawInst.getStudentId() + "_" + fileName;
            String picName = IOUtil.saveFile(targetName, path, instPicture);
            withdrawInst.setDescription("upImg/" + picName);
            List<WithdrawInst> withdrawInstList =  infoManageService.addWithdrawInstInfo(withdrawInst);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "运动员退队信息添加成功", withdrawInstList), HttpStatus.OK);
        } catch (IOException e) {
            throw new HandleFileUploadException(e);
        } catch (TransationException e) {
            throw new HandleTransationException(e);
        }
    }

    @RequestMapping(value = "upWithdrawInst", method = RequestMethod.POST)
    public ResponseEntity<Result> upWithdrawInst(@RequestPart("editPicture") MultipartFile editPicture,
                                                 WithdrawInst withdrawInst, HttpServletRequest request) throws HandleFileUploadException {
        String path = request.getSession().getServletContext().getRealPath("upImg");
        ConfigUtil.setPath(path);
        try {
            withdrawInst.setStudentId(Long.valueOf(getPrincipal()));
            String fileName = editPicture.getOriginalFilename();
            String targetName = (new Date().getTime()) + "_" + withdrawInst.getStudentId() + "_" + fileName;
            String picName = IOUtil.saveFile(targetName, path, editPicture);
            if (!picName.equals("")) withdrawInst.setDescription("upImg/" + picName);
            List<WithdrawInst> withdrawInstList = infoManageService.modifyWithdrawInstInfo(withdrawInst);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "运动员退队信息修改成功", withdrawInstList), HttpStatus.OK);
        } catch (IOException e) {
            throw new HandleFileUploadException(e);
        } catch (TransationException e) {
            throw new HandleTransationException(e);
        }
    }

    @RequestMapping(value = "delWithdrawInst", method = RequestMethod.POST)
    public ResponseEntity<Result> deleteWithdrawInst(@RequestBody WithdrawInst withdrawInst, HttpServletRequest request) {
        try {
            withdrawInst.setStudentId(Long.valueOf(getPrincipal()));
            WithdrawInst withdrawInst1 = infoManageService.getWithdrawInst(withdrawInst.getInstId());
            WithdrawInst deletedInst = infoManageService.deleteWithdrawInstInfo(withdrawInst1);
            String path = request.getSession().getServletContext().getRealPath("upImg");
            path = path.substring(0, path.lastIndexOf(System.getProperty("file.separator")));
            IOUtil.removeFile(deletedInst.getDescription(), path);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "退队说明删除成功", null), HttpStatus.OK);
        } catch (InfoManageServiceException e) {
            throw new HandleInfoServiceException(e);
        }
    }


}