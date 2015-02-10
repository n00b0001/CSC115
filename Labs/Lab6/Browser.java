/**
  A very simple interactive text browser to simulate the "<-" and "->" buttons of the web browser Firefox. When a user enters a URL, it is pushed onto the back stack. If the user chooses "<", the URL visited previously is shown on screen while the current URL is pushed onto the forward stack.
*/
import java.util.Scanner;
public class Browser
{
	/**
	  provide a text menu to users. The menu options are:
	  n - go to a new website
	  < - backward: go to the previous website (Don't show it if the bstack is empty)
	  > - forward: go to the next website (Don't show it if the fstack is empty)
	  q - quit the program
	*/
	private static void menu(LabStack<String> bStack,LabStack<String> fStack)
	{
		System.out.println("********************************************");
		System.out.print("Press one of: n, q");
		if(!bStack.empty())
			System.out.print(", <");
		if(!fStack.empty())
			System.out.print(", >");
		System.out.println("");
		if(!bStack.empty())
			System.out.println("< -Back: Go to the previous webpage");
		if(!fStack.empty())
			System.out.println("> -Forward: Go to the next webpage");
		System.out.println("n -New Page: visit a new website");
		System.out.println("q -Quit: Leave the program");
		System.out.println("********************************************");


	}

	/**
	  Get a line from the Scanner object and return the String object
	*/
	private static String getURL(Scanner input)
	{
		System.out.print("Enter a URL:\t");
		return input.nextLine().trim();
	}

	/**
	  if bStack is not empty, push URL to fStack and pop a string from bStack, return the string
	  else print a message to screen and return null
	*/
	private static String backward(LabStack<String> bStack,LabStack<String> fStack,String URL)
	{
		if(!bStack.empty())
		{
			if(URL != null)
				fStack.push(URL);
			return bStack.pop();
		}
		if(bStack.empty() && URL != null)
			fStack.push(URL);
		return null;
	}

	/**
	  if fStack is not empty, push URL to bStack and pop a string from fStack, return the string
	  else print a message to screen and return null
	*/
	private static String forward(LabStack<String> bStack,LabStack<String> fStack,String URL)
	{
		if(!fStack.empty())
		{
			if(URL != null)
				bStack.push(URL);
			return fStack.pop();
		}
		if(fStack.empty() && URL != null)
			bStack.push(URL);
		return null;
	}

	//an interactive program to simulate the "<-" button of the Firefox browser.
	public static void main(String[] args)
	{
		LabStack<String> back = new LabStack<String>();
		LabStack<String> forward = new LabStack<String>();
		String current = null;
		char choice = 'a';
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the Simple Text Browser!");
		while(choice != 'q')
		{
			menu(back, forward);

			System.out.print("Make your selection: ");
			choice = keyboard.nextLine().trim().charAt(0);

			// Handle cases
			switch(choice)
			{
				case 'n':
					forward.makeEmpty();
					if(current != null)
						back.push(current);
					current = getURL(keyboard);
					System.out.println("Current URL: " + current);
					System.out.println("Back: " + back);
					System.out.println("Forward: " + forward);
					System.out.println("\n\n");
					break;

				case 'q':
					break;

				case '>':
					if(!forward.empty())
						current = forward(back, forward, current);
					System.out.println("Current URL: " + current);
					System.out.println("Back: " + back);
					System.out.println("Forward: " + forward);
					System.out.println("\n\n");

				case '<':
					if(!back.empty())
						current = backward(back, forward, current);
					System.out.println("Current URL: " + current);
					System.out.println("Back: " + back);
					System.out.println("Forward: " + forward);
					System.out.println("\n\n");
			}
		}
		System.out.println("Thank You, Come Again!");

	}
}