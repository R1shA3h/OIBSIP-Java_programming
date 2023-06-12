package com.mycompany.atm_interface;

import java.util.ArrayList;
import java.util.List;

public class Acc{
        private String userID;
        private String pass;
        private double bal;
        private List<Trans> transhistory;
        
        public Acc(String userID,String pass,double bal){
            this.userID=userID;
            this.pass=pass;
            this.bal=bal;
            this.transhistory=new ArrayList<>();
        }
        
        public String getUserID(){
            return userID;
        }
        public boolean validatePin(String userPin) {
        return this.pass.equals(pass);
        }

        public double getBalance() {
            return bal;
        }

        public void deposit(double amount) {
            bal += amount;
            transhistory.add(new Trans("Deposit", amount));
        }
        public boolean withdraw(double amount) {
            if (bal >= amount) {
                bal -= amount;
                transhistory.add(new Trans("Withdraw", amount));
                return true;
            }
            return false;
        }   
        public void transfer(Acc recipient, double amount) {
            if (bal >= amount) {
            bal -= amount;
            recipient.deposit(amount);
            transhistory.add(new Trans("Transfer", amount));
            }
        }

        public List<Trans> getTransactionHistory() {
           return transhistory;
        }
}
