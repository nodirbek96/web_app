package com.example.web_app.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant insert(Restaurant restaurant){
        LocalDateTime localDateTime=LocalDateTime.now();
        restaurant.setDone_time(localDateTime);
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAll(){
        return restaurantRepository.findAll();
    }
    public void deleteBytId(int id){
        restaurantRepository.deleteById(id);
    }
    public void delete(Restaurant restaurant){
        restaurantRepository.delete(restaurant);
    }
    public Restaurant getById(int id){
        return restaurantRepository.findById(id).get();
    }

}
