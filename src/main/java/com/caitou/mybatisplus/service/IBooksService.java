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

    List<Books> getAll();

    List<Books> getByPage(Integer page, Integer limit);

    Integer updateBook();

    Integer deleteBook();
}
