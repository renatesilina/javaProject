package codetest.mortage.plan;

import java.util.List;

public class RunProgram {

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        List<Customer> customers = calculate.calculate();
        if (customers != null) {
            System.out.println("__________________CUSTOMERS_________________");
            int number = 0;
            for (Customer c : customers) {
                number++;
                System.out.print("Prospect " + number + ": " + c);
                System.out.printf("%.2f", c.getMonthlyPayment());
                System.out.print(" \u20ac each month \n");
            }
        }else{
            System.out.println("Program execution failed!");
        }
    }
}
