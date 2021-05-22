//package com.drivinggrpc.driving.controller;
//
//import com.drivinggrpc.driving.po.Absentee;
//import com.drivinggrpc.driving.po.Graduate;
//import com.drivinggrpc.driving.po.UserApply;
//import com.drivinggrpc.driving.server.StudentAdminServer;
//import com.drivinggrpc.driving.tools.ApplicationTools;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Controller
//public class StudentAdminController {
//
//    private Logger logger = ApplicationTools.logger;
//    @Autowired
//    private StudentAdminServer studentAdminServer;
//
//    /**
//     * 初始化报名审批
//     * @param model
//     * @return
//     */
//    @GetMapping("/applyExamine")
//    public String applyExamine(Model model){
//        List<UserApply> userApplys = studentAdminServer.getUserApplys();
//        model.addAttribute("userApplys",userApplys);
//        logger.info("/applyExamine");
//        return "list1/list1_0";
//    }
//
//    /**
//     * 同意报名
//     * @param user_id
//     * @param model
//     * @return
//     */
//    @GetMapping("/applyExamine/consentApply")
//    public String consentApply(@RequestParam(value = "user_id")String user_id, Model model){
//        studentAdminServer.consentApply(user_id);
//        logger.info("/applyExamine/consentApply:userId="+user_id);
//        List<UserApply> userApplys = studentAdminServer.getUserApplys();
//        model.addAttribute("userApplys",userApplys);
//        return "list1/list1_0::list";
//    }
//
//    /**
//     * 拒绝报名
//     * @param user_id
//     * @param model
//     * @return
//     */
//    @GetMapping("/applyExamine/refuseApply")
//    public String refuseApply(@RequestParam(value = "user_id")String user_id,Model model){
//        studentAdminServer.refuseApply(user_id);
//        logger.info("/applyExamine/refuseApply:userId="+user_id);
//        List<UserApply> userApplys = studentAdminServer.getUserApplys();
//        model.addAttribute("userApplys",userApplys);
//        return "list1/list1_0::list";
//    }
//
//    /**
//     * 拉黑
//     * @param user_id
//     * @param model
//     * @return
//     */
//    @GetMapping("/applyExamine/block")
//    public String block(@RequestParam(value = "user_id")String user_id,Model model){
//        studentAdminServer.block(user_id);
//        logger.info("/applyExamine/block:userId="+user_id);
//        List<UserApply> userApplys = studentAdminServer.getUserApplys();
//        model.addAttribute("userApplys",userApplys);
//        return "list1/list1_0::list";
//    }
//
//    /**
//     * 查看信息
//     * @param user_id
//     * @return
//     */
//    @ResponseBody
//    @GetMapping("/applyExamine/examineApply")
//    public UserApply examineApply(@RequestParam(value = "user_id")String user_id){
//        UserApply apply = studentAdminServer.getUserApplyMessage(user_id);
//        logger.info("/applyExamine/examineApply:userId="+user_id);
//        return apply;
//    }
//
//    /**
//     * 初始化在籍学员
//     * @param model
//     * @return
//     */
//    @GetMapping("/absentee")
//    public String absentee(Model model){
//        List<UserApply> absentees = studentAdminServer.getUserAbsenteeAll();
//        model.addAttribute("absentees",absentees);
//        return "list1/list1_1";
//    }
//
//    /**
//     * 查看在籍学员信息
//     * @param user_id
//     * @return
//     */
//    @ResponseBody
//    @GetMapping("/absentee/examine")
//    public Absentee absenteeExamine(@RequestParam(value = "user_id")String user_id){
//        Absentee absentee = studentAdminServer.getUserAbsentee(user_id);
//        return absentee;
//    }
//
//    /**
//     * 初始化毕业学员
//     * @param model
//     * @return
//     */
//    @GetMapping("/graduate")
//    public String graduate(Model model){
//        List<Graduate> graduate = studentAdminServer.getGraduateAll();
//        model.addAttribute("graduates",graduate);
//        return "list1/list1_2";
//    }
//
//    /**
//     * 移除毕业学员
//     * @param user_id
//     * @param model
//     * @return
//     */
//    @GetMapping("/graduate/remove")
//    public String removeGraduate(@RequestParam(value = "user_id")String user_id,Model model){
//        studentAdminServer.removeGraduate(user_id);
//        logger.info("/graduate/remove:userId="+user_id);
//        List<Graduate> graduate = studentAdminServer.getGraduateAll();
//        model.addAttribute("graduates",graduate);
//        return "list1/list1_2::list";
//    }
//
//    /**
//     * 初始化黑名单
//     * @param model
//     * @return
//     */
//    @GetMapping("/blacklist")
//    public String blacklist(Model model){
//        List<Graduate> blacklist = studentAdminServer.getBlackListAll();
//        model.addAttribute("blacklists",blacklist);
//        return "list1/list1_3";
//    }
//
//    /**
//     * 移除黑名单
//     * @param user_id
//     * @param model
//     * @return
//     */
//    @GetMapping("/blacklist/remove")
//    public String removeBlacklist(@RequestParam(value = "user_id")String user_id,Model model){
//        studentAdminServer.removeGraduate(user_id);
//        logger.info("/blacklist/remove:userId="+user_id);
//        List<Graduate> blacklist = studentAdminServer.getBlackListAll();
//        model.addAttribute("blacklists",blacklist);
//        return "list1/list1_3::list";
//    }
//}
