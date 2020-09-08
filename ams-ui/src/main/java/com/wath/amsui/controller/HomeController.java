package com.wath.amsui.controller;

import com.wath.amsui.retrofit.model.Article;
import com.wath.amsui.retrofit.model.Category;
import com.wath.amsui.service.ArticleService;
import com.wath.amsui.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import retrofit2.http.GET;

import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {

    private ArticleService articleService;
    private CategoryService categoryService;

    @Value("${api.img-uri}")
    String imageUri;

    @Autowired
    public HomeController(ArticleService articleService,CategoryService categoryService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String index(ModelMap map){
        int i = 0;
        List<Article> popularArticle = articleService.getPopularArticle().getData();

        map.addAttribute("articles",articleService.getRecentArticle().getData());
        map.addAttribute("imageUri",imageUri);

        for(Article article:popularArticle){
            int cid = article.getCategory().getId();
            Category category = new Category();
            category.setId(cid);
            category.setName(categoryService.getCategoryByID(cid).join().getData().getName());
            popularArticle.get(i).setCategory(category);
            i++;
        }
        map.addAttribute("popularArticles",popularArticle);

        map.addAttribute("relateCategory",categoryService.getCategories().getData());
        return "homepage";
    }
}
