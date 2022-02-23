package com.lyx.controller;

import com.lyx.common.CommonResult;
import com.lyx.service.BeginTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@Qualifier("beginTimeService")
	private BeginTimeService beginTimeService;

	/**
	 * 获得持续时间
	 */
	@GetMapping("/duration")
	public CommonResult duration()
	{
		return beginTimeService.duration();
	}
}
