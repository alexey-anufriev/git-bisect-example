package com.aa.gitbisect.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculationService {

    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    /**
     * Return calculated net salary in currency (with two decimal places)
     * @param grossSalaryInCurrency gross salary in currency (with two decimal places)
     * @param taxInPercent tax level in percent
     * @return net salary in currency (with two decimal places)
     */
    public BigDecimal getNetSalaryInCurrency(BigDecimal grossSalaryInCurrency, int taxInPercent) {
        BigDecimal taxInCurrency = grossSalaryInCurrency
                .multiply(BigDecimal.valueOf(taxInPercent))
                .divide(HUNDRED, ROUNDING_MODE);

        return grossSalaryInCurrency
                .subtract(taxInCurrency)
                .setScale(2, ROUNDING_MODE);
    }
}
