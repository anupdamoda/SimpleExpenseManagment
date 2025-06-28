package com.aceautomationprogramtech.productservice.service;

import com.aceautomationprogramtech.productservice.model.Expense;
import com.aceautomationprogramtech.productservice.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
     expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense){
     Expense savedExpense = expenseRepository.findById(expense.getId())
             .orElseThrow(() -> new RuntimeException(
                     String.format("Cannot find expense by ID %s", expense.getId())
             ));
     savedExpense.setExpenseName(expense.getExpenseName());
     savedExpense.setExpenseAmount(expense.getExpenseAmount());
     savedExpense.setExpenseCategory(expense.getExpenseCategory());
     expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(){
      return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(()-> new RuntimeException(
                String.format("cannot find name by Name %s", name)));
    }

    public List<Expense> getExpensesBetweenDates(LocalDate fromDate, LocalDate toDate) {
        return expenseRepository.findAllByDateBetween(fromDate, toDate);
    }

    public void deleteExpense(String id)
    {
        expenseRepository.deleteById(id);
    }

    public long getCount(){
        return expenseRepository.findAll().stream().count();
    }
}
