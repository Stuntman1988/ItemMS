package com.example.items;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "Item API", version = "1.0.0"),
        servers = {@Server(url = "http://localhost:8083")},
        tags = {@Tag(name = "ItemMS", description = "API to add/list a item/items")}
)
public class ItemMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemMsApplication.class, args);
    }

}
