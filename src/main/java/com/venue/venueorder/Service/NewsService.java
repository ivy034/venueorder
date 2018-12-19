package com.venue.venueorder.Service;

import com.venue.venueorder.DO.News;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewsService {
    News findOne(Integer id);

    News findByTitleAndAuthor(String title, String author);

    News createNews(News news);

    void deleteNewsById(Integer id);

    List<News> findByTitle(String title);
}
