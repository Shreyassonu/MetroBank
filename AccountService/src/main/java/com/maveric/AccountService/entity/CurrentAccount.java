package com.maveric.AccountService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CurrentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private float balance;

    @Column(length = 11,nullable = false)
    private int accountnumber;

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountnumber=" + accountnumber +
                '}';
    }
}

