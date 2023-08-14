package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(generator = "itemcode")
    @GenericGenerator(name = "itemcode", strategy = "com.example.demo.model.IdGenerator")
    private String itemcode;

    private String itemname;
    private String type;
    private int quantity;
    private float price;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadd;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateupdated;
}
