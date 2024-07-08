package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @Size(min=3,max=50)
    @Column(name="name")
    private String name;

    @Min(0)
    @Column(name="price")
    private double price;

    @NotNull
    @Column(name="is_grown_on_tree")
    private boolean isGrownOnTree;
}
