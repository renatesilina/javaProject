package codetest.mortage.plan;

public class Customer {
    private String name;
    private double totalLoan;
    private double interest;
    private int years;
    private double monthlyPayment;

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getInterest() {
        return interest;
    }

    public int getYears() {
        return years;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        return name + " wants to borrow "
                + totalLoan + " \u20ac for a period of " +years +" years and pay ";
    }
}
