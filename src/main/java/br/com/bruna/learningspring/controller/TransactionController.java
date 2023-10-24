package br.com.bruna.learningspring.controller;
import br.com.bruna.learningspring.dto.CreateTransactionDto;
import br.com.bruna.learningspring.model.Transaction;
import br.com.bruna.learningspring.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody final CreateTransactionDto transactionData) throws Exception {

        final Transaction createdTransaction = transactionService.createTransaction(transactionData);

        return new ResponseEntity<Transaction>(createdTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> retrieveTransaction(@PathVariable final String id) throws Exception {

        final Transaction transaction = transactionService.retrieveTransaction(Long.parseLong((id)));

        return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);

    }
}
