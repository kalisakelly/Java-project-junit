package com.example.demo.service;

import com.example.demo.dao.WarehouseDao;
import com.example.demo.model.Warehouse;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService implements WarehouseInterfaceService{

    @Autowired
    private WarehouseDao warehouseDao;
    @Override
    public Warehouse Savewarehouseitem(Warehouse warehouse) {
        return warehouseDao.save(warehouse);
    }

    @Override
    public List<Warehouse> finditem() {
        return warehouseDao.findAll();
    }

    @Override
    public Warehouse findItemById(String itemcode) {
        return  warehouseDao.findById(itemcode).orElse(null);
    }

    @Override
    public boolean deleteItem(String itemcode) {

        Warehouse warehouse = warehouseDao.findById(itemcode).orElse(null);

        if (warehouse !=null ){
            warehouseDao.deleteById(itemcode);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Warehouse updateItem(String itemcode, String itemname) {
        Warehouse warehouse = warehouseDao.findById(itemcode).orElse(null);
        if(warehouse!=null){
            warehouse.setItemname(itemname);
            return warehouseDao.save(warehouse);

        }
        else {
            throw new ObjectNotFoundException(Warehouse.class,String.valueOf(itemcode)) ;
        }

        }

}
