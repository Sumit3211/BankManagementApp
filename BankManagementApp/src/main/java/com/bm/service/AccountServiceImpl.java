package com.bm.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bm.entity.Account;
import com.bm.repositories.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService{

  @Autowired
 private AccountRepo repo;;

  @Override
  public Account createAccount(Account account) {
   
    return repo.save(account);
  }

  @Override
  public Account getAccountDeatilsByAccountNumber(Long accountNumber) {

    Optional<Account> account = repo.findById(accountNumber);
    if(account.isEmpty()){

      throw new RuntimeErrorException(null, "Account is invalid");
    }
    Account accountFound = account.get();

    return accountFound;
  }

  @Override
  public List<Account> getAllAccountDetails() {
    
    List<Account> list = repo.findAll();

    return list;
  }

  @Override
  public Account depositAmount(Long accountNumber, Double amount) {
    
    Optional<Account> account = repo.findById(accountNumber);
    if(account.isEmpty()){
      throw new RuntimeErrorException(null, "Account not present");
    }

    Account accountPresent = account.get();
    Double totalBalance = accountPresent.getAccount_balance()+ amount;
    accountPresent.setAccount_balance(totalBalance);
    repo.save(accountPresent);
    
    return accountPresent;
  }

  @Override
  public Account withDrawAmount(Long accountNumber, Double Amount) {
    
   Optional<Account> account=  repo.findById(accountNumber);

   if(account.isEmpty()){
      throw new RuntimeErrorException(null, "Account is not present");
   }
   Account accountPresent = account.get();
   Double accountBalance = accountPresent.getAccount_balance() -Amount;
   accountPresent.setAccount_balance(accountBalance);

   repo.save(accountPresent);
   
    return  accountPresent;
  }

  @Override
  public void closeAccount(Long accountNumber) {
    
      getAccountDeatilsByAccountNumber(accountNumber);
      repo.deleteById(accountNumber);
  }

}
