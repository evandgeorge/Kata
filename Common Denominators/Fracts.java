import java.util.ArrayList;

public class Fracts {

	public static String convertFrac(long[][] lst) {

		long[][] reducedFractions = getReducedFractions(lst);
		long[] denominators = new long[reducedFractions.length];
		
		for(int i = 0; i < denominators.length; i++) {
			denominators[i] = reducedFractions[i][1];
		}
		
		long[][] fractionsWithCommonBase = getFractionsWithCommonBase(reducedFractions, getLeastCommonMultiple(denominators));
		
		String fractions = "";
		
		for(int i = 0; i < fractionsWithCommonBase.length; i++)
			fractions += "(" + fractionsWithCommonBase[i][0] + "," + fractionsWithCommonBase[i][1] + ")";
		
		return fractions;
	}

	public static long[][] getReducedFractions(long[][] fractions) {

		for (int i = 0; i < fractions.length; i++)
			fractions[i] = getReducedFraction(fractions[i][0], fractions[i][1]);

		return fractions;
	}

	public static long[] getReducedFraction(long numerator, long denominator) {
		ArrayList<Long> numeratorFactors = getFactors(numerator);
		ArrayList<Long> denominatorFactors = getFactors(denominator);

		ArrayList<Long> commonFactors = (ArrayList<Long>) numeratorFactors.clone();
		commonFactors.retainAll(denominatorFactors);

		Long GCF = commonFactors.get(commonFactors.size() - 1);

		return new long[] { numerator / GCF, denominator / GCF };
	}

	public static ArrayList<Long> getFactors(long num) {
		ArrayList<Long> factors = new ArrayList<Long>();

		for (long i = 1; i < num; i++)
			if (num % i == 0)
				factors.add(i);

		factors.add(num);

		return factors;
	}

	public static long getLeastCommonMultiple(long[] denominators) {

		long highestDenom = denominators[0];

		for (int i = 1; i < denominators.length; i++)
			highestDenom = Math.max(denominators[i], highestDenom);

		long multipleOfHighestDenom = highestDenom;

		while (true) {
			for (int i = 0; i < denominators.length; i++) {
				if (multipleOfHighestDenom % denominators[i] == 0) {
					if (i == denominators.length - 1)
						return multipleOfHighestDenom;
					continue;
				} else {
					break;
				}
			}

			multipleOfHighestDenom += highestDenom;
		}
	}

	public static long[][] getFractionsWithCommonBase(long[][] reducedFractions, long LCM) {

		long[][] commonBaseFractions = new long[reducedFractions.length][2];

		for (int i = 0; i < reducedFractions.length; i++) {
			long newNumerator = reducedFractions[i][0] * LCM / reducedFractions[i][1];

			commonBaseFractions[i] = new long[] { newNumerator, LCM };
		}

		return commonBaseFractions;
	}
}