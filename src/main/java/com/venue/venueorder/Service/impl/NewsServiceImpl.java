package com.venue.venueorder.Service.impl;

import com.venue.venueorder.DO.News;
import com.venue.venueorder.Repository.NewsRepository;
import com.venue.venueorder.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    public NewsRepository newsRepository;

    @Override
    public News findOne(Integer id)
    {return newsRepository.findById(id).get();};

    @Override
    public News createNews(News news){
        return newsRepository.save(news);
    }

    @Override
    public void deleteNewsById(Integer id){
        newsRepository.deleteById(id);
    }

    @Override
    public List<News> findByTitle(String title){
        return newsRepository.findByTitle(title);
    }//根据标题查询

    @Override
    public  News findByTitleAndAuthor(String title, String author){
        return newsRepository.findByTitleAndAuthor(title,author);
    }

}
