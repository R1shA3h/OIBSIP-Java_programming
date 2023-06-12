package com.mycompany.atm_interface;
public class Trans {
        private String type;
        private double amount;

        public Trans(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }
}
