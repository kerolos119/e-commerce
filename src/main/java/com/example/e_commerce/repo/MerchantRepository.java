package com.example.e_commerce.repo;

import com.example.e_commerce.document.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MerchantRepository extends MongoRepository<Merchant,String> {
}
