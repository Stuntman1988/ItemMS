package com.example.items.Repo;


import com.example.items.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Long> {

}
