package br.com.bruna.learningspring.service;

import br.com.bruna.learningspring.dto.CreateTransactionDto;
import br.com.bruna.learningspring.model.Transaction;


import java.util.Objects;

public interface TransactionService {

     Transaction createTransaction(final CreateTransactionDto transactionData);
     Transaction retrieveTransaction(final long id);

}
