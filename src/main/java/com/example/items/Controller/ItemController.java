package com.example.items.Controller;


import com.example.items.Model.Item;
import com.example.items.Service.ItemService;
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
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable long id) {
        return itemService.getItemById(id);
    }

    @PostMapping("/add")
    public String addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

//    @PostMapping("/buy")
//    public String buyItem(@RequestParam long itemId, @RequestParam long customerId){
//        return itemService.buy(itemId, customerId);
//    }
}
