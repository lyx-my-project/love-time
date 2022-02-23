package com.lyx.service;

import com.lyx.common.CommonResult;
import com.lyx.entity.BeginTime;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author powered by lyx
 * @since 2020-07-31
 */
public interface IBeginTimeService extends IService<BeginTime>
{
	/**
	 * 获得持续时间
	 */
	CommonResult duration();
}
