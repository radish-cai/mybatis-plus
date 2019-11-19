package com.caitou.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caitou.mybatisplus.entity.Books;
import com.caitou.mybatisplus.mapper.BooksMapper;
import com.caitou.mybatisplus.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Mr.caitou
 * @since 2019-11-18
 */
@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements IBooksService {

    @Autowired
    BooksMapper booksMapper;

    @Override
    public List<Books> getAll() {
        QueryWrapper<Books> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .lambda()
                .select(Books::getBno, Books::getBname, Books::getPrice)
                .orderByDesc(Books::getPrice);
        return booksMapper.selectList(queryWrapper);
    }

    @Override
    public List<Books> getByPage(Integer page, Integer limit) {
        Page<Books> booksPage = new Page<>(page, limit);
        QueryWrapper<Books> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .lambda()
                .orderByDesc(Books::getPrice);
        IPage<Books> booksIPage = booksMapper.selectPage(booksPage, queryWrapper);
        List<Books> booksList = booksIPage.getRecords();
        return booksList;
    }

    @Override
    public Integer updateBook() {
        Books book = new Books();
        book.setBno(6);
        book.setBname("计算方法习题");
        book.setAuthor("上海交通大学");
        UpdateWrapper<Books> booksUpdateWrapper = new UpdateWrapper<>();
        booksUpdateWrapper
                .eq("BNO", book.getBno());
        return booksMapper.update(book, booksUpdateWrapper);
    }

    @Override
    public Integer deleteBook() {
        return booksMapper.deleteById(6);
    }
}
