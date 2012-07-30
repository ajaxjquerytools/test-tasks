package com.epam.test.happynumber;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class HappyNumberUtils {

	public static int isHappy(String line) throws NumberFormatException {

		long number = Integer.parseInt(line);
		if (number <= 0) {
			throw new NumberFormatException("String " + number + " must be greater then 0");
		}

		long squareSum = 0;
		int digit = 0;
		HashSet<Long> cycle = new LinkedHashSet<Long>();
		while (number != 1 && cycle.add(number)) {
			squareSum = 0;
			while (number > 0) {
				digit = (int) (number % 10);
				squareSum += Math.pow(digit, 2);
				number /= 10;
			}
			number = squareSum;
		}

		return number == 1 ? 1 : 0;

	}
}