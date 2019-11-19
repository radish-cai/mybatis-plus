package com.caitou.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caitou.mybatisplus.entity.Books;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Mr.caitou
 * @since 2019-11-18
 */
@Component
public interface BooksMapper extends BaseMapper<Books> {

    /**
     * 自定义SQL的同时使用mybatis-plus的条件构造器wrapper和分页
     *
     * @param page         mybatis-plus封装的分页对象
     * @param queryWrapper 条件构造器
     * @return
     */
    @Select("select * from books ${ew.customSqlSegment}")
    List<Books> getBySQLPage(@Param("page") Page<Books> page, @Param(Constants.WRAPPER) QueryWrapper<Books> queryWrapper);
}
