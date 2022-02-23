package com.lyx.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lyx.common.CommonResult;
import com.lyx.entity.BeginTime;
import com.lyx.mapper.BeginTimeMapper;
import com.lyx.service.IBeginTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author powered by lyx
 * @since 2020-07-31
 */
@Service("beginTimeServiceImpl")
public class BeginTimeServiceImpl extends ServiceImpl<BeginTimeMapper, BeginTime> implements IBeginTimeService
{
	@Autowired
	private ObjectMapper oMapper;

	@Override
	public CommonResult duration()
	{
		BeginTime beginTimeObject = this.list().get(0);
		if (Objects.isNull(beginTimeObject))
		{
			return CommonResult.errorMsg("开始时间不存在，先去数据库添加开始时间.");
		}

		Date now = DateUtil.date();
		Date beginTime = beginTimeObject.getBeginTime();

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