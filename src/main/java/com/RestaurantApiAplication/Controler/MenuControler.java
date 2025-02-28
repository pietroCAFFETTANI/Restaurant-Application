package com.RestaurantApiAplication.Controler;


import com.RestaurantApiAplication.Models.MenuItems;
import com.RestaurantApiAplication.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuControler {

    @Autowired
    MenuService menuService;

    @GetMapping(value = "/")
    public String welcome(){
        return "WELCOME TO THE RESTAURANT!";
    }
    @GetMapping(value = "/menu")
    public List<MenuItems> findAllMenuItems(){
        return menuService.getAll();
    }

    @GetMapping(value = "/menu/{dish_name}")
    public MenuItems getByName(@PathVariable String name){
        return menuService.findDishByName(name);
    }

    @PostMapping(value= "/menu/add")
    public void addMenuItem(@RequestBody MenuItems menuItem){
        menuService.addDish(menuItem);
    }

    @PutMapping(value = "/menu/update/{id}")
    public String updatemenuItem(@PathVariable String id, @RequestBody MenuItems menuItem){
        try{
            menuService.updateDish(id, menuItem);
            return "Dish Saved Sucessfully!";
        }
        catch(RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(value = "/menu/delete/{id}")
    public String deleteMenuItem(@PathVariable String id){
        try{
            menuService.deleteDish(id);
            return "Menu Item Deleted";
        }catch(RuntimeException e){
             throw new RuntimeException(e);
        }
    }

}
