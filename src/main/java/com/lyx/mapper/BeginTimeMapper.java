package com.lyx.mapper;

import com.lyx.entity.BeginTime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author powered by lyx
 * @since 2020-07-31
 */
@Mapper
@Repository
public interface BeginTimeMapper extends BaseMapper<BeginTime> {

}
