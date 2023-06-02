package com.example.web_app.order;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomizedUserRepositoryImpl implements CustomizedUserRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int updateOrderedFood(int id, OrderedFood ordered_food) {
        System.out.println(id +": "+ordered_food );
        return entityManager.createNativeQuery(
                        "UPDATE _orders  SET ordered_food = :ordered_food WHERE id = :id")
                .unwrap(NativeQuery.class)
                .setParameter("ordered_food", ordered_food, JsonBinaryType.INSTANCE)
                .setParameter("id", id)
                .executeUpdate();
    }
}
