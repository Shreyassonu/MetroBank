package com.maveric.AccountService.repository;

import com.maveric.AccountService.entity.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentRepository extends JpaRepository<CurrentAccount,Long> {

}
