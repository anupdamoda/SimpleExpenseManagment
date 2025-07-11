package com.aceautomationprogramtech.productservice.Controller;

import com.aceautomationprogramtech.productservice.model.Expense;
import com.aceautomationprogramtech.productservice.service.ExpenseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense){
      expenseService.addExpense(expense);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Object> updateExpense(@RequestBody Expense expense){
        expenseService.updateExpense(expense);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {

        // Fetch expenses from the database or service layer
        List<Expense> expenses = expenseService.getAllExpenses();
  //      return ResponseEntity.ok(expenses);
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public List<Expense> getExpensesByDateRange(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
        return expenseService.getExpensesBetweenDates(fromDate, toDate);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name){
    return ResponseEntity.ok(expenseService.getExpenseByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpense(String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/count")
//    public ResponseEntity<Long> getSum() {
//        return ResponseEntity.ok(expenseService.getCount()
//        );
//    }

}
