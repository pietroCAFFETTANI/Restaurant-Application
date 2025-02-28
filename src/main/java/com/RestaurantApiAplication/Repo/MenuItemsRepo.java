package com.RestaurantApiAplication.Repo;

import com.RestaurantApiAplication.Models.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuItemsRepo extends JpaRepository<MenuItems, String> {
    Optional<MenuItems> findByDishName(String dish_name);
    Optional<MenuItems> findById(String id);
}
