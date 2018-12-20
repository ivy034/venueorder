package com.venue.venueorder.Service;

import com.venue.venueorder.DO.Venue;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VenueService {
    List<Venue> findAllVenue();

    Venue findOne(Integer id);

    Venue createVenue(Venue venue);

    void deleteVenueById(Integer id);

    List<Venue> findByName(String name);//根据用户名查询

    void update(Venue venue);
}
