package ca.ciccc.wmad202.assignment3.problem10;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem10 {
    private final static String EQUATION_FACTOR = "x";

    public void invoke() {
        System.out.println("5*x^4 and 5*x^4:");
        System.out.println(checkSingleFactorEquality("5*x^4", "5*x^4"));
        System.out.println(checkMultiFactorPolynomialsEquality("5*x^4", "5*x^4"));
        System.out.println("6*x^9 and 8*x^4:");
        System.out.println(checkSingleFactorEquality("6*x^9", "8*x^4"));
        System.out.println(checkMultiFactorPolynomialsEquality("6*x^9", "8*x^4"));
        System.out.println("6*x^45 and 5*x^4:");
        System.out.println(checkSingleFactorEquality("6*x^45", "5*x^4"));
        System.out.println(checkMultiFactorPolynomialsEquality("6*x^45", "5*x^4"));
    }

    public static boolean checkMultiFactorPolynomialsEquality(String multiPolynomialFactor1,String multiPolynomialFactor2) {
        ArrayList<Integer[]> PolynomialFactor1Array = convertSinglePolynomialFactorToArray(multiPolynomialFactor1);
        ArrayList<Integer[]> PolynomialFactor2Array = convertSinglePolynomialFactorToArray(multiPolynomialFactor2);

        if(PolynomialFactor1Array.size() != PolynomialFactor2Array.size()) {
            return false;
        } else {
            for(int i = 0; i < PolynomialFactor1Array.size(); i++) {
                Integer[] SingleFactor1 = PolynomialFactor1Array.get(i);
                Integer[] SingleFactor2 = PolynomialFactor2Array.get(i);

                if(SingleFactor1[0] != SingleFactor2[0] || SingleFactor1[1] != SingleFactor2[1]) {
                    break;
                }
                return false;
            }
        }

        return true;
    }

    public static ArrayList<Integer[]> convertSinglePolynomialFactorToArray(String polynomialFactor) {
        ArrayList<Integer[]> multiFactorPolynomial = new ArrayList<>();
        String singleFactor = "";
        for(int i = 0; i < polynomialFactor.length(); i++) {
            if(polynomialFactor.charAt(i) == '-' || polynomialFactor.charAt(i) == '+') {
                if(singleFactor.length() > 4) {
                    Integer[] singleFactorArray = convertSinglePolynomialFactorToAnArray(singleFactor);
                    multiFactorPolynomial.add(singleFactorArray);
                    singleFactor = "";
                } else {
                    singleFactor = singleFactor + polynomialFactor.charAt(i);
                }
            }
        }
        return multiFactorPolynomial;
    }

    public static boolean checkSingleFactorEquality(String singleFactor1, String singleFactor2) {
        Integer[] singleFactor1Array = convertSinglePolynomialFactorToAnArray(singleFactor1);
        Integer[] singleFactor2Array = convertSinglePolynomialFactorToAnArray(singleFactor2);

        if(((singleFactor1Array[0].equals(singleFactor2Array[0])) && (singleFactor2Array[1].equals(singleFactor1Array[1])))) {
            return true;
        }

        return false;
    }

    public static Integer[] convertSinglePolynomialFactorToAnArray(String singlePolynomialFactor) {
        final int DEFAULT_COEFFICIENT = 0;
        final int DEFAULT_EXPOENT = 0;

        Integer[] singlePolynomialFactorComponents = {DEFAULT_COEFFICIENT, DEFAULT_EXPOENT};
        int indexOfExponent = singlePolynomialFactor.indexOf('^');
        int indexOfMultiplication = singlePolynomialFactor.indexOf('*');

        String coefficientString = singlePolynomialFactor.substring(0, indexOfMultiplication);
        String exponentString = singlePolynomialFactor.substring(indexOfExponent + 1, singlePolynomialFactor.length());

        Integer coefficient = Integer.valueOf(coefficientString);
        Integer exponent = Integer.valueOf(exponentString);

        singlePolynomialFactorComponents[0] = coefficient;
        singlePolynomialFactorComponents[1] = exponent;

        return singlePolynomialFactorComponents;
    }

}
