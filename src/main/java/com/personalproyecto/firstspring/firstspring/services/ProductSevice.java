package com.personalproyecto.firstspring.firstspring.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.personalproyecto.firstspring.firstspring.models.Product;
import com.personalproyecto.firstspring.firstspring.repositories.ProductRepository;

@Service
public class ProductSevice {
    
    @Autowired
    ProductRepository repository;

    public List<Product> getAll() {
        return repository.findAll();
    }
public Product store(Product newProduct) {
    return repository.save(newProduct);
}

public Map<String,String> delete(Long id) {
    Map<String,String> message = new HashMap<>();

    if (repository.findById(id).isPresent()){
       repository.deleteById(id);
       message.put("message", "OK");
       return message;
    }
    message.put("message", "error");
    return message;

}

public Product update(Long id, Product newDataProduct) {

    return repository.findById(id)
     .map((product)->{
        product.setName(newDataProduct.getName());
        product.setEmail(newDataProduct.getEmail());
        return repository.save(product);
     })
     .orElseGet(()->{
       return repository.save(newDataProduct);
     });

}


}
