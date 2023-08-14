package com.example.demo;

import com.example.demo.model.Warehouse;
import com.example.demo.service.WarehouseInterfaceService;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest

public class WarehouseTest {

    @Autowired
    private WarehouseInterfaceService warehouseInterfaceService;


    @Test

    public void saveitem(){

        Warehouse item = new Warehouse();

        item.setItemname("Car");
        item.setType("bus");
        item.setQuantity(20);
        item.setPrice(2300f);

        Warehouse save = warehouseInterfaceService.Savewarehouseitem(item);

        assertNotNull(save);

    }

//    @Test
//
//    public void negativevalue(){
//        Warehouse item = new Warehouse();
//
//        item.setItemcode("AA200");
//        item.setItemname("Car");
//        item.setType("Vehicle");
//        item.setQuantity(-20);
//        item.setPrice(2300f);
//        item.setDateadd("20-10-2023");
//        item.setDateupdated("21-10-2023");
//
//        assertThrows(Exception.class, () -> warehouseInterfaceService.Savewarehouseitem(item));
//
//
//    }


    @Test
    public void finditem(){
        Warehouse item = warehouseInterfaceService.findItemById("AA1");
        assertEquals("Vehicle", item.getType());
    }

    @Test
    public void findUnexistingitem(){
        String nonExistingItemId = "A100";

        Warehouse item = warehouseInterfaceService.findItemById(nonExistingItemId);
        assertNull(item);

    }
    @Test
    public void findexistingitem(){
        String ExistingItemId = "AA1";

        Warehouse item = warehouseInterfaceService.findItemById(ExistingItemId);
        assertNull(item);

    }
    @Test

    public void Allitems(){
        List<Warehouse> item = warehouseInterfaceService.finditem();
        assertEquals(3,item.size());
    }

    @Test
    public void updateitem(){
        Warehouse item = warehouseInterfaceService.updateItem("AA1","Bus");
        assertEquals("Bus", item.getItemname());
    }

    @Test
    public void updateunexistingitem(){
        ObjectNotFoundException rubavu = assertThrows(ObjectNotFoundException.class, () -> {
            warehouseInterfaceService.updateItem("AA211","Bus");
        });
    }

    @Test

    public void testDelete(){
        boolean isDeleted = warehouseInterfaceService.deleteItem("AA20");
        Warehouse ticket = warehouseInterfaceService.findItemById("AA20");
        assertNull(ticket);
        assertTrue(isDeleted);
    }
    @Test
    public void testDeleteNonExistingTicket(){
        String nonExistingItemId = "A100";

        // The ticketServiceInterface.deleteTicketById() should handle the non-existing ticket gracefully
        boolean isDeleted = warehouseInterfaceService.deleteItem(nonExistingItemId);
        Warehouse ticket = warehouseInterfaceService.findItemById(nonExistingItemId);

        assertFalse(isDeleted);
        assertNull(ticket);
    }






}
