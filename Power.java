import java.util.*;
public class Power
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a base:");
		int base = Integer.parseInt(input.next());
		System.out.println("Enter an exponent:");
		int exp = Integer.parseInt(input.next());
		System.out.println(power(base,exp));
	}

	public static int power (int base, int pow)
	{
		if (pow == 1)
			return base;
		else if((pow%2) == 1)
			return power(base, ((pow-1)/2)) * power(base, ((pow+1)/2));
		else
		{
			int temp = power(base, pow/2);
			return temp * temp;
		}
	}
}