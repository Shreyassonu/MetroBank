package com.maveric.AccountService.ServiceImplementation;

import com.maveric.AccountService.AccountServiceApplication;
import com.maveric.AccountService.RandomGeneratorUtils;
import com.maveric.AccountService.entity.CurrentAccount;
import com.maveric.AccountService.entity.SavingsAccount;
import com.maveric.AccountService.exception.AccountIdNotFoundException;
import com.maveric.AccountService.payload.SavingsAccountDto;
import com.maveric.AccountService.repository.SavingsRepository;
import com.maveric.AccountService.service.SavingsAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsAccountImplementation implements SavingsAccountService {
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SavingsAccountDto createSavingsAccount(SavingsAccountDto savingsAccountDto) {
        SavingsAccount savingsAccount = modelMapper.map(savingsAccountDto, SavingsAccount.class);
        savingsAccount.setAccountnumber(RandomGeneratorUtils.generateAccountNumber());
        savingsAccount = savingsRepository.save(savingsAccount);
        return modelMapper.map(savingsAccount, SavingsAccountDto.class);
    }

    @Override
    public List<SavingsAccount> getAllAccounts() {

        return savingsRepository.findAll();
    }

    @Override
    public Optional<SavingsAccount> findAccountById(long id) throws AccountIdNotFoundException {

        Optional<SavingsAccount> savingsAccount=savingsRepository.findById(id);
        if(savingsAccount.isEmpty())
        {
           throw new AccountIdNotFoundException("Account id Not found: "+id);
        }
        return savingsAccount;
    }

    @Override
    public Optional<SavingsAccount> updateSavingsAccount(long id, SavingsAccount savingsAccount) throws AccountIdNotFoundException {
        Optional<SavingsAccount> savingsAccountOptional = (savingsRepository.findById(id));
        if (!savingsAccountOptional.isPresent()) {

        throw new AccountIdNotFoundException("Account id Not found :  "+id);
        } else {

        SavingsAccount savingsAccount1 = savingsAccountOptional.get();
        //savingsAccount1.setAccountnumber(savingsAccount.getAccountnumber());
        savingsAccount1.setBalance(savingsAccount.getBalance());
        return Optional.of(savingsRepository.save(savingsAccount1));

    }

}
        @Override
        public SavingsAccountDto deleteCustomer(Long id) throws AccountIdNotFoundException {
            Optional<SavingsAccount> savingsAccount = savingsRepository.findById(id);
            if (!savingsAccount.isPresent()) {
                throw new AccountIdNotFoundException("Account id Not found :  " + id);
            } else {
                savingsRepository.delete(savingsAccount.get());
                return modelMapper.map(savingsAccount, SavingsAccountDto.class);
            }
        }


}
