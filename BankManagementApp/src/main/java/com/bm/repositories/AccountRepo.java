package com.bm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bm.entity.Account;

public interface AccountRepo extends JpaRepository<Account,Long>{

  Optional<Account> findById(Long accountNumber);

}
