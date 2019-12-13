package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.entities.accounts.*;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account/checking/{id}")
    public ResponseEntity<Checking> getCheckingAccount(@RequestBody User user, @PathVariable long id) {
        return new ResponseEntity<>(accountService.showAChecking(id), HttpStatus.OK);
    }

    @GetMapping("/account/savings/{id}")
    public ResponseEntity<Savings> getSavingsAccount(@RequestBody User owner, @PathVariable long id) {
        return new ResponseEntity<>(accountService.showSavings(id), HttpStatus.OK);
    }

    @GetMapping("/account/investment/{id}")
    public ResponseEntity<Investment> getInvestmentAccount(@RequestBody User owner, @PathVariable long id) {
        return new ResponseEntity<>(accountService.showInvestments(id), HttpStatus.OK);
    }

    @GetMapping("/account/goalaccount/{id}")
    public ResponseEntity<GoalAccount> getGoalAccount(@RequestBody User owner, @PathVariable long id) {
        return new ResponseEntity<>(accountService.showGoalAccounts(id), HttpStatus.OK);
    }
//
//    @GetMapping("/accounts/checking")
//    public ResponseEntity<Checking> showAllChecking(@RequestBody User owner) {
//        return new ResponseEntity<>(accountService.showAllChecking(owner), HttpStatus.OK);
//    }
//
//    @GetMapping("/accounts/savings")
//    public ResponseEntity<Savings> showAllSavings(@RequestBody User owner) {
//        return new ResponseEntity<>(accountService.showAllSavings(owner), HttpStatus.OK);
//    }
//
//    @GetMapping("/accounts/investments")
//    public ResponseEntity<Investment> showAllInvestments(@RequestBody User owner) {
//        return new ResponseEntity<>(accountService.showAllInvestments(owner), HttpStatus.OK);
//    }
//
//    @GetMapping("/accounts/goalaccount")
//    public ResponseEntity<GoalAccount> showAllGoalAccounts(@RequestBody User owner) {
//        return new ResponseEntity<>(accountService.showAllGoalAccounts(owner), HttpStatus.OK);
//    }




    @PutMapping("/account/{id}")
    public ResponseEntity<Account> modifyAccount(@RequestBody Account account, @PathVariable long id) {
        return null;
    }




//    @DeleteMapping("/account/checking/{id}")
//    public ResponseEntity<Checking> closeChecking(@RequestBody Checking checking, @PathVariable long id) {
//        return new ResponseEntity<>(accountService.closeChecking(checking, id), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/account/savings/{id}")
//    public ResponseEntity<Savings> closeSavings(@RequestBody Savings savings, @PathVariable long id) {
//        return new ResponseEntity<>(accountService.closeSavings(savings, id), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/account/investment/{id}")
//    public ResponseEntity<Investment> closeInvestments(@RequestBody Investment investment, @PathVariable long id) {
//        return new ResponseEntity<>(accountService.closeInvestments(investment, id), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/account/goalaccount/{id}")
//    public ResponseEntity<GoalAccount> closeGoalAccount(@RequestBody GoalAccount goalAccount, @PathVariable long id) {
//        return new ResponseEntity<>(accountService.closeGoalAccount(goalAccount, id), HttpStatus.OK);
//    }

    @PostMapping("/accounts/checking")
    public ResponseEntity<Checking> createChecking(@RequestBody Checking checking, @PathVariable User owner) {
        return new ResponseEntity<>(accountService.createChecking(checking, owner), HttpStatus.CREATED);
    }

    @PostMapping("/accounts/savings")
    public ResponseEntity<Savings> createSavings(@RequestBody Savings savings, @PathVariable User owner) {
        return new ResponseEntity<>(accountService.createSavings(savings, owner), HttpStatus.CREATED);
    }

    @PostMapping("/accounts/investment")
    public ResponseEntity<Investment> createInvestments(@RequestBody Investment investment, @PathVariable User owner) {
        return new ResponseEntity<>(accountService.createInvestments(investment, owner), HttpStatus.CREATED);
    }

    @PostMapping("/accounts/goalaccount")
    public ResponseEntity<GoalAccount> createGoalAccount(@RequestBody GoalAccount goalAccount, @PathVariable User owner) {
        return new ResponseEntity<>(accountService.createGoalAccount(goalAccount, owner), HttpStatus.CREATED);
    }

//    @GetMapping("/accounts/checking/{userId}")
//    public ResponseEntity<Iterable<Checking>> getCheckingAccountsForUser(@RequestBody Checking checking, @PathVariable long userId) {
//        return new ResponseEntity<>(accountService.getCheckingBalance(checking), HttpStatus.OK);
//    }
//
//    @GetMapping("/accounts/savings/{userId}")
//    public ResponseEntity<Iterable<Savings>> getSavingsAccountsForUser(@RequestBody Savings savings, @PathVariable long userId) {
//        return new  ResponseEntity<>(accountService.getSavingBalance(savings), HttpStatus.OK);
//    }
//
//    @GetMapping("/accounts/investment/{userId}")
//    public ResponseEntity<Iterable<Investment>> getInvestmentAccountsForUser(@RequestBody Investment investment, @PathVariable long userId) {
//        return new ResponseEntity<>(accountService.getInvestmentBalance(investment), HttpStatus.OK);
//    }
//
//    @GetMapping("/accounts/goalaccount/{userId}")
//    public ResponseEntity<Iterable<GoalAccount>> getGoalAccountsForUser(@RequestBody GoalAccount goalAccount, @PathVariable long userId) {
//        return new ResponseEntity<>( accountService.getGoalAccountBalance(goalAccount), HttpStatus.OK);
//    }
}
