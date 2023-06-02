package com.example.web_app.model;

import com.example.web_app.food.Food;
import com.example.web_app.job.Job;
import com.example.web_app.location.Location;
import com.example.web_app.menu.Menu;
import com.example.web_app.order.Order;
import com.example.web_app.restaurant.Restaurant;
import com.example.web_app.table.ResTable;
import com.example.web_app.woker.Worker;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Data {
    private Restaurant restaurant;
    private List<Restaurant> restaurants;
    private Worker worker;
    private List<Worker> workers;
    private ResTable table;
    private List<ResTable> tables;
    private Order order;
    private List<Order> orders;
    private Menu menu;
    private List<Menu> menus;
    private Location location;
    private List<Location> locations;
    private Job job;
    private List<Job> jobs;
    private Food food;
    private List<Food> foods;

    public Data(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Data(Worker worker) {
        this.worker = worker;
    }

    public Data(ResTable table) {
        this.table = table;
    }

    public Data(Order order) {
        this.order = order;
    }

    public Data(Menu menu) {
        this.menu = menu;
    }

    public Data(Location location) {
        this.location = location;
    }

    public Data(Food food) {
        this.food = food;
    }

    public Data(Job job) {
        this.job = job;
    }
}
