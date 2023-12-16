package com.driver;

import java.util.Stack;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance);
        this.tradeLicenseId=tradeLicenseId;
        this.setMinBalance(5000);
        if(this.getBalance()<this.getMinBalance()){
            throw new Exception("Insufficient Balance");
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        for(int i=0;i<this.tradeLicenseId.length()-1;i++){
            char c1=tradeLicenseId.charAt(i);
            char c2=tradeLicenseId.charAt(i+1);
            if(c1==c2){
                throw new Exception("Valid License can not be generated");
            }
        }
    }

}
