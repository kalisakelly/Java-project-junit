package com.example.demo.dao;

import com.example.demo.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseDao extends JpaRepository<Warehouse,String> {
}
