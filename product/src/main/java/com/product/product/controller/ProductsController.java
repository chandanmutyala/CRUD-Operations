package com.product.product.controller;

import com.product.product.model.Products;
import com.product.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    public ProductService productService;

    @PostMapping("/addProduct")
    public Products addProduct(@RequestBody Products products){
        System.out.println(products.getQuantity()   );
        return productService.saveProduct(products);
    }

    @PostMapping("/addProducts")
    public List<Products> addProducts(@RequestBody List<Products> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/viewProducts")
    public List<Products> viewProducts(){
        return productService.getProducts();
    }

    @GetMapping("/viewProductById/{id}")
    public Products viewProductById(@PathVariable int id){
        return productService.getProductsById(id);
    }

    @GetMapping("/viewProductsByName/{name}")
    public Products viewProductsByName(@PathVariable String name){
        return productService.getProductsByName(name);
    }

    @PutMapping("/updateProduct")
    public Products updateProduct(@RequestBody Products products){
        return productService.updateProducts(products);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }


}
