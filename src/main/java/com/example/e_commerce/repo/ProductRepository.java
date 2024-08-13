package com.example.e_commerce.repo;

import com.example.e_commerce.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ProductRepository extends MongoRepository <Product,String > {
}
