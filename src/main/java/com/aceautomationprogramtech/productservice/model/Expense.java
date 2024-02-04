package com.aceautomationprogramtech.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Getter
@Setter
@Document("expense")
public class Expense {
    @Id
    @Field(name = "id")
    private String id;
    @Field(name = "name")
    @Indexed(unique = true)
    private String expenseName;
    @Field(name = "category")
    private ExpenseCategory expenseCategory;
    @Field(name = "amount")
    private BigDecimal expenseAmount;
    @Field(name = "date")
    private LocalDateTime date;
    ZoneId zone = ZoneId.of("Asia/Kolkata");

    public Expense(String id, String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmount, LocalDateTime expenseDate) {
        this.id = id;
        this.expenseName = expenseName;
        this.expenseCategory = expenseCategory;
        this.expenseAmount = expenseAmount;
        this.date = java.time.LocalDateTime.now(zone);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public void setDate(Date expenseDate) {
        this.date = java.time.LocalDateTime.now(ZoneId.systemDefault());
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
}
