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

    /*新闻列表*/
    @GetMapping()
    public String newsList(Model m){
        List<News> newsList = newsService.findAllNews();
        m.addAttribute("n_list", newsList);
        return "newsmanage";
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
        return "redirect:/news/newsList";

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
        tempNews.setAnnounceTime(new Date());
        News resultNews = newsService.createNews(tempNews);
        model.addAttribute("n", resultNews);//resultNews传给n
        return "redirect:/news/newsList";
    }
//



}
