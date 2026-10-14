package org.example.dataBase;

import org.example.expenses.Expenses;
import org.example.saving.Saving;
import org.example.user.Users;

public record IncomeRecord(int id, Users users, Expenses expenses, Saving saving) {
}
