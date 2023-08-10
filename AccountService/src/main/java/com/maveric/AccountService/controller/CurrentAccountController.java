package com.maveric.AccountService.controller;

import com.maveric.AccountService.ServiceImplementation.CurrentAccountImplementation;
import com.maveric.AccountService.entity.CurrentAccount;

import com.maveric.AccountService.exception.AccountIdNotFoundException;
import com.maveric.AccountService.payload.CurrentAccountDto;
import com.maveric.AccountService.payload.SavingsAccountDto;
import com.maveric.AccountService.repository.CurrentRepository;
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

@RequestMapping("/Current")
public class CurrentAccountController {

    private static final Logger logger = LoggerFactory.getLogger(CurrentAccountController.class);
    @Autowired
    CurrentAccountImplementation currentAccountImplementation;
    @Autowired
    CurrentRepository currentRepository;

    @PostMapping("/createCurrentAccount")
    public ResponseEntity<CurrentAccountDto> createAccount(@RequestBody   CurrentAccountDto currentAccountDto) {
        logger.debug("createAccount {}",currentAccountDto);

        return new ResponseEntity<>(currentAccountImplementation.createCurrentAccount(currentAccountDto), HttpStatus.CREATED);
    }

    @GetMapping("/getallCurrentAccount")
    public List<CurrentAccount> getallCurrentAccount() {
        logger.debug("getallCurrentAccount ");
        List<CurrentAccount> accounts = currentAccountImplementation.getAllAccounts();
        return accounts;
    }


    @GetMapping("/getaccountbyid/{id}")
    ResponseEntity<Optional<CurrentAccount>> getAccountById(@Valid @PathVariable long id) throws AccountIdNotFoundException {
        logger.debug("getCurrentAccount {}",id);
        return new ResponseEntity<>(currentAccountImplementation.findAccountById(id), HttpStatus.OK);
    }



    @PatchMapping("update/{id}")
    public Optional<CurrentAccount> updateCurrentAccount(@PathVariable long id, @RequestBody CurrentAccount currentAccount) throws AccountIdNotFoundException {
        logger.debug("updateCurrentAccount {}{}",id,currentAccount);
       Optional<CurrentAccount> updatedRecord= currentAccountImplementation.updateCurrentAccount(id,currentAccount);
        return updatedRecord;
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<CurrentAccountDto> deleteCustomer(@PathVariable("id") Long id) throws AccountIdNotFoundException {
        logger.debug("deleteCustomer {}",id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(currentAccountImplementation.deleteCustomer(id));
    }



}
