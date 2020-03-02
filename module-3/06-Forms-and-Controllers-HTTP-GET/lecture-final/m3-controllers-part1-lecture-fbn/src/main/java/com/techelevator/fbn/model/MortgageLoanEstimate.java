package com.techelevator.fbn.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MortgageLoanEstimate {

	private BigDecimal loanAmount;
	private int loanTermInYears;
	private BigDecimal interestRate;

	public MortgageLoanEstimate(BigDecimal loanAmount, int loanTermInYears, BigDecimal interestRate) {
		this.loanAmount = loanAmount.setScale(10);
		this.loanTermInYears = loanTermInYears;
		this.interestRate = interestRate.setScale(10);
	}

	public BigDecimal getMonthlyPayment() {
		int loanTermInMonths = loanTermInYears * 12;
		interestRate = interestRate.divide(new BigDecimal(100), 10, RoundingMode.HALF_UP);
		BigDecimal monthlyInterestRate = interestRate.divide(new BigDecimal(12), 10, RoundingMode.HALF_UP);
		BigDecimal temp = monthlyInterestRate.add(BigDecimal.ONE).pow(loanTermInMonths);
		BigDecimal payment = loanAmount.multiply(
				(monthlyInterestRate.multiply(temp)).divide(temp.subtract(BigDecimal.ONE), 10, RoundingMode.HALF_UP));
		return payment.setScale(2, RoundingMode.HALF_UP);
	}
}
