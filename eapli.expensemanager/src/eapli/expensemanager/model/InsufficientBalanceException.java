/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class InsufficientBalanceException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException(BigDecimal currentBalance, BigDecimal expectedSpend) {
        this.currentBalance = currentBalance;
        this.expectedSpend = expectedSpend;
    }
    private BigDecimal currentBalance;
    private BigDecimal expectedSpend;

    /**
     * @return the currentBalance
     */
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    /**
     * @return the expectedSpend
     */
    public BigDecimal getExpectedSpend() {
        return expectedSpend;
    }
}
