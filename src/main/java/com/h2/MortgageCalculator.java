package com.h2;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MortgageCalculator {

    private long loanAmount;

    private int termInYears;

    private float annualRate;

    private double monthlyPayment;

    public static void main( String[] args ) {
        long loanAmount = Utilities.getLongValue(args[0]);
        int termInYears = Utilities.getIntValue(args[1]);
        float annualRate = Utilities.getFloatValue(args[2]);

        MortgageCalculator mortgageCalculator = new MortgageCalculator(loanAmount, termInYears, annualRate);

        mortgageCalculator.calculateMonthlyPayment();

        System.out.println((mortgageCalculator.toString()));
    }


    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    private int getNumberOfPayments() {
        return termInYears * 12;
    }

    private float getMonthlyInterestRate() {
        float interestRate = annualRate / 100;

        return interestRate / 12;
    }

    //M = P(r(1+r)^n/(((1+r)^n)-1)
    public void calculateMonthlyPayment() {
        long P = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();

        double M = P * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));

        this.monthlyPayment = M;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00", new DecimalFormatSymbols(Locale.US));
        return "monthlyPayment: " + df.format(monthlyPayment);
    }
}
