package com.caitou.mybatisplus.service;

import com.caitou.mybatisplus.entity.Books;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Mr.caitou
 * @since 2019-11-18
 */
public interface IBooksService extends IService<Books> {

    /**
     * 新增
     *
     * @return
     */
    Integer addBook();

    /**
     * 获取全部
     *
     * @return
     */
    List<Books> getAll();

    /**
     * 分页
     *
     * @param page  页码
     * @param limit 条数
     * @return
     */
    List<Books> getByPage(Integer page, Integer limit);

    /**
     * 自定义SQL的同时使用mybatis-plus的条件构造器wrapper和分页
     *
     * @param page  页码
     * @param limit 条数
     * @return
     */
    List<Books> getBySQLPage(Integer page, Integer limit);

    /**
     * 更新
     *
     * @return
     */
    Integer updateBook();

    /**
     * 根据id删除
     *
     * @return
     */
    Integer deleteBookById();

    /**
     * 根据条件构造器删除（批量删除）
     *
     * @return
     */
    Integer deleteBook();
}
