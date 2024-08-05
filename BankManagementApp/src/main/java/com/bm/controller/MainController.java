package com.bm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bm.entity.Account;
import com.bm.service.AccountService;

@RestController
@ComponentScan
@RequestMapping("/account")
public class MainController {

  @Autowired
  private AccountService accountService;

  //creating account
  @PostMapping("/create")
  public ResponseEntity<Account> createAccount(@RequestBody Account Account){

   Account account = accountService.createAccount(Account);

    return ResponseEntity.status(HttpStatus.CREATED).body(account);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable Long id){

    Account account = accountService.getAccountDeatilsByAccountNumber(id);

    return ResponseEntity.status(HttpStatus.FOUND).body(account);
  }

  @GetMapping("/getallaccount")
  public ResponseEntity<List<Account>> getAllAccountDetails(){

    List<Account> list= accountService.getAllAccountDetails();
    
    return ResponseEntity.status(HttpStatus.FOUND).body(list);
  }

  @PutMapping("/deposit/{accountNumber}/{amount}")
  public Account deposiAccount(@PathVariable Long accountNumber,@PathVariable Double amount){

    Account account = accountService.depositAmount(accountNumber, amount);

    return account;
  }

  @PutMapping("/withdraw/{accountNumber}/{amount}")
  public Account withDrawAmount(@PathVariable Long accountNumber , @PathVariable Double amount ){

   Account account =  accountService.withDrawAmount(accountNumber, amount);

    return account;
  }

  @DeleteMapping("/delete/{accountNumber}")
  public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){

    accountService.closeAccount(accountNumber);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Close");
  }
}
