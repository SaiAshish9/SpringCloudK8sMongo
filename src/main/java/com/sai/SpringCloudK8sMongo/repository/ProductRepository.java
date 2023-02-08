package com.sai.SpringCloudK8sMongo.repository;

import com.sai.SpringCloudK8sMongo.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long> {

}
