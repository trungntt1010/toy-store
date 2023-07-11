package com.example.toystore.service;

import com.example.toystore.dto.Product;
import com.example.toystore.dto.ProductType;
import com.example.toystore.dto.Source;
import com.example.toystore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public int insertProduct(Product product){
        return productRepository.insertProduct(product);
    }


    public int insertTypeProduct(ProductType product) {
        return productRepository.insertTypeProduct(product);
    }

    public int insertProductSource(Source source) {
        return productRepository.insertProductSource(source);
    }

    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    public List<ProductType> getAllProductType() {
        return productRepository.getAllProductType();
    }

    public List<Source> getAllProductSource() {
        return productRepository.getAllProductSource();
    }
}
