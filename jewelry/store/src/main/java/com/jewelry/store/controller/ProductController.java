package com.jewelry.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jewelry.store.dao.ProductDAO;
import com.jewelry.store.entity.Product;

@RequestMapping("/api")
@RestController
public class ProductController {
    private ProductDAO productDAO;
    
    @Value("${name.store}")
    private String nameStore;

    @Value("${address.store}")
    private String address;

    @Autowired
    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping("/info")
    public String info() {
        return "Chao mung ban den voi " + nameStore + " dia chi cua hang " + address;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    @GetMapping("/products/{id}")
    public Product geProductById(@PathVariable int id) {
        return productDAO.findById(id);
    }

    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product newProduct) {
        newProduct.setId(0);
        productDAO.save(newProduct);
        return newProduct;
    }

    @PutMapping("/products/edit/{id}")
    public String updatedProduct(@PathVariable int id, @RequestBody Product updatedInfo) {
        Product existingProduct = productDAO.findById(id);

        if (existingProduct == null) {
            return "Khong tim thay san pham co ID " + id;
        }

        existingProduct.setName(updatedInfo.getName());
        existingProduct.setPrice(updatedInfo.getPrice());

        productDAO.update(existingProduct);
        return "Cap nhat san pham thanh cong!!!";
    }

    @DeleteMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        Product temp = productDAO.findById(id);
        if (temp == null) {
            return "Khong tim thay san pham co ID " + id;
        }
        productDAO.delete(id);
        return "Xoa san pham thanh cong!!!";
    }
}
