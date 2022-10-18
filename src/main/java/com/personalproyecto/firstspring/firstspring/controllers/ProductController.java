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
//pruevas con cords la madre que me pario 48horas y da gracias
import org.springframework.web.bind.annotation.CrossOrigin;




@RestController
//por dios y la virgen esto no se me olvidara en la vida
@CrossOrigin(origins = "*")

@RequestMapping(path = "/api")
public class ProductController {

    @Autowired
    ProductSevice productSevice;
     

   @GetMapping(value="/products")
     public  List<Product> getAll() {
       return productSevice.getAll();
     }

    @PostMapping(value="/products/create")
     public Product store(@RequestBody Product newProduct ) {
      Product product = productSevice.store(newProduct);
      return product;
     }

     @DeleteMapping(path = "/products/delete")
    public Map<String,String> delete(@RequestBody Product product ) {
     Map<String,String> message = productSevice.delete(product);
     return message;
     // cambiar el service
    }

  
   @PutMapping(path = "/products/{id}")
   public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return productSevice.update(id, product);
    
}  
   

}
