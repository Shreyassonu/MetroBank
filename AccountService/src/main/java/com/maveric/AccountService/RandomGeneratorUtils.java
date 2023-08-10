package com.maveric.AccountService;

import java.util.Random;

public class RandomGeneratorUtils {
    private static final String ACCOUNT_NUMBER_PREFIX = "12345678";
    public static String generateAccountNumber() {
        // Generate the dynamic part (last 4 digits)
        String dynamicPart = generateRandomDigits(4);

        // Combine the constant prefix and dynamic suffix
        return ACCOUNT_NUMBER_PREFIX + dynamicPart;
    }
    private static String generateRandomDigits(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();}
}
