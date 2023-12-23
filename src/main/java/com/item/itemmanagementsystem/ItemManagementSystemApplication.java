package com.item.itemmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ItemManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemManagementSystemApplication.class, args);
    }
}
