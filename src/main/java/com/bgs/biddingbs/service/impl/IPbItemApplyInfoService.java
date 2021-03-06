package com.bgs.biddingbs.service.impl;

import com.bgs.biddingbs.mapper.AddPbItemApplyInfoMapper;
import com.bgs.biddingbs.pojo.PbItemApplyInfo;
import com.bgs.biddingbs.service.PbItemApplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPbItemApplyInfoService implements PbItemApplyInfoService {

    @Autowired
    private AddPbItemApplyInfoMapper addPbItemApplyInfoMapper;

    //项目申请添加
    @Override
    public int AddPbItemApplyInfo(PbItemApplyInfo pbItemApplyInfo) {
        String BianHao="AT-0";
        int number = (int)(Math.random()*99999);
        //生成批文编号
        pbItemApplyInfo.setApproval(BianHao+number);
        System.out.println("项目申请编号：=="+BianHao+number);
        return addPbItemApplyInfoMapper.AddPbItemApplyInfo(pbItemApplyInfo);
    }

    //查看当前委托人提交的所有项目申请书
    @Override
    public List<PbItemApplyInfo> PbItemApplyInfoAll(Long applyPersonId) {
        return addPbItemApplyInfoMapper.PbItemApplyInfoAll(applyPersonId);
    }

    @Override
    public PbItemApplyInfo SelectPbItemApplyInfo(String itemName) {
        return addPbItemApplyInfoMapper.SelectPbItemApplyInfo(itemName);
    }

    @Override
    public List<PbItemApplyInfo> PbItemApplyInfoStatusToOne() {
        return addPbItemApplyInfoMapper.PbItemApplyInfoStatusToOne();
    }
}
