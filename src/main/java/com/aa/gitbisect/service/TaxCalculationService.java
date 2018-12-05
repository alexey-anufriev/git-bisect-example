package com.aa.gitbisect.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculationService {

    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    /**
     * Return calculated net salary in currency (with two decimal places)
     * @param grossSalaryInCurrency gross salary in currency (with two decimal places)
     * @param taxInPercent tax level in percent
     * @return net salary in currency (with two decimal places)
     */
    public BigDecimal getNetSalaryInCurrency(BigDecimal grossSalaryInCurrency, int taxInPercent) {
        BigDecimal taxInCurrency = getPercentPart(grossSalaryInCurrency, taxInPercent);

        return grossSalaryInCurrency
                .subtract(taxInCurrency)
                .setScale(2, ROUNDING_MODE);
    }

    private static BigDecimal getPercentPart(BigDecimal value, int percent) {
        return value.multiply(BigDecimal.valueOf(percent)).divide(BigDecimal.valueOf(100), ROUNDING_MODE);
    }
}
