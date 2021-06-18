package com.springhow.examples.drools;

public class LoanApplication {
    private int age;
    private String name;
    private int loanAmount;
    private boolean approved;

    public LoanApplication(String name, int age, int loanAmount) {
        this.age = age;
        this.name = name;
        this.loanAmount = loanAmount;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
