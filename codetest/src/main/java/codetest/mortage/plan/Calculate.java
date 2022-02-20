package codetest.mortage.plan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {

    public List<Customer> calculate() {

        List<Customer> customers = new ArrayList<>();
        File prospects = new File("src/main/resources/prospects.txt");
        // Use try with resources for automatic file closing
        try (Scanner read = new Scanner(prospects)){
            while (read.hasNextLine()) {
                // Use delimiter to save data
                String line = read.nextLine();
                // Returned line contains data
                if (!line.isEmpty()) {
                    // Mach data to patterns
                    if(matchPatterns(line) != null){
                        customers.add(matchPatterns(line));
                    }
                }

            }
            return customers;
        } catch (FileNotFoundException e) {
            System.out.println("Fail not found!");
            e.printStackTrace();
            return null;
        }
    }

    public Customer matchPatterns(String line){
        Pattern pattern = Pattern.compile("(\\w+|\\w+\\s\\w+),(\\d+|\\d+\\.\\d+),(\\d+|\\d+\\.\\d+),(\\d+)", Pattern.UNICODE_CHARACTER_CLASS);
        Pattern pattern1 = Pattern.compile("(\"\\w+),(\\w+\"),(\\d+|\\d+\\.\\d+),(\\d+|\\d+\\.\\d+),(\\d+)", Pattern.UNICODE_CHARACTER_CLASS);

        Matcher matcher = pattern.matcher(line);
        Matcher matcher1 = pattern1.matcher(line);
        if (matcher1.matches()) {
            // Replace quotation marks and first comma
            line = line.replace("\"", "").replaceFirst(",", " ");
            // Update to replaced line
            matcher = pattern.matcher(line);
        }
        if (matcher.matches()) {
            // Separate data at commas
            MatchResult result = matcher.toMatchResult();
            // Set values in customer class
            return saveCustomerData(result);
        }else {
            return null;
        }
    }

    public Customer saveCustomerData(MatchResult result){
        // Insert the split line data into customer class
        Customer customer;
        customer = new Customer();
        customer.setName(result.group(1));
        customer.setTotalLoan(Double.parseDouble(result.group(2)));
        customer.setInterest(Double.parseDouble(result.group(3)));
        customer.setYears(Integer.parseInt(result.group(4)));
        // Calculate monthly interest
        customer.setMonthlyPayment(calculateMortage(customer.getTotalLoan(), customer.getInterest(), customer.getYears()));
        return customer;
    }

    public double calculateMortage(double totalLoan, double interest, int years) {
        // Mortage formula: E = U[b(1 + b)^p]/[(1 + b)^p - 1]
        // E = Fixed monthly payment
        // b = Interest on a monthly basis
        // U = Total loan
        // p = Number of payments

        // Got more correct answers with code below and by using java.math
        //return totalLoan * ((Math.pow((1 + b), p)*b)/(Math.pow((1 + b), (p))-1));

        // java.math and similar dependencies where not allowed, so I tried to make my own solution below
        // and got pretty close to correct answers:

        double b = (interest / 100) / 12;
        double p = years * 12;
        double first = (1 + b);
        double second = (1 + b);

        // codetest.mortage.plan.Calculate ^p
        for (int i = 0; i < p; i++) {
            first *= (1 + b);
            second *= (1 + b);
        }
        return totalLoan * ((b*first)/(second-1));
    }
}
