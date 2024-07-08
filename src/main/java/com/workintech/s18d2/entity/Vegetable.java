package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="vegetable",schema="public")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="is_grown_on_tree")
    private boolean isGrownOnTree;
}
