package com.lyx;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class AppTests
{
	public static void main(String[] args)
	{
		Date beginTime = DateUtil.parse("2020-01-01 23:08:00");
		Date now = DateUtil.parse("2020-01-03 24:08:00");

		long allHours = DateUtil.between(beginTime, now, DateUnit.HOUR); // 总小时数
		long allMinutes = DateUtil.between(beginTime, now, DateUnit.MINUTE); // 总分钟数

		long restMinutes = allMinutes - allHours * 60;


		System.out.println(allHours + "小时" + restMinutes + "分");
	}
}
