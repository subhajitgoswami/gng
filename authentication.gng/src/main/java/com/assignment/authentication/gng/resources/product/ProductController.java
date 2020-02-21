package com.assignment.authentication.gng.resources.product;

import java.util.List;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public void addTask(@RequestBody Product task) {
    	productRepository.save(task);
    }

    @GetMapping
    public List<Product> getTasks() {
        return productRepository.findAll();
    }

    @PutMapping("/{id}")
    public void editTask(@PathVariable long id, @RequestBody Product product) {
    	Product existingProduct = productRepository.findById(id).get();
        Assert.notNull(existingProduct, "Task not found");
        existingProduct.setName(product.getName());
        productRepository.save(existingProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
    	Product taskToDel = productRepository.findById(id).get();
    	productRepository.delete(taskToDel);
    }
}