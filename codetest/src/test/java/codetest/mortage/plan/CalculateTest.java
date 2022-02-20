package codetest.mortage.plan;
import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testPatterns(){
        Customer expCustomer = new Customer();
        expCustomer.setName("Juha");
        expCustomer.setTotalLoan(1000);
        expCustomer.setInterest(5);
        expCustomer.setYears(2);
        Calculate calculate = new Calculate();
        Customer result = calculate.matchPatterns("Juha,1000,5,2");
        assertEquals(expCustomer.getName(),result.getName());
        assertEquals(expCustomer.getTotalLoan(), result.getTotalLoan());
        assertEquals(expCustomer.getInterest(), result.getInterest());
        assertEquals(expCustomer.getYears(), result.getYears());
    }

    @org.junit.jupiter.api.Test
    void testPatterns1(){
        Customer expCustomer = new Customer();
        expCustomer.setName("Karvinen");
        expCustomer.setTotalLoan(4356);
        expCustomer.setInterest(1.27);
        expCustomer.setYears(6);
        Calculate calculate = new Calculate();
        Customer result = calculate.matchPatterns("Karvinen,4356,1.27,6");
        assertEquals(expCustomer.getName(),result.getName());
        assertEquals(expCustomer.getTotalLoan(), result.getTotalLoan());
        assertEquals(expCustomer.getInterest(), result.getInterest());
        assertEquals(expCustomer.getYears(), result.getYears());
    }

    @org.junit.jupiter.api.Test
    void testPatterns2(){
        Customer expCustomer = new Customer();
        expCustomer.setName("Claes Månsson");
        expCustomer.setTotalLoan(1300.55);
        expCustomer.setInterest(8.67);
        expCustomer.setYears(2);
        Calculate calculate = new Calculate();
        Customer result = calculate.matchPatterns("Claes Månsson,1300.55,8.67,2");
        assertEquals(expCustomer.getName(),result.getName());
        assertEquals(expCustomer.getTotalLoan(), result.getTotalLoan());
        assertEquals(expCustomer.getInterest(), result.getInterest());
        assertEquals(expCustomer.getYears(), result.getYears());
    }

    @org.junit.jupiter.api.Test
    void testPatterns3(){
        Customer expCustomer = new Customer();
        expCustomer.setName("Clarencé Andersson");
        expCustomer.setTotalLoan(2000.0);
        expCustomer.setInterest(6.0);
        expCustomer.setYears(4);
        Calculate calculate = new Calculate();
        Customer result = calculate.matchPatterns("\"Clarencé,Andersson\",2000,6,4");
        assertEquals(expCustomer.getName(),result.getName());
        assertEquals(expCustomer.getTotalLoan(), result.getTotalLoan());
        assertEquals(expCustomer.getInterest(), result.getInterest());
        assertEquals(expCustomer.getYears(), result.getYears());
    }

    @org.junit.jupiter.api.Test
    void testCalculateMortage(){
        Calculate calculate = new Calculate();
        double totalLoan = 1000;
        double interest = 5;
        int years = 2;
        double expResult = 42.2026962560176;
        double result = calculate.calculateMortage(totalLoan,interest,years);
        assertEquals(expResult,result);
    }

    @org.junit.jupiter.api.Test
    void testCalculateMortage1(){
        Calculate calculate = new Calculate();
        double totalLoan = 1300.55;
        double interest = 8.67;
        int years = 2;
        double expResult = 57.04879285779864;
        double result = calculate.calculateMortage(totalLoan,interest,years);
        assertEquals(expResult,result);
    }
}
