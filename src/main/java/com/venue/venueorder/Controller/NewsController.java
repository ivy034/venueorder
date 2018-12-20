package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.News;
import com.venue.venueorder.Service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.NewsService;

import java.sql.Timestamp;
import java.util.Date;
import  java.util.List;

@Controller
@RequestMapping("/news")

public class NewsController {
    @Autowired
    private NewsService newsService;

    /*管理员查看新闻列表*/
    @GetMapping("/NewsList")
    public String managerNewsList(Model m){
        List<News> newsList = newsService.findAllNews();
        m.addAttribute("n_list", newsList);
        return "newsmanage";
    }

    /*用户查看新闻列表*/
    @GetMapping("/myNewsList\"")
    public String myNewsList(Model m){
        List<News> newsList = newsService.findAllNews();
        m.addAttribute("n_list", newsList);
        return "news";
    }


    /**
     * 删除指定id新闻
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteNews")
    public String  deleteNews(@RequestParam("id")Integer id) {
        News news = newsService.findOne(id);
        newsService.deleteNewsById(id);
        return "redirect:/news/NewsList";

    }

    /**
     * 添加新闻
     *
     * @param title
     * @param content
     * @return
     */
    @GetMapping("/addNews")
    public String addNews(@RequestParam("title") String title, @RequestParam("content") String content,@RequestParam("name")String author,Model model) {

        News tempNews = new News();
        tempNews.setTitle(title);
        tempNews.setContent(content);
        java.util.Date d=new java.util.Date();
        tempNews.setAnnounceTime(new Timestamp(d.getTime()));
        News resultNews = newsService.createNews(tempNews);
        return "redirect:/news/NewsList";
    }
//



}
