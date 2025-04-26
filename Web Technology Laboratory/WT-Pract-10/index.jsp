<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Banking Application</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 600px; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        .message { color: green; font-weight: bold; }
        .error { color: red; font-weight: bold; }
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bank Account Transactions</h1>
        
        <c:if test="${not empty message}">
            <p class="message">${message}</p>
        </c:if>
        
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>
        
        <form method="post" action="account">
            <div class="form-group">
                <label>Account Number:</label>
                <input type="text" name="accountNumber" required>
                <input type="hidden" name="action" value="find">
                <button type="submit">Find Account</button>
            </div>
        </form>
        
        <c:if test="${not empty account}">
            <table>
                <tr>
                    <th>Account Number</th>
                    <th>Account Holder</th>
                    <th>Balance</th>
                </tr>
                <tr>
                    <td>${account.accountNumber}</td>
                    <td>${account.accountHolder}</td>
                    <td>$${account.balance}</td>
                </tr>
            </table>
            
            <h2>Transactions</h2>
            <form method="post" action="account">
                <input type="hidden" name="accountNumber" value="${account.accountNumber}">
                <div class="form-group">
                    <label>Amount:</label>
                    <input type="number" step="0.01" name="amount" required>
                </div>
                <div class="form-group">
                    <button type="submit" name="action" value="deposit">Deposit</button>
                    <button type="submit" name="action" value="withdraw">Withdraw</button>
                </div>
            </form>
        </c:if>
    </div>
</body>
</html>