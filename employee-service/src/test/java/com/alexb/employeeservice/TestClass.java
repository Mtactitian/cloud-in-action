package com.alexb.employeeservice;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestClass {
    private static boolean check(int[] arr, int k, int currentValue, int iterator) {
        if (iterator == arr.length || arr[iterator] > currentValue) {
            return false;
        }
        if (arr[iterator] == k) {
            return true;
        }
        if (arr[iterator] < currentValue) {
            return check(arr, k, currentValue, iterator + 1);
        } else {
            return check(arr, k, currentValue + 1, iterator + 1);
        }
    }

    public static boolean check(int[] arr, int k) {
        if (k == 0 && arr.length > 0)
            return false;
        if (arr[arr.length - 1] != k || arr[0] != 1)
            return false;
        else {
            return check(arr, k, 1, 0);
        }
    }

    @Test
    public void executeTests() {
        assertTrue(check(new int[]{1, 1, 2, 2, 3, 3}, 3));
        assertFalse(check(new int[]{1, 1, 3}, 2));
        assertFalse(check(new int[]{1, 1, 3}, 3));
    }
}
