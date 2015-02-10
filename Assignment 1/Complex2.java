// NAME: COMPLEX
// PURPOSE:  create and manipulate Complex Number objects
// AUTHOR:  Nathan Burrell, V00198776
// DATE: Jan 14, 2014
// CREDITS: Lillanne Jackson

/*
The difference between static and non-static:
A static field is the same across all instances of a class.
*/
public class Complex2 {
	private int real;
	private int imaginary;

	// Default Constructor
	public Complex2 () {
		this.real = 0;
		this.imaginary = 0;
	}

	// Constructor for complex numbers where:
	//	- r is the real part
	//	- i is the imaginary part
	public Complex2 (int r, int i) {
		this.real = r;
		this.imaginary = i;
	}

	// Constructor for real numbers (no imaginary part)
	public Complex2 (int r) {
		this.real = r;
		this.imaginary = 0;
	}

	// Accesses the real part
	public int getReal() {
		return this.real;
	}
	// Mutates the real part
	public void setReal(int real) {
		this.real = real;
	}

	// Accesses the imaginary part
	public int getImaginary() {
		return this.imaginary;
	}

	// Mutates the imaginary part
	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}

	// Adds two complex numbers
	// Input: a complex number to add on
	// Returns sum
	public Complex2 add(Complex2 other) {
		int r = this.real + other.getReal();
		int i = this.imaginary + other.getImaginary();
		Complex2 result = new Complex2(r,i);
		return result;
	}

	// Subtracts two complex numbers
	// Input: a complex number to subtract
	// Returns difference
	public Complex2 subtract(Complex2 other) {
		int r = this.real - other.getReal();
		int i = this.imaginary - other.getImaginary();
		Complex2 result = new Complex2(r,i);
		return result;
	}

	// Multiplies two complex numbers
	// Input: a complex number to multiply by
	// Returns product
	public Complex2 multiply(Complex2 other) {
		int r = (this.real * other.getReal()) - (this.imaginary * other.getImaginary());
		int i = (this.real * other.getImaginary()) + (this.imaginary * other.getReal());
		Complex2 result = new Complex2(r,i);
		return result;
	}

	// Divides two complex numbers
	// Input: a complex number to divide by
	// Returns quotient
	public Complex2 divide(Complex2 other) {
		// Perform substitutions
		int a = this.real;
		int b = this.imaginary;
		int c = other.getReal();
		int d = other.getImaginary();
		// Perform arithmetic based on formula
		int r = ((a*c + b*d) / (c*c + d*d));
		int i = ((b*c - a*d) / (c*c + d*d));
		Complex2 result = new Complex2(r,i);
		return result;
	}

	// Print method
	public String toString() {
		String result = "";
		if (this.imaginary <0)
			result += real + " - " + -1*imaginary + "i";
		else if (this.imaginary == 0)
			result += real;
		else
			result += real + " + " + imaginary + "i";
		return result;
	}

	public static void main(String [] args) {

		System.out.println("Complex Number Tester Output:");

		// Test the new constructor for Real (only) numbers
		Complex2 aReal = new Complex2(423);
		System.out.print("Real Constructor Test: Should Output 423 : ");
		System.out.println(aReal.toString());

		// Instantiate some more complex numbers
		Complex2 oneValue = new Complex2(-3,4);
		Complex2 anotherValue = new Complex2(2,-1);

		// Test add:  oneValue + anotherValue
		System.out.print("Add Tester: Should Output -1 + 3i : ");
		System.out.println(oneValue.add(anotherValue));

		// Test subtract:  oneValue - anotherValue
		System.out.print("Subtract Tester: Should Output -5 + 5i : ");
		System.out.println(oneValue.subtract(anotherValue));

		// Test multiply:  oneValue * anotherValue
		System.out.print("Multiply Tester: Should Output -2 + 11i : ");
		System.out.println(oneValue.multiply(anotherValue));

		// Test divide:  oneValue / anotherValue
		System.out.print("Divide Tester: Should Output -2 + 1i : ");
		System.out.println(oneValue.divide(anotherValue));

	}
}
