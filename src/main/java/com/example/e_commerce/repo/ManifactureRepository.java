package com.example.e_commerce.repo;

import com.example.e_commerce.document.Manifacture;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ManifactureRepository extends MongoRepository<Manifacture,String> {
}
