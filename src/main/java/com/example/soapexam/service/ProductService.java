package com.example.soapexam.service;

import com.example.soapexam.ProductRepository;
import com.example.soapexam.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@Component(value = "productService")
@WebService
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @WebMethod
    public void addProduct(Product product){
        productRepository.save(product);
    }

    @WebMethod
    public List<Product> listAll(){
        return productRepository.findAll();
    }

    @WebMethod
    public void sellProduct(int productId, int quantity){
        Optional<Product> currentProduct = productRepository.findById(productId);
        Product p = currentProduct.get();
        p.setQuantity(p.getQuantity() - quantity);
        productRepository.save(p);
    }
}
