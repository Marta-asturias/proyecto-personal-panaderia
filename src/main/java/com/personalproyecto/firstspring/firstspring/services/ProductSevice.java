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

/**
 * @param product
 * @return
 */
public Map<String,String> delete(Product product) {
    Map<String,String> message = new HashMap<>();
    repository.delete(product);
    return message;

/*     if (repository.findById().isPresent()){
       repository.deleteById(id);
       message.put("message", "OK");
       return message;
    }
    message.put("message", "error");
    return message; */

}

public Product update(Long id, Product newDataProduct) {

    return repository.findById(id)
     .map((product)->{
        product.setName(newDataProduct.getName());
        product.setCantidad(newDataProduct.getCantidad());
        return repository.save(product);
     })
     .orElseGet(()->{
       return repository.save(newDataProduct);
     });

}


}
