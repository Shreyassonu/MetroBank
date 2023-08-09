package com.maveric.AccountService.ServiceImplementation;

import com.maveric.AccountService.entity.CurrentAccount;
import com.maveric.AccountService.entity.SavingsAccount;
import com.maveric.AccountService.payload.CurrentAccountDto;
import com.maveric.AccountService.payload.SavingsAccountDto;
import com.maveric.AccountService.repository.CurrentRepository;
import com.maveric.AccountService.service.CurrentAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrentAccountImplementation implements CurrentAccountService {


    @Autowired
    private CurrentRepository currentRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CurrentAccountDto createCurrentAccount(CurrentAccountDto currentAccountDto) {
        CurrentAccount currentAccount = modelMapper.map(currentAccountDto, CurrentAccount.class);
        System.out.println("current acc:" + currentAccount);
        currentAccount = currentRepository.save(currentAccount);
        System.out.println("saved current acc:" + currentAccount);
        return modelMapper.map(currentAccount, CurrentAccountDto.class);
    }

    @Override
    public List<CurrentAccount> getAllAccounts() {

        return currentRepository.findAll();
    }


    @Override
    public Optional<CurrentAccount> findAccountById(long id) {

        return currentRepository.findById(id);

    }

    @Override
    public Optional<CurrentAccount> updateCurrentAccount(long id, CurrentAccount currentAccount) {
        Optional<CurrentAccount> currentAccountOptional = currentRepository.findById(id);
        CurrentAccount currentAccount1 = currentAccountOptional.get();
        currentAccount1.setAccountnumber(currentAccount.getAccountnumber());
        currentAccount1.setBalance(currentAccount.getBalance());
       return Optional.of(currentRepository.save(currentAccount1));


    }

    @Override
    public CurrentAccountDto deleteCustomer(Long id) {
        Optional<CurrentAccount> currentAccount = currentRepository.findById(id);
        if (currentAccount.isPresent())
            currentRepository.delete(currentAccount.get());
        return modelMapper.map(currentAccount, CurrentAccountDto.class);
    }






}
