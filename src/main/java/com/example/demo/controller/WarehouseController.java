package com.example.demo.controller;

import com.example.demo.model.Warehouse;
import com.example.demo.service.WarehouseInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseInterfaceService bookServiceInterface;

    @PostMapping("/save")
    public ResponseEntity<Warehouse> savebook(@RequestBody Warehouse warehouse){

        Warehouse warehouse1 = bookServiceInterface.Savewarehouseitem(warehouse);

        return new ResponseEntity<>(warehouse1, HttpStatus.CREATED);
    }

    @GetMapping("/{itemcode}")
    public ResponseEntity<Warehouse> getBookById(@PathVariable("itemcode") String itemcode) {
        Warehouse book = bookServiceInterface.findItemById(itemcode);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{itemcode}")
    public ResponseEntity<Void> deleteBook(@PathVariable("itemcode") String itemcode) {
        boolean deleted = bookServiceInterface.deleteItem(itemcode);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{itemcode}")
    public ResponseEntity<Warehouse> updateBookTitle(
            @PathVariable("itemcode") String itemcode,
            @RequestBody String itemname) {
        Warehouse updatedBook = bookServiceInterface.updateItem(itemcode, itemname);
        if (updatedBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Warehouse>>getAllbooks(){
        List<Warehouse>books=bookServiceInterface.finditem();
        return new ResponseEntity<>(books,HttpStatus.OK);
    }


}
