package pl.edu.pw.ee;

import java.util.Arrays;

public class Surprise {

    public int countChanges(String list, int K) {
        int min = K;
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null!\n");
        }
        if (K < 0 || K > 999999) {
            throw new IllegalArgumentException("Illegal K value!\n");
        }
        if (list.length() < K) {
            return -1;
        }
        char[] listArray = list.toCharArray();
        if (list.length() == K) {
            return countRequiredChanges(listArray);
        }
        if (K == 0) {
            return listArray.length - countRequiredChanges(listArray);
        }

        int howManyTimes = bombTooLargeGroups(listArray, K);

        int temp;
        for (int i = 0; i < list.length() - K - 1; i++) {
            temp = 0;
            if (i != 0) {
                if (listArray[i - 1] == 'M') {
                    temp++;
                }
            }
            temp += countRequiredChanges(Arrays.copyOfRange(listArray, i, K + i));
            if (i + K != list.length()) {
                if (listArray[i + K + 1] == 'M') {
                    temp++;
                }
            }
            if (temp < min) {
                min = temp;
            }
        }
        if (howManyTimes > 0) {
            return howManyTimes;
        }
        return min;
    }

    private int countRequiredChanges(char[] list) {
        int counter = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 'K') {
                counter++;
            }
        }
        return counter;
    }

    private int bombTooLargeGroups(char[] list, int K) {
        int counter = 0;
        int swap = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 'M') {
                counter++;
            } else {
                counter = 0;
            }
            if (counter > K) {
                list[i] = 'K';
                counter = 0;
                swap++;

            }

        }

        return swap;
    }

}
