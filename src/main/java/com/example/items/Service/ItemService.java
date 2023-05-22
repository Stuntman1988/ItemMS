package com.example.items.Service;


import com.example.items.Model.Item;
import com.example.items.Repo.ItemRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {

    public final ItemRepo itemRepo;
    //public final CustomerRepo customerRepo;
    //public final PurchaseRepo purchaseRepo;

    public ItemService(ItemRepo itemRepo/*, CustomerRepo customerRepo, PurchaseRepo purchaseRepo*/) {
        this.itemRepo = itemRepo;
        //this.customerRepo = customerRepo;
        //this.purchaseRepo = purchaseRepo;
    }

    public List<Item> getAllItems(){
        return itemRepo.findAll();
    }

    public Item getItemById(long id) {
        return itemRepo.findById(id).orElse(null);
    }
    public String addItem(Item item){
        if (item.getName() != null) {
            if (item.getPrice() != 0.0) {
                itemRepo.save(item);
                return "Item with name: " + item.getName() + " added";
            }
        }
        return "Could not add item!";

    }
    /*
    public String buy(long itemId, long  customerId){
        Item item = itemRepo.findById(itemId).orElse(null);
        Customer customer = customerRepo.findById(customerId).orElse(null);
        System.out.println(item + " - " + customer);
        if (item != null){
            if (customer != null) {
                purchaseRepo.save(new Purchase(customer, item));
                return "Purchase successful";
            }
        }
        return "Something went wrong with the purchase!";
    }
*/
}
