package com.example.demo.service;

import com.example.demo.model.Warehouse;

import java.util.List;

public interface WarehouseInterfaceService {


    Warehouse Savewarehouseitem (Warehouse warehouse);

    List<Warehouse> finditem();

    Warehouse findItemById(String itemcode);

    boolean deleteItem (String itemcode);

    Warehouse updateItem (String itemcode,String itemname );


}
