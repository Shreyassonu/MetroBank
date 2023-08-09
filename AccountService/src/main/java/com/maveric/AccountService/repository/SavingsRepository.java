package com.maveric.AccountService.repository;
import com.maveric.AccountService.entity.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<SavingsAccount,Long>{

}
