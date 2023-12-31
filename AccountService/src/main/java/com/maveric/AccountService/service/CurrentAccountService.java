package com.maveric.AccountService.service;

import com.maveric.AccountService.entity.CurrentAccount;
import com.maveric.AccountService.entity.SavingsAccount;
import com.maveric.AccountService.exception.AccountIdNotFoundException;
import com.maveric.AccountService.payload.CurrentAccountDto;
import com.maveric.AccountService.payload.SavingsAccountDto;

import java.util.List;
import java.util.Optional;

public interface CurrentAccountService {
    public CurrentAccountDto createCurrentAccount(CurrentAccountDto currentAccountDto);

    public List<CurrentAccount> getAllAccounts();

    public Optional<CurrentAccount> findAccountById(long id) throws AccountIdNotFoundException;


    public Optional<CurrentAccount> updateCurrentAccount(long id, CurrentAccount currentAccount) throws AccountIdNotFoundException;

    CurrentAccountDto deleteCustomer(Long id) throws AccountIdNotFoundException;

}
