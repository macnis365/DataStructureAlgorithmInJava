package com.mathematica.ds.vanhack;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
 * Create TransactionException, DigitalWallet, and DigitalWalletTransaction classes here.
 */
public class Solution_DigitalWallet {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final DigitalWalletTransaction DIGITAL_WALLET_TRANSACTION = new DigitalWalletTransaction();

    private static final Map<String, DigitalWallet> DIGITAL_WALLETS = new HashMap<>();

    public static void main(String[] args) {
        int numberOfWallets = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfWallets-- > 0) {
            String[] wallet = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet;

            if (wallet.length == 2) {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1]);
            } else {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1], wallet[2]);
            }

            DIGITAL_WALLETS.put(wallet[0], digitalWallet);
        }

        int numberOfTransactions = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfTransactions-- > 0) {
            String[] transaction = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet = DIGITAL_WALLETS.get(transaction[0]);

            if (transaction[1].equals("add")) {
                try {
                    DIGITAL_WALLET_TRANSACTION.addMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully credited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            } else {
                try {
                    DIGITAL_WALLET_TRANSACTION.payMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully debited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            }
        }

        System.out.println();

        DIGITAL_WALLETS.keySet()
                .stream()
                .sorted()
                .map((digitalWalletId) -> DIGITAL_WALLETS.get(digitalWalletId))
                .forEachOrdered((digitalWallet) -> {
                    System.out.println(digitalWallet.getWalletId()
                            + " " + digitalWallet.getUsername()
                            + " " + digitalWallet.getWalletBalance());
                });
    }
}

class TransactionException extends RuntimeException{
    private static final long serialVersionUID = 7526472295622776147L;

    private String errorMessage;
    private String errorCode;

    public TransactionException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return errorMessage;
    }
}

class DigitalWalletTransaction {

    public static final String INSUFFICIENT_BALANCE = "INSUFFICIENT_BALANCE";
    public static final String INVALID_AMOUNT = "INVALID_AMOUNT";
    public static final String USER_NOT_AUTHORIZED = "USER_NOT_AUTHORIZED";

    public void addMoney(DigitalWallet digitalWallet, int amount) {
        checkUserAuthorization(digitalWallet);
        checkForValidAmount(amount);
        creditToWallet(digitalWallet, amount);
    }

    public void payMoney(DigitalWallet digitalWallet, int amount) {
        checkUserAuthorization(digitalWallet);
        checkForValidAmount(amount);
        debitFromWallet(digitalWallet, amount);
    }

    private void creditToWallet(DigitalWallet digitalWallet, int amount) {
        int currentWalletBalance = digitalWallet.getWalletBalance();
        digitalWallet.setWalletBalance(amount + currentWalletBalance);
    }

    private void debitFromWallet(DigitalWallet digitalWallet, int amount) {
        int currentWalletBalance = digitalWallet.getWalletBalance();
        checkSufficientBalance(currentWalletBalance, amount);
        digitalWallet.setWalletBalance(currentWalletBalance - amount);
    }

    private void checkSufficientBalance(int currentWalletBalance, int amount) {
        if (currentWalletBalance < amount) {
            throw new TransactionException("Insufficient balance", INSUFFICIENT_BALANCE);
        }
    }

    private void checkForValidAmount(int amount) {
        if (amount <= 0) {
            throw new TransactionException("Amount should be greater than zero", INVALID_AMOUNT);
        }
    }

    private void checkUserAuthorization(DigitalWallet digitalWallet) {
        if (null == digitalWallet.getUserAccessCode() || digitalWallet.getUserAccessCode().isEmpty()) {
            throw new TransactionException("User not authorized", USER_NOT_AUTHORIZED);
        }
    }
}

class DigitalWallet {
    private String id;
    private String userName;
    private String userAccessCode;
    private int walletBalance;

    public DigitalWallet(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public DigitalWallet(String id, String userName, String userAccessCode) {
        this.id = id;
        this.userName = userName;
        this.userAccessCode = userAccessCode;
    }

    public String getWalletId() {
        return id;
    }

    public String getUsername() {
        return userName;
    }

    public String getUserAccessCode() {
        return userAccessCode;
    }

    public int getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(int walletBalance) {
        this.walletBalance = walletBalance;
    }
}

