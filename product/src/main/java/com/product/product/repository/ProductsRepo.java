package com.product.product.repository;

import com.product.product.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Products,Integer> {
    Products findByName(String name);
}
