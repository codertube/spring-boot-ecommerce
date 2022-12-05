package com.backend.ecommerce.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_type")
    private String type;

    public Category(){
    }

    public Category(Long id, String type){
        this.id = id;
        this.type = type;
    }

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products;*/
}
