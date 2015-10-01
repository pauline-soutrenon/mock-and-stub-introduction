package kata;

import java.util.ArrayList;
import java.util.List;

public class Primes {

    public List<Integer> factorsIn(int number) {
	ArrayList<Integer> factors = new ArrayList<Integer>();
	for (int candidate = 2; candidate<= number; candidate++) {
	    number = addFactorsOf(number, candidate, factors);
	    
	}
	return factors;
    }

    private int addFactorsOf(int number, int divisor, ArrayList<Integer> factors) {
	while (isDividableBy(number, divisor)) {
	    factors.add(divisor);
	    number = number / divisor;
	}
	return number;
    }

    private boolean isDividableBy(int number, int factor) {
	return number % factor == 0 && number >=factor;
    }

}
