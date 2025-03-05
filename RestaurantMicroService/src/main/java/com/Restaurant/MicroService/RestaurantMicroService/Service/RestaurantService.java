package com.Restaurant.MicroService.RestaurantMicroService.Service;

import com.Restaurant.MicroService.RestaurantMicroService.DAO_Repository.RestaurantRepository;
import com.Restaurant.MicroService.RestaurantMicroService.Models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    public List<Restaurant> getAllRestaurants(){
        return repository.findAll();
    }

    public Restaurant getRestaurantByName(String name){
        return repository.findByRestaurantName(name).orElseThrow(() -> new RuntimeException("Restaurant Not Found."));
    }

    public void updateRestaurantInfo(Long id, Restaurant restaurant){
        Restaurant updated = repository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant Not Found."));
        updated.setRestaurantName(restaurant.getRestaurantName());
        updated.setEndereco(restaurant.getEndereco());
        repository.save(updated);
    }

    public Restaurant createRestaurant(Restaurant restaurant){
        repository.save(restaurant);
        return restaurant;
    }

    public void deleteRestaurant(Long id){
        Restaurant restaurant = repository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant Not Found."));
        repository.delete(restaurant);
    }

}
