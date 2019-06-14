package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.app.model.Product;
@Service
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
