package com.RestaurantApiAplication.Service;

import com.RestaurantApiAplication.Models.MenuItems;
import com.RestaurantApiAplication.Repo.MenuItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuItemsRepo menuItemsRepo;
    public MenuItems findDishByName(String name){
        return menuItemsRepo.findByDishName(name).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

    public List<MenuItems> getAll(){
        return menuItemsRepo.findAll();
    }

    public void addDish(MenuItems newDish){
        menuItemsRepo.save(newDish);
    }

    public MenuItems updateDish(String id, MenuItems menuItem){
        MenuItems x = menuItemsRepo.findById(id).orElseThrow(() -> new RuntimeException("Item não encontado"));
        x.setDishName(menuItem.getDishName());
        x.setPrice(menuItem.getPrice());
        x.setIngredientes(menuItem.getIngredientes());
        menuItemsRepo.save(x);

        return x;
    }

    public void deleteDish(String id){
        MenuItems x = menuItemsRepo.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
        menuItemsRepo.delete(x);
    }
}
