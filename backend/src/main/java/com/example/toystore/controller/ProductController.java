package com.example.toystore.controller;

import com.example.toystore.dto.Product;
import com.example.toystore.dto.ProductType;
import com.example.toystore.dto.Response;
import com.example.toystore.dto.Source;
import com.example.toystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public Response<Integer> createProduct(@RequestBody Product product){
        productService.insertProduct(product);
        return Response.<Integer> builder()
                .code(200)
                .message("Success")
                .data(1)
                .build();
    }

    @GetMapping("/all")
    public Response<List<Product>> getAllProduct(){
        var res = productService.getAllProduct();
        return Response.<List<Product>> builder()
                .code(200)
                .message("Success")
                .data(res)
                .build();
    }


    @PostMapping("/type")
    public Response<Integer> createProductType(@RequestBody ProductType type){
        var res = productService.insertTypeProduct(type);
        return Response.<Integer> builder()
                .code(200)
                .message("Success")
                .data(res)
                .build();
    }
    @GetMapping("/type")
    public Response<List<ProductType>> getAllProductType(){
        var res = productService.getAllProductType();
        return Response.<List<ProductType>> builder()
                .code(200)
                .message("Success")
                .data(res)
                .build();
    }

    @PostMapping("/source")
    public Response<Integer> createProductSource(@RequestBody Source source){
        var res = productService.insertProductSource(source);
        return Response.<Integer> builder()
                .code(200)
                .message("Success")
                .data(res)
                .build();
    }
    @GetMapping("/source")
    public Response<List<Source>> getAllProductSource(){
        var res = productService.getAllProductSource();
        return Response.<List<Source>> builder()
                .code(200)
                .message("Success")
                .data(res)
                .build();
    }







}
