package com.RestaurantApiAplication.Models;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class MenuItems {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;



    @Column(nullable = false, unique = true)
    private String dishName;


    @Column(nullable = false)
    private BigDecimal price;


    @ElementCollection
    @Column(nullable = false)
    private List<String> ingredientes;

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public String getDishName() {
        return dishName;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
