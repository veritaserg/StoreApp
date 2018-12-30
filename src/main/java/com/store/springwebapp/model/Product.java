package com.store.springwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

    @Column(name = "name")
private String name;

    @Column(name = "cost")
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name="manufacturer_id", nullable=false)
    private Manufacturer manufacturer;

    @Column(name = "dateTime")
private LocalDateTime dateTime;

    @Column(name = "term")
private int term;


}
