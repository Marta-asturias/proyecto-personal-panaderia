package com.personalproyecto.firstspring.firstspring.controllers;


import org.springframework.web.bind.annotation.RestController;

import com.personalproyecto.firstspring.firstspring.models.Product;
import com.personalproyecto.firstspring.firstspring.services.ProductSevice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@RequestMapping(path = "/api")
public class ProductController {

    @Autowired
    ProductSevice productSevice;
     

   @GetMapping(value="/products")
     public  List<Product> getAll() {
       return productSevice.getAll();
     }

    @PostMapping(value="/products")
     public Product store(@RequestBody Product newProduct ) {
      Product product = productSevice.store(newProduct);
      return product;
     }

     @DeleteMapping(path = "/products/{id}")
    public Map<String,String> deleteProduct(@PathVariable Long id) {
     Map<String,String> message = productSevice.delete(id);
     return message;
    }

  
   @PutMapping(path = "/products/{id}")
   public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return productSevice.update(id, product);
    
}  
   

}
