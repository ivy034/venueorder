package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Manager;
import com.venue.venueorder.DO.News;
import com.venue.venueorder.DO.User;
import com.venue.venueorder.Service.ManagerService;
import com.venue.venueorder.Service.UserService;
import com.venue.venueorder.Service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.NewsService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.xml.ws.FaultAction;
import java.sql.Timestamp;
import java.util.Date;
import  java.util.List;

@Controller
@RequestMapping("/news")

public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private UserService userService;
    @Autowired
    private ManagerService managerService;

    /*管理员查看新闻列表*/
    @GetMapping("/newsList")
    public String managerNewsList(@RequestParam("managerId")Integer managerId,Model m){
        List<News> newsList = newsService.findAllNews();
        Manager manager=managerService.findOne(managerId);
        m.addAttribute("n_list", newsList);
        m.addAttribute("m",manager);
        return "newsmanage";
    }

    /*用户查看新闻列表*/
    @GetMapping("/myNewsList")
    public String myNewsList(@RequestParam("userId")Integer userId, Model m){
        List<News> newsList = newsService.findAllNews();
        User user=userService.findOne(userId);
        m.addAttribute("u", user);
        m.addAttribute("n_list", newsList);
        return "news";
    }

    /*用户查看新闻详情*/
    @GetMapping("/findById")
    public String findById(@RequestParam("userId")Integer userId,@RequestParam("id")Integer id,Model m)
    {
        News news=newsService.findOne(id);
        User user=userService.findOne(userId);
        m.addAttribute("u", user);
        m.addAttribute("n",news);
        return "newsdetail";
    }



    /**
     * 删除指定id新闻
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteNews")
    public String  deleteNews(@RequestParam("managerId")Integer managerId, @RequestParam("id")Integer id, RedirectAttributes redirectAttributes) {
        newsService.deleteNewsById(id);
        redirectAttributes.addAttribute("managerId",managerId);
        return "redirect:/news/newsList";
    }


    /*跳转到添加页面*/
    @GetMapping("/newsAdd")
    public  String newsTAdd(@RequestParam("managerId")Integer managerId,Model m)
    {
        Manager manager=managerService.findOne(managerId);
        m.addAttribute("m",manager);
        return "newsadd";
    }

    /*跳转到修改页面*/
    @GetMapping("/newsUpdate")
    public String newsUpdate(@RequestParam("managerId")Integer managerId,Model m)
    {
        Manager manager=managerService.findOne(managerId);
        m.addAttribute("m",manager);
        return "newsupdate";
    }

    /*修改新闻*/
    @GetMapping("/updateNews")
    public String updateNews(@RequestParam("managerId")Integer managerId,@RequestParam("id")Integer id, @RequestParam("title")String title,
                             @RequestParam("content")String content, RedirectAttributes redirectAttributes)
    {
        News tempNews=newsService.findOne(id);
        tempNews.setContent(content);
        tempNews.setTitle(title);
        java.util.Date d=new java.util.Date();
        tempNews.setAnnounceTime(new Timestamp(d.getTime()));
        News resultNews=newsService.createNews(tempNews);
        redirectAttributes.addAttribute("managerId",managerId);
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
    public String addNews(@RequestParam("managerId")Integer managerId, @RequestParam("title") String title, @RequestParam("content") String content,RedirectAttributes redirectAttributes) {

        News tempNews = new News();
        tempNews.setTitle(title);
        tempNews.setContent(content);
        Manager manager=managerService.findOne(managerId);
        tempNews.setAuthor(manager.getName());
        java.util.Date d=new java.util.Date();
        tempNews.setAnnounceTime(new Timestamp(d.getTime()));
        News resultNews = newsService.createNews(tempNews);
        redirectAttributes.addAttribute("managerId",managerId);
        return "redirect:/news/newsList";
    }
//



}
