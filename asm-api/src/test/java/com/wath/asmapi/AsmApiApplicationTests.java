package com.wath.asmapi;

import com.wath.asmapi.repository.ArticleRepository;
import com.wath.asmapi.repository.CategoryRepository;
import com.wath.asmapi.repository.dto.ArticleDto;
import com.wath.asmapi.repository.dto.CategoryDto;
import com.wath.asmapi.service.imp.ArticleServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AsmApiApplicationTests {

    @Autowired
    ArticleServiceImp articleServiceImp;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
        System.out.println(articleServiceImp.getArticleInPopularCategory().size());
    }

}
