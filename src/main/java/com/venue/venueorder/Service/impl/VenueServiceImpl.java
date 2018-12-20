package com.venue.venueorder.Service.impl;

import com.venue.venueorder.DO.User;
import com.venue.venueorder.DO.Venue;
import com.venue.venueorder.Repository.VenueRepository;
import com.venue.venueorder.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {
    @Autowired
    public VenueRepository venueRepository;

    @Override
    public Venue findOne(Integer id)
    {return venueRepository.findById(id).get();};

    @Override
    public Venue createVenue(Venue venue){
        return venueRepository.save(venue);
    }

    @Override
    public void deleteVenueById(Integer id){
        venueRepository.deleteById(id);
    }

    @Override
    public List<Venue> findByName(String name){
        return venueRepository.findByName(name);
    }//根据用户名查询

    @Override
    public List<Venue> findAllVenue(){return venueRepository.findAll();}

    @Override
    public void update(Venue venue) {
        venueRepository.save(venue);
    }
}
