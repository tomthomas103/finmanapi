package com.thoma.finmanapi.entity;

public enum AccountGroup {
    SAVINGSACC(AccountType.INVESTMENT),CURRENTACC(AccountType.INVESTMENT),
        OVERDRAFT(AccountType.INVESTMENT),CASH(AccountType.INVESTMENT),
        CREDITCARD(AccountType.LIABILITY),SALARY(AccountType.INCOME),
            INSURANCE(AccountType.EXPENSE),LOAN(AccountType.LIABILITY),MORTGAGE(AccountType.LIABILITY);

    public final AccountType type;

    AccountGroup( AccountType type) {
        this.type = type;
    }

    public AccountType getAccountTyp(){
        return type;
    }
}
