package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.News;
import com.venue.venueorder.Service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.NewsService;

import java.util.Date;
import  java.util.List;

@Controller
@RequestMapping("/news")

public class NewsController {
    @Autowired
    private NewsService newsService;

    /**
     * 删除指定id消息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteNews")
    public Object deleteNews(@RequestParam("id") Integer id) {
        newsService.deleteNewsById(id);
        return "news";

    }

    /**
     * 添加消息
     *
     * @param title
     * @param content
     * @return
     */
    @RequestMapping(value = "/addNews")
    public String addNews(@RequestParam("title") String title, @RequestParam("content") String content, Model model) {

        News tempNews = new News();
        tempNews.setTitle(title);
        tempNews.setContent(content);
        tempNews.setAnnounceTime(new Date());
        News resultNews = newsService.createNews(tempNews);
        model.addAttribute("n", resultNews);//resultNews传给n
        return "news";
    }
}
