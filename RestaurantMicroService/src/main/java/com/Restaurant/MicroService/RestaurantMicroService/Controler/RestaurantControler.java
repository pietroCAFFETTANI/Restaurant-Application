package com.Restaurant.MicroService.RestaurantMicroService.Controler;


import com.Restaurant.MicroService.RestaurantMicroService.Models.Restaurant;
import com.Restaurant.MicroService.RestaurantMicroService.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantControler {

    @Autowired
    private RestaurantService service;

    @GetMapping(value = "/restaurant")
    public List<Restaurant> getAllRestaurant(){
        return service.getAllRestaurants();
    }

    @GetMapping(value = "/restaurant/{name}")
    public Restaurant getRestaurant(@PathVariable String name){
        return service.getRestaurantByName(name);
    }


    @PostMapping(value = "/restaurant")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
        Restaurant createdRestaurant = service.createRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestaurant);
    }

    @PutMapping(value = "/restaurant/{id}")
    public String updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable Long id){
        try{
            service.updateRestaurantInfo(id, restaurant);
            return "Updated Sucessfully!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(value = "/restaurant/{id}")
    public String deleteRestaurant(@PathVariable Long id){
        try{
            service.deleteRestaurant(id);
            return "Deleted Sucessfully!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
