package com.example.web_app.order;

import javax.transaction.Transactional;

public interface CustomizedUserRepository {
    @Transactional
    int updateOrderedFood(int id,OrderedFood orderedFood);
}
