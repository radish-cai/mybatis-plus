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
        iBooksService.getAll().forEach(System.out::println);
    }

}
