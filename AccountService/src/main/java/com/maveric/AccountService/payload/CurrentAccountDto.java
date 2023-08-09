package com.maveric.AccountService.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAccountDto {

    private long id;
    private float balance;
    private int accountnumber;
}


