package com.oneToMany.mapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;



    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @OneToMany(targetEntity = Transaction.class,
            cascade= CascadeType.ALL)
    @JoinColumn(name="cust_id",referencedColumnName = "id")
    private List<Transaction> transactions;


}
