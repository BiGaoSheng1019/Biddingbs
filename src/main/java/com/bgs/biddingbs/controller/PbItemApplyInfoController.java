package com.bgs.biddingbs.controller;

import com.bgs.biddingbs.config.BaseResponse;
import com.bgs.biddingbs.config.StatusCode;
import com.bgs.biddingbs.pojo.PbItemApplyInfo;
import com.bgs.biddingbs.service.PbItemApplyInfoService;
import io.swagger.models.auth.In;
import org.omg.CORBA.BAD_CONTEXT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 项目交易申请控制层
 */
@RestController
@RequestMapping("PbItemApplyInfoCon")
public class PbItemApplyInfoController {


//    注入service
    @Autowired
    private PbItemApplyInfoService pbItemApplyInfoService;


    //查看当前委托人提交的所有项目申请书
    @RequestMapping("PbItemApplyInfoAll")
    @ResponseBody
    public BaseResponse PbItemApplyInfoAll(Long applyPersonId){

        List<PbItemApplyInfo> pbItemApplyInfoList = pbItemApplyInfoService.PbItemApplyInfoAll(applyPersonId);

        return new BaseResponse(StatusCode.Success,pbItemApplyInfoList);
    }

    //项目申请添加
    @RequestMapping("PbItemApplyInfoAdd")
    public BaseResponse PbItemApplyInfoAdd(@RequestBody PbItemApplyInfo pbItemApplyInfo){

        //添加前查询项目名称是否存在
        PbItemApplyInfo itemName1 = pbItemApplyInfoService.SelectPbItemApplyInfo(pbItemApplyInfo.getItemName());
        if(itemName1!=null){
            //如果存在直接返回
            return new BaseResponse(StatusCode.Fail);
        }else
        pbItemApplyInfoService.AddPbItemApplyInfo(pbItemApplyInfo);
        return new BaseResponse(StatusCode.Success);
    }

    //删除被退回的项目
    @RequestMapping("PbItemApplyInfoDel")
    public BaseResponse PbItemApplyInfoDel(@RequestBody Map<String,Object> map){

        System.out.println(map.get("seqId")+"==删除成功");

        return new BaseResponse(StatusCode.Success);
    }


    //处长查询委托人提交的
    @RequestMapping("PbItemApplyInfoStatusToOne")
    public BaseResponse PbItemApplyInfoStatusToOne(){

        System.out.println(1);

        List<PbItemApplyInfo> pbItemApplyInfoList = pbItemApplyInfoService.PbItemApplyInfoStatusToOne();

        if(pbItemApplyInfoList==null){
            return new BaseResponse(StatusCode.Fail,"当前没有人申请！");
        }


        return new BaseResponse(StatusCode.Success,pbItemApplyInfoList);
    }


}
