package com.aceautomationprogramtech.productservice.Controller;

import com.aceautomationprogramtech.productservice.model.Expense;
import com.aceautomationprogramtech.productservice.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProtectedController {
    @GetMapping("/dashboard")
    public String getProtectedData() {
        return "This is a protected route";
    }

    private final ExpenseService expenseService;

    public ProtectedController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/expense")
//    public ResponseEntity<List<Expense>> getAllExpenses() {
//
//        // Fetch expenses from the database or service layer
//        List<Expense> expenses = expenseService.getAllExpenses();
//        return ResponseEntity.ok(expenses);
////        return ResponseEntity.ok(expenseService.getAllExpenses());
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("expense/count")
    public ResponseEntity<Long> getSum() {
        return ResponseEntity.ok(expenseService.getCount()
        );
    }

}
