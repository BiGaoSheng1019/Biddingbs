package com.bgs.biddingbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bgs.biddingbs.pojo.PbItemInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bgs.biddingbs.pojo.PbItemObjectInfo;
import com.bgs.biddingbs.pojo.PbQuoteInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 * 项目信息表 服务类
 * </p>
 *
 * @author xieCode
 * @since 2020-11-25
 */
public interface PbItemInfoService extends IService<PbItemInfo> {
    IPage<PbItemObjectInfo> selectPbItemInfo(IPage<PbItemObjectInfo> pbItemInfoPage, String itemName, Integer resourceType);

    IPage<PbQuoteInfo> selectBiddingHall(IPage<PbQuoteInfo> pbItemInfoPage, Integer itemId);

//    PageInfo<PbItemInfo> selectPbItemInfo(Integer pageSize, Integer currentPage, String itemName, Integer resourceType);
}
