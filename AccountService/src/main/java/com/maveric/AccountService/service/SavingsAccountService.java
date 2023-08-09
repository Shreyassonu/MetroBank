package com.maveric.AccountService.service;


import com.maveric.AccountService.entity.SavingsAccount;
import com.maveric.AccountService.payload.SavingsAccountDto;

import java.util.List;
import java.util.Optional;

public interface SavingsAccountService {
    public SavingsAccountDto createSavingsAccount(SavingsAccountDto savingsAccountDto);

    public List<SavingsAccount> getAllAccounts();

    public Optional<SavingsAccount> findAccountById(long id);

    public Optional<SavingsAccount> updateSavingsAccount(long id, SavingsAccount savingsAccount);

    SavingsAccountDto deleteCustomer(Long id);
}
