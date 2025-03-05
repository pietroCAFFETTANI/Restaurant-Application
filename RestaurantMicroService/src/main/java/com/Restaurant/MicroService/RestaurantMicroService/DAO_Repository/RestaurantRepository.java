package com.Restaurant.MicroService.RestaurantMicroService.DAO_Repository;

import com.Restaurant.MicroService.RestaurantMicroService.Models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByRestaurantName(String restaurantName);
}
