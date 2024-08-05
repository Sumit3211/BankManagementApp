package com.bm.service;

import java.util.List;

import com.bm.entity.Account;

public interface AccountService {

  public Account createAccount(Account account);
  public Account getAccountDeatilsByAccountNumber(Long accountNumber);
  public List<Account> getAllAccountDetails();
  public Account depositAmount(Long accountNumber,Double amount);
  public Account withDrawAmount(Long accountNumber,Double Amount);
  public void closeAccount(Long accountNumber);
}
