/*
Name: ComplexExerciser1
Purpose: to create complex numbers from a file and print
Author: Nathan Burrell V00198776
Edit Date: Jan 14 2014
Credits: All content is original work
*/

import java.io.*;
import java.util.*;

public class ComplexExerciser1
{

	public static void main (String[] args) throws FileNotFoundException
	{
		Complex1 theFirst = new Complex1(2,4);
		Complex1 theSecond = new Complex1(4,-5);
		System.out.println("First complex number:"+theFirst);
		System.out.println("Second complex number:"+theSecond);
		File inFile = new File("ComplexData.txt");
		Scanner scan = new Scanner (inFile);
		int size = Integer.parseInt(scan.next());

		Complex1[] anArray = new Complex1[size];
		for (int i=0; i<size; i++)
			anArray[i] = new Complex1(scan.nextInt(), scan.nextInt());

		System.out.println("From File:");
		for (int j=0; j<size; j++)
			System.out.println(anArray[j]);
	}
}