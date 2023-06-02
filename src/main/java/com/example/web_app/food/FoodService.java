package com.example.web_app.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    public Food insert(Food food){
        food.setDone_time(LocalDateTime.now());
        return foodRepository.save(food);
    }
    public List<Food> getAll(){
        return foodRepository.findAll();
    }
    public Food getById(int id){
        return foodRepository.findById(id).get();
    }
    public void deleteById(int id){
        foodRepository.deleteById(id);
    }
    public void delete(Food food){
        foodRepository.delete(food);
    }
}
