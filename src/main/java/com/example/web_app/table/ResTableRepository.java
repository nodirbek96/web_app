package com.example.web_app.table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResTableRepository extends JpaRepository<ResTable,Integer> {
}
