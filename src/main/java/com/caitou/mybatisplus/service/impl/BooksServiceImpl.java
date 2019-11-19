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

    /**
     * 新增
     *
     * @return
     */
    @Override
    public Integer addBook() {
        Books book = new Books();
        book.setBno(8);
        book.setBname("Java编程思想");
        book.setAuthor("埃克尔");
        book.setPrice(108);
        return booksMapper.insert(book);
    }

    /**
     * 获取全部
     *
     * @return
     */
    @Override
    public List<Books> getAll() {
        //条件构造器
        QueryWrapper<Books> queryWrapper = new QueryWrapper<>();

        /**
         * 1.指定获取部分列，并按某列降序输出
         * a."BNO", "BNAME", "PRICE"等均为表字段名
         */
//        queryWrapper
//                .select("BNO", "BNAME", "PRICE")//指定获取部分列
//                .ge("PRICE", 30)//PRICE大于等于30元
//                .orderByDesc("PRICE");//按某列降序输出

        /**
         * 2.指定获取部分列，并按某列降序输出
         * a.与第1点不同的是，第2点使用的是Lambda语法的格式，比较方便
         * b.两者之间是等效的
         */
        queryWrapper
                .lambda()//声明使用lambda语法表达式
                .select(Books::getBno, Books::getBname, Books::getPrice)//指定获取部分列
                .ge(Books::getPrice, 30)//PRICE大于等于30元
                .orderByDesc(Books::getPrice);//按某列降序输出

        /**
         * queryWrapper等价于where
         * queryWrapper可以为null，意味着不需要按条件查找数据，直接获取全部
         * 如果不为null，mybatis-plus会自动将条件构造器中的条件以sql的形式拼接到原生封装的sql中
         */
        return booksMapper.selectList(queryWrapper);
    }

    /**
     * 分页
     *
     * @param page  页码
     * @param limit 条数
     * @return
     */
    @Override
    public List<Books> getByPage(Integer page, Integer limit) {
        Page<Books> booksPage = new Page<>(page, limit);
        QueryWrapper<Books> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .lambda()
                .gt(Books::getPrice, 30)
                .orderByDesc(Books::getPrice);
        IPage<Books> booksIPage = booksMapper.selectPage(booksPage, queryWrapper);
        List<Books> booksList = booksIPage.getRecords();
        return booksList;
    }

    /**
     * 自定义SQL的同时使用mybatis-plus的条件构造器wrapper和分页
     *
     * @param page  页码
     * @param limit 条数
     * @return
     */
    @Override
    public List<Books> getBySQLPage(Integer page, Integer limit) {
        Page<Books> booksPage = new Page<>(page, limit);
        QueryWrapper<Books> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .lambda()
                .gt(Books::getPrice, 50)
                .orderByDesc(Books::getPrice);
        List<Books> booksList = booksMapper.getBySQLPage(booksPage, queryWrapper);
        return booksList;
    }

    /**
     * 更新
     *
     * @return
     */
    @Override
    public Integer updateBook() {
        /**
         * 新建一个待更新的实体
         */
        Books book = new Books();
        book.setBno(6);
        book.setBname("操作系统习题");
        book.setAuthor("浙江大学");

        //条件构造器
        UpdateWrapper<Books> booksUpdateWrapper = new UpdateWrapper<>();

        //1.非lambda表达式
//        booksUpdateWrapper
//                .eq("BNO", book.getBno());//当BNO等于6时

        //2.lambda表达式
        booksUpdateWrapper
                .lambda()
                .eq(Books::getBno, book.getBno());//当BNO等于6时

        /**
         * booksUpdateWrapper同样等价于where
         * booksUpdateWrapper可以为null，但此时相当于update没有where，整张表会被同时更新
         * booksUpdateWrapper不为null，只会更新符合条件的记录
         * booksUpdateWrapper最好不为null，除非在某些特定情况下
         */
        return booksMapper.update(book, booksUpdateWrapper);
    }

    /**
     * 根据id删除
     *
     * @return
     */
    @Override
    public Integer deleteBookById() {
        return booksMapper.deleteById(9);
    }

    /**
     * 根据条件构造器删除（批量删除）
     *
     * @return
     */
    @Override
    public Integer deleteBook() {
        QueryWrapper<Books> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .lambda()
                .lt(Books::getPrice, 10);//将价格小于10的都删掉
        return booksMapper.delete(queryWrapper);
    }
}
