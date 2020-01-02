package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.exceptions.InsufficientFundsException;
import com.example.demo.exceptions.NegativeBalanceException;
import com.example.demo.exceptions.OwnershipNotSameException;
import com.example.demo.services.AccountService;
import com.example.demo.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransferController {


    @Autowired
    AccountService accountService;

    @Autowired
    TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity transferFunds(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam double amount) {

        try {
            Account from = accountService.showAccount(fromAccountId);
            Account to = accountService.showAccount(toAccountId);
            transferService.transfer(from, to, amount);
        } catch (InsufficientFundsException ex) {
            return new ResponseEntity<InsufficientFundsException>(ex, HttpStatus.FORBIDDEN);


        } catch (NegativeBalanceException neg) {
            return new ResponseEntity<NegativeBalanceException>(neg, HttpStatus.FORBIDDEN);


        }catch (OwnershipNotSameException signer){
            return new ResponseEntity<OwnershipNotSameException>(signer,HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


