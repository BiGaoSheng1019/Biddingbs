package com.bgs.biddingbs.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bgs.biddingbs.config.Result;
import com.bgs.biddingbs.mapper.PbItemInfoMapper;
import com.bgs.biddingbs.pojo.PbItemInfo;
import com.bgs.biddingbs.pojo.PbItemObjectInfo;
import com.bgs.biddingbs.pojo.PbQuoteInfo;
import com.bgs.biddingbs.service.PbItemInfoService;
import com.bgs.biddingbs.service.PbObjectInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 项目信息表 前端控制器
 * </p>
 *
 * @author xieCode
 * @since 2020-11-25
 */
@RestController
@RequestMapping("/pb-item-info")
public class PbItemInfoController {
    @Autowired
    private PbItemInfoService itemInfoService;
    @PostMapping("selectPbItemInfo/{pageSize}/{currentPage}" )
    /**
     * 查询竞价厅 BiddingHall.jsp
     */
    @ApiOperation(value = "查询竞价厅",httpMethod = "POST")
    public Map selectPbItemInfo(@PathVariable Integer pageSize, @PathVariable Integer currentPage, @RequestBody PbItemObjectInfo itemObjectInfo){
        IPage<PbItemObjectInfo> pbItemInfoPage = new Page<>(currentPage,pageSize);
        IPage<PbItemObjectInfo> pbItemInfos =  itemInfoService.selectPbItemInfo(pbItemInfoPage,itemObjectInfo.getItemName(),itemObjectInfo.getResourceType());
        /*PageInfo<PbItemInfo> pbItemInfos = itemInfoService.selectPbItemInfo(pageSize,currentPage,pbItemInfo.getItemName(),pbItemInfo.getResourceType());
        System.out.println(pbItemInfos.getList());
        List<PbItemInfo> itemInfos = pbItemInfoMapper.selectPbItemInfo(null, null);
        System.out.println(itemInfos);*/
        Map map = new HashMap();
        map.put("current",pbItemInfos.getCurrent());
        map.put("pages",pbItemInfos.getPages());
        map.put("data",pbItemInfos.getRecords());
        map.put("size",pbItemInfos.getSize());
        map.put("total",pbItemInfos.getTotal());
        map.put("code",200);
        map.put("msg","查询成功");
        return map;
    }
    @GetMapping("selectBiddingHall/{pageSize2}/{currentPage2}/{itemId}" )
    /**
     * 查询竞价厅 BiddingHall.jsp
     */
    @ApiOperation(value = "查询竞价记录",httpMethod = "GET")
    public Map selectBiddingHall(@PathVariable Integer pageSize2, @PathVariable Integer currentPage2,@PathVariable Integer itemId){
        IPage<PbQuoteInfo> pbItemInfoPage = new Page<>(currentPage2,pageSize2);
        IPage<PbQuoteInfo> pbItemInfos =  itemInfoService.selectBiddingHall(pbItemInfoPage,itemId);
        /*PageInfo<PbItemInfo> pbItemInfos = itemInfoService.selectPbItemInfo(pageSize,currentPage,pbItemInfo.getItemName(),pbItemInfo.getResourceType());
        System.out.println(pbItemInfos.getList());
        List<PbItemInfo> itemInfos = pbItemInfoMapper.selectPbItemInfo(null, null);
        System.out.println(itemInfos);*/
        Map map = new HashMap();
        map.put("current",pbItemInfos.getCurrent());
        map.put("pages",pbItemInfos.getPages());
        map.put("data",pbItemInfos.getRecords());
        map.put("size",pbItemInfos.getSize());
        map.put("total",pbItemInfos.getTotal());
        map.put("code",200);
        map.put("msg","查询成功");
        return map;
//        return new Result(true,200,"查询成功",pbQuoteInfos);
    }

}

