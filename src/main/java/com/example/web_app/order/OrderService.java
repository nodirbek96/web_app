package com.example.web_app.order;

import com.example.web_app.food.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order insert(Order order) {
        order.setOpened_time(LocalDateTime.now());
        OrderedFood orderedFood=order.getOrdered_food();
        List<Food> foods=orderedFood.getFoods();
        int totalCost=0;
        for (Food food : foods) {
            totalCost = totalCost + food.getPrice();
        }
        order.setCost(totalCost);
        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(int id) {
        return orderRepository.findById(id).get();
    }

    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }
    public int updateOrderedFood(int id,OrderedFood orderedFood){
        int a=orderRepository.updateOrderedFood(id,orderedFood);
        if(a==1){
            updateTotalCost(id);
        }
        return a;
    }

    public int updateTotalCost(int id){
        int totalCost=0;
        Order order=getById(id);
        OrderedFood orderedFood=order.getOrdered_food();
        List<Food> foods=orderedFood.getFoods();
        for (Food food : foods) {
            totalCost = totalCost + food.getPrice();
        }
        return orderRepository.updateTotalCost(id,totalCost);
    }
    public int closeOrder(Order order){
        return orderRepository.closeTheOrder(order.getId(),order.getClosed_time(),true);
    }
}
