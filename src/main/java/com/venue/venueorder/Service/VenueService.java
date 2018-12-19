package com.venue.venueorder.Service;

import com.venue.venueorder.DO.Venue;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VenueService {
    Venue findOne(Integer id);

    Venue createVenue(Venue venue);

    void deleteVenueById(Integer id);

    List<Venue> findByName(String name);//根据用户名查询
}
