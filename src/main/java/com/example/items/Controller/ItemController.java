package com.example.items.Controller;


import com.example.items.Model.Item;
import com.example.items.Service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    @Operation(
            tags = {"Item"},
            operationId = "listItems",
            description = "List all Items",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(schema =
                    @Schema(implementation = Item.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Successful response" )}
    )
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    @Operation(
            tags = {"Item"},
            operationId = "getSingleItem",
            description = "get a Item by their ID",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(schema =
                    @Schema(implementation = Item.class), mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Successful response")}
    )
    public Item getItemById(@PathVariable long id) {
        return itemService.getItemById(id);
    }

    @PostMapping("/add")
    @Operation(
            tags = {"Item"},
            operationId = "addItem",
            description = "Add a Item to DB",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = Item.class))
            ),
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(schema =
                    @Schema(implementation = Item.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Successful response")}
    )
    public String addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }
}
