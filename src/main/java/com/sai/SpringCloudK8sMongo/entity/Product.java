package com.sai.SpringCloudK8sMongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="product")
@Data
public class Product {
    @Id
    private Long id;
    private String productId;
    private String description;
    private double price;
}