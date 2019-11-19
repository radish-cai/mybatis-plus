package com.caitou.mybatisplus;

import com.caitou.mybatisplus.service.IBooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    IBooksService iBooksService;

    @Test
    void contextLoads() {
        //System.out.println(iBooksService.addBook());
        //iBooksService.getAll().forEach(System.out::println);
        //iBooksService.getByPage(1, 3).forEach(System.out::println);
        //iBooksService.getBySQLPage(1, 3).forEach(System.out::println);
        //System.out.println(iBooksService.updateBook());
        //System.out.println(iBooksService.deleteBookById());
        System.out.println(iBooksService.deleteBook());
    }

}
