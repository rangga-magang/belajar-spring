package com.belajarspring.services;

import com.belajarspring.payloads.requests.ProductRequest;
import com.belajarspring.payloads.responses.ProductResponse;

public interface ProductService {
    ProductResponse addProduct(ProductRequest request);

    ProductResponse getProducts();

    ProductResponse getProductById(Long id);

    ProductResponse updateProductById(Long id, ProductRequest request);

    ProductResponse deleteProductById(Long id);
}
