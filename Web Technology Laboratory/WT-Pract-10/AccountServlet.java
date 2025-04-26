package com.banking.web;

import com.banking.ejb.AccountService;
import com.banking.ejb.TransactionException;
import com.banking.model.Account;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    
    @EJB
    private AccountService accountService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String accountNumber = request.getParameter("accountNumber");
        
        try {
            switch (action) {
                case "deposit":
                    double depositAmount = Double.parseDouble(request.getParameter("amount"));
                    Account depositedAccount = accountService.deposit(accountNumber, depositAmount);
                    request.setAttribute("account", depositedAccount);
                    request.setAttribute("message", "Deposit successful!");
                    break;
                    
                case "withdraw":
                    double withdrawAmount = Double.parseDouble(request.getParameter("amount"));
                    Account withdrawnAccount = accountService.withdraw(accountNumber, withdrawAmount);
                    request.setAttribute("account", withdrawnAccount);
                    request.setAttribute("message", "Withdrawal successful!");
                    break;
                    
                case "find":
                    Account foundAccount = accountService.findAccount(accountNumber);
                    if (foundAccount != null) {
                        request.setAttribute("account", foundAccount);
                    } else {
                        request.setAttribute("error", "Account not found");
                    }
                    break;
            }
        } catch (TransactionException e) {
            request.setAttribute("error", e.getMessage());
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid amount format");
        }
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}