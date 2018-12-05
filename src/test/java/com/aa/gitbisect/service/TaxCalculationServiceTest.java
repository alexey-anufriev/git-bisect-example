package com.aa.gitbisect.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

public class TaxCalculationServiceTest {

    private TaxCalculationService taxCalculationService = new TaxCalculationService();

    @ParameterizedTest
    @CsvSource({
            "100.00, 10, 90.00",
            "100.00, 3, 97.00",
            "123.45, 5, 117.28"

    })
    public void testNetSalaryCalculation(
            BigDecimal grossSalaryInCurrency, int taxInPercent, BigDecimal expectedNetSalaryInCurrency) {

        BigDecimal actualNetSalaryInCurrency =
                taxCalculationService.getNetSalaryInCurrency(grossSalaryInCurrency, taxInPercent);

        Assertions.assertEquals(expectedNetSalaryInCurrency, actualNetSalaryInCurrency);
    }
}
