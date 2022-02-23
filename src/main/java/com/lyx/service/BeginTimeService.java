package com.lyx.service;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lyx.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author powered by lyx
 * @since 2020-07-31
 */
@Service("beginTimeService")
public class BeginTimeService
{
    @Autowired
    private ObjectMapper oMapper;
    
    public CommonResult duration()
    {
        Date now = DateUtil.date();
        Date beginTime = DateUtil.parseDateTime("2020-04-18 17:00:00");

        long allDays = DateUtil.between(beginTime, now, DateUnit.DAY); // 总天数
        long allHours = DateUtil.between(beginTime, now, DateUnit.HOUR); // 总小时数
        long allMinutes = DateUtil.between(beginTime, now, DateUnit.MINUTE); // 总分钟数

        // 1.只展示分钟 allMinutes
        String firstStr = allMinutes + "分";

        // 2.展示 xx时xx分
        long restMinutes = allMinutes - allHours * 60;
        String secondStr = StrUtil.format("{}时{}分", allHours, restMinutes);

        // 3.展示 xx天xx时xx分
        long restHours = allHours - allDays * 24;
        String thirdStr = StrUtil.format("{}天{}时{}分", allDays, restHours, restMinutes);

        ObjectNode objectNode = oMapper.createObjectNode();
        objectNode.put("firstStr", firstStr);
        objectNode.put("secondStr", secondStr);
        objectNode.put("thirdStr", thirdStr);

        return CommonResult.successData(objectNode);
    }
}
