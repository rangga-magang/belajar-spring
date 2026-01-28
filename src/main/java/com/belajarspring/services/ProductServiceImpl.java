package com.belajarspring.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.belajarspring.models.Product;
import com.belajarspring.payloads.requests.ProductRequest;
import com.belajarspring.payloads.responses.ProductResponse;
import com.belajarspring.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponse addProduct(ProductRequest request) {
        // Buat object entitas produk
        Product product = new Product();

        // transfer data dari request ke entity
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        // menyimpan entitas buku dengan repository ke db
        product = productRepository.save(product);

        // membuat object response
        ProductResponse response = new ProductResponse();

        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("Product created successfully!");
        response.setData(product);

        return response;
    }

    @Override
    public ProductResponse getProducts() {
        List<Product> products = productRepository.findAll();

        ProductResponse response = new ProductResponse(HttpStatus.OK.value(), "success get list products", products);
        return response;
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("product is not found!");
        });

        return new ProductResponse(HttpStatus.OK.value(), "success get one product by id", product);
    }

    @Override
    public ProductResponse updateProductById(Long id, ProductRequest request) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("product is not found!");
        });

        if (request.getName() != null) {
            product.setName(request.getName());
        }
        if (request.getPrice() != null) {
            product.setPrice(request.getPrice());
        }
        if (request.getStock() != null) {
            product.setStock(request.getStock());
        }

        product = productRepository.save(product);

        return new ProductResponse(HttpStatus.OK.value(), "success updated product with id " + id, product);
    }

    @Override
    public ProductResponse deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NoSuchElementException("product is not found!");
        }

        productRepository.deleteById(id);

        return new ProductResponse(HttpStatus.OK.value(), "success deleted product with id " + id, null);
    }

    
}
