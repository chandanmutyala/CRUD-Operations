package com.product.product.service;

import com.product.product.model.Features;
import com.product.product.model.Products;
import com.product.product.repository.FeaturesRepo;
import com.product.product.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductsRepo productsRepo;

    @Autowired
    private FeaturesRepo featuresRepo;

    public Products saveProduct(Products products) {
        return productsRepo.save(products);
    }

    public Features addFeature(int productId,Features features){
        Products products=productsRepo.findById(productId).orElse(null);
        if(products != null){
            features.setProducts(products);
            featuresRepo.save(features);
            return  features;
        }else {
            return null;
        }
    }



    public List<Features> getFeaturesByProductId(int productId){
        Products products=productsRepo.findById(productId).orElse(null);
        if(products != null){
            return products.getFeatures();
        }else{
            return null;
        }
    }

    public String deleteFeature(int productId){
        Products products=productsRepo.findById(productId).orElse(null);
        if(products != null){
            featuresRepo.deleteById(productId);
        }else{
            return null;
        }
        return "feature deleted "+productId;
    }




    public List<Products> saveProducts(List<Products> products) {
        return productsRepo.saveAll(products);
    }


    public List<Products> getProducts() {
        return productsRepo.findAll();
    }

    public Products getProductsById(int id) {
        return productsRepo.findById(id).orElse(null);
    }

    public Products getProductsByName(String name) {
        return productsRepo.findByName(name);
    }

    public Products updateProducts(Products products) {
        Products existingProduct = productsRepo.findById(products.getId()).orElse(null);
        existingProduct.setName(products.getName());
        existingProduct.setQuantity((products.getQuantity()));
        existingProduct.setPrice(products.getPrice());
        return productsRepo.save(existingProduct);
    }

    public String deleteProduct(int id){
        productsRepo.deleteById(id);
        return "deleted "+id;
    }



}
