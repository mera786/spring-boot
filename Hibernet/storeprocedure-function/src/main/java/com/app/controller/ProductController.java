package com.app.controller;


import com.app.entity.Product;
import com.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping("/update/{productId}/{quantity}")
    public Product updateInventoryStock(@PathVariable Integer productId, @PathVariable Integer quantity){
        Product product = productService.updateStockQuantity(productId, quantity);
        return product;
    }


    @GetMapping("/total-price/{productId}")
    public Double getTotalPrice(@PathVariable Integer productId){
       return productService.calculateProductPrice(productId);
    }
}
