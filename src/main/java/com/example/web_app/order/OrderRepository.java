package com.example.web_app.order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>,CustomizedUserRepository {
   @Transactional
   @Modifying
   @Query(value = "update _orders set cost=:cost where id=:id",nativeQuery = true)
   int updateTotalCost(int id, int cost);
   @Transactional
   @Modifying
   @Query(value = "update _orders set closed=:closed where id=:id",nativeQuery = true)
   int closeTheOrder(int id, LocalDateTime closed_time,boolean closed);
}

