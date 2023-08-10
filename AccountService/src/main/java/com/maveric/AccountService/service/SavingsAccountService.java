package com.maveric.AccountService.service;


import com.maveric.AccountService.entity.SavingsAccount;
import com.maveric.AccountService.exception.AccountIdNotFoundException;
import com.maveric.AccountService.payload.SavingsAccountDto;

import java.util.List;
import java.util.Optional;

public interface SavingsAccountService {
    public SavingsAccountDto createSavingsAccount(SavingsAccountDto savingsAccountDto);

    public List<SavingsAccount> getAllAccounts();

    public Optional<SavingsAccount> findAccountById(long id) throws AccountIdNotFoundException;

    public Optional<SavingsAccount> updateSavingsAccount(long id, SavingsAccount savingsAccount) throws AccountIdNotFoundException;

    SavingsAccountDto deleteCustomer(Long id) throws AccountIdNotFoundException;
}
