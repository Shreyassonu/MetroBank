package com.maveric.AccountService.controller;

import com.maveric.AccountService.ServiceImplementation.SavingsAccountImplementation;
import com.maveric.AccountService.entity.SavingsAccount;
import com.maveric.AccountService.payload.SavingsAccountDto;
import com.maveric.AccountService.repository.SavingsRepository;
import com.maveric.AccountService.service.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Savings")
public class SavingsAccountController {
    @Autowired
    private SavingsAccountImplementation savingsAccountServiceImpl;
    @Autowired
    private SavingsRepository savingsRepository;
      //POST store Savings Account Details
    @PostMapping("/createSavingsAccount")
    public ResponseEntity<SavingsAccountDto> createAccount(@RequestBody SavingsAccountDto savingsAccountDto){

        return new ResponseEntity<>(savingsAccountServiceImpl.createSavingsAccount(savingsAccountDto),HttpStatus.CREATED);
    }


    @GetMapping("/getallSavingsAccount")
    public List<SavingsAccount> getallSavingsAccount(){
      List<SavingsAccount> accounts=  savingsAccountServiceImpl.getAllAccounts();
        return accounts;
    }


    @GetMapping("/getaccountbyid/{id}")
    ResponseEntity<Optional<SavingsAccount>>getAccountById(@PathVariable long id){
    return new ResponseEntity<>(savingsAccountServiceImpl.findAccountById(id),HttpStatus.OK);
}
    @PatchMapping("update/{id}")
    public Optional<SavingsAccount> updateSavingsAccount(@PathVariable long id, @RequestBody SavingsAccount savingsAccount){
      Optional<SavingsAccount> upadated= savingsAccountServiceImpl.updateSavingsAccount(id,savingsAccount);
       return upadated;
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<SavingsAccountDto> deleteCustomer(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(savingsAccountServiceImpl.deleteCustomer(id));
    }


    }




