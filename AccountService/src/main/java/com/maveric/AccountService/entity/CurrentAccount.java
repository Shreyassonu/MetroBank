package com.maveric.AccountService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Getter
@Setter
public class CurrentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private float balance;
    private String accountnumber;

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountnumber=" + accountnumber +
                '}';
    }
}

