/*
Name: Nathan Burrell
Student #: V00198776
*/


public class Calc
{
	private static boolean hasProblem = false;

	public static void main (String[] args)
	{
		LLStack<Integer> stack = new LLStack<Integer>();

		if(args.length == 0)
		{
			System.out.println("Invalid Expression.");
			return;
		}

		for(int i=0; i < args.length; i++)
		{
			while (!hasProblem|| i<args.length)
			{
				int next;
				try
				{
					next = Integer.parseInt(args[i]);
					stack.push(next);
				}
				catch(NumberFormatException TableFlip){
						doMath(stack, args[i]);
				}
			}
		}
		displayResult(stack);


	}


	// Push the result of an operation onto the stack
	public static void doMath(LLStack<Integer> stack, String op)
	{
		try{
			Integer opTwo = stack.pop();
			Integer opOne = stack.pop();
			Integer result;

			if(op.equals("+"))
			{
				result = opOne + opTwo;
				stack.push(result);
			}

			if(op.equals("-"))
			{
				result = opOne - opTwo;
				stack.push(result);
			}

			if(op.equals("/"))
			{
				if(opTwo != 0)
				{
					result = (opOne/opTwo);
					stack.push(result);
				}else {
					System.out.println("Invalid Expression.");
					hasProblem = true;
					return;
				}
			}

			if(op.equals("x"))
			{
				result = opOne * opTwo;
				stack.push(result);
			}
			else{
				System.out.println("Invalid Expression.");
				hasProblem = true;
				return;
			}

		} catch(StackEmptyException e)
		{
			System.out.println("Invalid Expression.");
			hasProblem = true;
			return;
		}
	}

	public static void displayResult(LLStack stack)
	{
		Integer result=0;
		try
		{
			result = (Integer)stack.pop();
		}catch(StackEmptyException e){
			System.out.println("Invalid Expression.");
			return;
		}
		if (!stack.empty())
		{
			System.out.println("Invalid Expression.");
			return;
		}
		System.out.println(result);
	}
}