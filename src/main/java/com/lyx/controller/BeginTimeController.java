package com.lyx.controller;

import com.lyx.common.CommonResult;
import com.lyx.entity.BeginTime;
import com.lyx.service.IBeginTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author powered by lyx
 * @since 2020-07-31
 */
@RestController
public class BeginTimeController
{
	@Autowired
	@Qualifier("beginTimeServiceImpl")
	private IBeginTimeService beginTimeService;

	/**
	 * 获得持续时间
	 */
	@GetMapping("/duration")
	public CommonResult duration()
	{
		return beginTimeService.duration();
	}

	/**
	 * 是否有开始时间
	 * @return true-有开始时间  false-没有开始时间
	 */
	@GetMapping("/have")
	public CommonResult havBeginTime()
	{
		return Objects.nonNull(beginTimeService.getById(1).getBeginTime()) ? CommonResult.successData(true) : CommonResult.successData(false);
	}
}