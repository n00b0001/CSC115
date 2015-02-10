// NOTE: This program will not compile until method stubs or methods are added!


// NAME: a3Tester
// PURPOSE:  Solve Mathematical functions, like x^n and e^x iteratively and then recursively
//     and then more efficiently using recursion.
// AUTHOR:  LillAnne Jackson
// DATE: January 2014
// CREDITS: The ideas for the problems: from the Carrano and Prichard textbook


import java.util.*;
import java.io.*;

public class a3Tester {

	// Compute x^n iteratively
	static double powerOne(double x, long n)
	{
		double retVal = 1.0;
		for (long i=n; i>0; i--)
			retVal *= x;

		return retVal;
	}

	// Compute x^n recursively (base recursion)
	static double powerTwo(double x, long n)
	{
		if (n==0 || x==1.0)
			return 1.0;
		return x * powerTwo(x, n-1);
	}

	// Compute x^n recursively by dividing the exponent by two
	static double powerThree(double x, long n)
	{
		double temp;
		if (n==0 || x==1.0)
			return 1.0;
		else if((n%2) == 1)
		{
			temp = powerThree(x, n/2);
			return x * temp * temp;
		}
		else
		{
			temp = powerThree(x, n/2);
			return temp * temp;
		}
	}

	// Compute x! iteratively
	static double factOne(double x)
	{
		if (x==0.0)
			return 1.0;
		double result = 1.0;
		for(double fact = x; fact>0; fact--)
			result *= fact;
		return result;
	}

	// Compute x! recursively
	static double factTwo(double x)
	{
		if (x==0)
			return 1.0;
		else
			return x * factTwo (x-1);
	}

	// Compute e^x iteratively
	static double eOne(double x, long n)
	{
		double result = 0.0;
		for (int i=0; i<=n; i++)
			result += powerThree(x,(long)i) / factTwo((double)i);
		return result;
	}

	// Compute e^x recursively
	static double eTwo(double x, long n)
	{
		if (n==0)
			return 1;
		return (powerThree(x,n) / factTwo((double)n)) + eTwo(x,n-1);
	}

	// COmpute e^x recursively by factoring the MacLaurin Series
	static double eThree(double x, long n)
	{
		return eThreeCalc(x,n,1);
	}

	// Now actually do the calculation!
	private static double eThreeCalc(double x, long n, long m)
	{
		if (m-1==n)
			return 1;
		return 1 + (x/m)*eThreeCalc(x,n,m+1);
	}

	public static boolean test(double result, Scanner testData) {
			return (Math.abs(result - testData.nextDouble()) < 0.00000000001);
	}

	public static void main (String [] args) throws FileNotFoundException{

		// File input
		Scanner in = new Scanner(new File("TestData.txt"));
		Scanner testIn = new Scanner(new File("TestResult.txt"));

		System.out.println(" M A T H   T E S T E R \n\n" );
		System.out.println(" Methods Written by: Nathan Burrell");
		System.out.println("   ID:  V00198776 \tFebruary 2014");

		// First line of file is number of data points:
		int numPoints = in.nextInt();

	    for (int i=0; i < numPoints; i++ ) {

			//skip title line in file
			in.next();

			// Data for testing x^n methods
			double base = in.nextDouble();
			int exponent = in.nextInt();

			// x^n test calls
			System.out.println(" *********************************");
			System.out.println(" Iterative x^n with x= " + base + " and n= " + exponent + ": ");
			double data = powerOne(base, exponent);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			System.out.println(" *********************************");
			System.out.println(" Recursive x^n (#1) with x= " + base + " and n= " + exponent + ": ");
			data = powerTwo(base, exponent);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			System.out.println(" *********************************");
			System.out.println(" Recursive x^n (#2) with x= " + base + " and n= " + exponent + ": ");
			data = powerThree(base, exponent);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			// Data for testing n! methods
			//skip title line in file
			in.next();
			int n = in.nextInt();

			// x^n test calls

			System.out.println(" *********************************");
			System.out.println(" Iterative n! with n= " + n +  ": ");
			data = factOne((double)n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			System.out.println(" *********************************");
			System.out.println(" Recursive n! with n= " + n + ": ");
			data = factTwo((double)n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			// Data for testing e^x methods
			//skip title line in file
			in.next();
			double x = in.nextDouble();
			n = in.nextInt();

			// x^n test calls

			System.out.println(" *********************************");
			System.out.println(" Iterative e^x with x= " + x + "("+ n + " terms): ");
			data = eOne(x, n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			System.out.println(" *********************************");
			System.out.println(" Recursive e^x (#1) with x= " + x + "("+ n + " terms): ");
			data = eTwo(x, n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			System.out.println(" *********************************");
			System.out.println(" Recursive e^x (#2) with x= " + x + "("+ n + " terms): ");
			data = eThree(x, n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			//in.nextLine();
		}
	}


}


