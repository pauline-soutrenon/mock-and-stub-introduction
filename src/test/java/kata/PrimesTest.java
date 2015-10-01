package kata;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class PrimesTest {

    Primes primes = new Primes();
    
    @Test public void 
    forNumbersLessThanTwo_returnsEmptyList() throws Exception {
	 assertThat(factorsIn(0)).isEmpty();
	 assertThat(factorsIn(1)).isEmpty();
    }
    
    @Test public void 
    forPrimes_returnsThePrimeWrappedInAList() throws Exception {
	 assertThat(factorsIn(2)).containsExactly(2);
	 assertThat(factorsIn(3)).containsExactly(3);
	 assertThat(factorsIn(5)).containsExactly(5);
	 assertThat(factorsIn(197)).containsExactly(197);
    }
    
    @Test public void 
    whenThePrimeIsDivisibleTwiceByOneFactor_thenTheFactorAppearsTwiceInTheResult() throws Exception {
	assertThat(factorsIn(4)).containsExactly(2, 2); 
	assertThat(factorsIn(8)).containsExactly(2, 2, 2); 
	assertThat(factorsIn(9)).containsExactly(3, 3); 
	assertThat(factorsIn(27)).containsExactly(3, 3, 3); 
	assertThat(factorsIn(25)).containsExactly(5, 5); 
    }
    
    @Test public void 
    itCanHandleBigNumbers() throws Exception {
	assertThat(factorsIn(2310)).containsExactly(2, 3, 5, 7, 11); 
    }
    

    
    private List<Integer> factorsIn(int number) {
	return primes.factorsIn(number);
    }
}
