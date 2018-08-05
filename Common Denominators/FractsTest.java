import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class FractsTest {

	@Test
	public void test_convertFrac() throws Exception {
		long[][] lst = new long[][] { { 1, 2 }, { 1, 3 }, { 1, 4 } };
		assertEquals("(6,12)(4,12)(3,12)", Fracts.convertFrac(lst));
	}

	@Test
	public void test_getReducedFraction() {
		assertArrayEquals(new long[] { 11, 35 }, Fracts.getReducedFraction(66, 210));
		assertArrayEquals(new long[] { 35, 11 }, Fracts.getReducedFraction(210, 66));
	}

	@Test
	public void test_getFactors() {
		ArrayList<Long> expectedFactors = new ArrayList<Long>();
		expectedFactors.add(1l);
		expectedFactors.add(2l);
		expectedFactors.add(4l);
		expectedFactors.add(8l);
		expectedFactors.add(16l);
		expectedFactors.add(32l);
		expectedFactors.add(64l);
		expectedFactors.add(128l);
		expectedFactors.add(256l);
		expectedFactors.add(512l);

		assertArrayEquals(expectedFactors.toArray(), Fracts.getFactors(512l).toArray());
	}

	@Test
	public void test_getLeastCommonMultiple() {
		long[] testDenominators = new long[] { 65, 10, 5 };
		long LCM = 130;

		long[] testDenominators2 = new long[] { 17, 4, 9 };
		long LCM2 = 612;

		assertEquals(LCM, Fracts.getLeastCommonMultiple(testDenominators));
		assertEquals(LCM2, Fracts.getLeastCommonMultiple(testDenominators2));
	}

	@Test
	public void test_getFractionsWithCommonBase() {
		long[][] testFractions = new long[][] { { 1, 2 }, { 1, 3 }, { 1, 4 } };
		long[][] expected = new long[][] { { 6, 12 }, { 4, 12 }, { 3, 12 } };
		assertArrayEquals(expected, Fracts.getFractionsWithCommonBase(testFractions, 12));
	}
}
