package com.aa.gitbisect.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculationService {

    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private static final int HUNDRED_PERCENT = 100;
    private static final int NUMBER_OF_DECIMAL_PLACES = 2;

    /**
     * Return calculated net salary in currency (with two decimal places)
     * @param grossSalaryInCurrency gross salary in currency (with two decimal places)
     * @param taxInPercent tax level in percent
     * @return net salary in currency (with two decimal places)
     */
    public BigDecimal getNetSalaryInCurrency(BigDecimal grossSalaryInCurrency, int taxInPercent) {
        BigDecimal taxInCurrency = getPercentPart(grossSalaryInCurrency, taxInPercent);
        BigDecimal netSalaryInCurrency = grossSalaryInCurrency.subtract(taxInCurrency);
        return formatToCurrency(netSalaryInCurrency);
    }

    private static BigDecimal getPercentPart(BigDecimal value, int percent) {
        return value.multiply(BigDecimal.valueOf(percent)).divide(BigDecimal.valueOf(HUNDRED_PERCENT), ROUNDING_MODE);
    }

    private static BigDecimal formatToCurrency(BigDecimal value) {
        return value.setScale(NUMBER_OF_DECIMAL_PLACES, ROUNDING_MODE);
    }
}
