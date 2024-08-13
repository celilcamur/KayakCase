package com.kayak.utils.helpers;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberHelper {

    public static String getRandomSapNumber() {
        Random rnd = new Random();
        return "7" + rnd.nextInt(999999999);
    }

    public static String getRandomOrderNumber() {
        Random rnd = new Random();
        return "00" + rnd.nextInt(99999999);
    }

    public static String getRandomPhoneNumber() {
        return "0537" + ThreadLocalRandom.current().nextInt(1111111,9999999);
    }

    public static int getNumber() {
        Random rnd = new Random();
        return rnd.nextInt(99999999);
    }

    public static String getMersisNumber() {
        Random rnd = new Random();
        return "12345678" + String.valueOf(rnd.nextInt((99999999 - 10000000) + 1) + 10000000);
    }
}
