package com.maveric.AccountService.controller;

import com.maveric.AccountService.ServiceImplementation.SavingsAccountImplementation;
import com.maveric.AccountService.entity.SavingsAccount;
import com.maveric.AccountService.exception.AccountIdNotFoundException;
import com.maveric.AccountService.payload.SavingsAccountDto;
import com.maveric.AccountService.repository.SavingsRepository;
import com.maveric.AccountService.service.SavingsAccountService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Savings")
public class SavingsAccountController {
    private static final Logger logger = LoggerFactory.getLogger(SavingsAccountController.class);

    @Autowired
    private SavingsAccountImplementation savingsAccountServiceImpl;
    @Autowired
    private SavingsRepository savingsRepository;
      //POST store Savings Account Details
    @PostMapping("/createSavingsAccount")
    public ResponseEntity<SavingsAccountDto> createAccount(@RequestBody @Valid SavingsAccountDto savingsAccountDto){
        logger.debug("createAccount {}",savingsAccountDto);

        return new ResponseEntity<>(savingsAccountServiceImpl.createSavingsAccount(savingsAccountDto),HttpStatus.CREATED);
    }


    @GetMapping("/getallSavingsAccount")
    public List<SavingsAccount> getallSavingsAccount(){
        logger.debug("getallSavingsAccount ");
      List<SavingsAccount> accounts=  savingsAccountServiceImpl.getAllAccounts();
//        logger.debug("getallSavingsAccount {}",accounts);
        return accounts;
    }


    @GetMapping("/getaccountbyid/{id}")
    ResponseEntity<Optional<SavingsAccount>>getAccountById(@PathVariable long id) throws AccountIdNotFoundException {
        logger.debug("getSavingsAccount {}",id);


        return new ResponseEntity<>(savingsAccountServiceImpl.findAccountById(id),HttpStatus.OK);
}
    @PatchMapping("update/{id}")
    public Optional<SavingsAccount> updateSavingsAccount(@PathVariable long id, @RequestBody SavingsAccount savingsAccount) throws AccountIdNotFoundException {
        logger.debug("updateSavingsAccount {}{}",id,savingsAccount);
      Optional<SavingsAccount> upadated= savingsAccountServiceImpl.updateSavingsAccount(id,savingsAccount);
       return upadated;
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<SavingsAccountDto> deleteCustomer(@PathVariable("id") Long id) throws AccountIdNotFoundException {
        logger.debug("deleteCustomer {}",id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(savingsAccountServiceImpl.deleteCustomer(id));
    }


    }




