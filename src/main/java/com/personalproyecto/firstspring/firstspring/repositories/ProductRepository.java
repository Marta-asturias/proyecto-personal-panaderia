package com.personalproyecto.firstspring.firstspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalproyecto.firstspring.firstspring.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
