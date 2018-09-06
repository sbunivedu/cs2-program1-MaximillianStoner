//Max Stoner 9/6/2018
//Program 1 CIS II Fall 2018
//Professor: Dr. Lu


import java.util.Scanner;

public class OPStackTester
{
public static void main(String[] args)
{
	//init variables
	CharStack opstack = new CharStack();
	Scanner scan = new Scanner(System.in);
	String expression = "";
	char current;

	//receive input
	System.out.println("Please input your infix expression: ");
	expression = scan.next();
	System.out.print("Postfix Conversion: ");

	//compute
	for (int x = 0; x < expression.length(); x++)
		{
			//set pointer
			current = expression.charAt(x);

			//pointer is operand
			if(CharStack.isOperand(current))
				{
					System.out.print(current);
				}//if

			//pointer is operator
			/*else if(CharStack.isOperator(current))
				{
					if(!opstack.isEmpty())
					{
						char top = opstack.peek();

						while(CharStack.precedenceOrder(top) >= CharStack.precedenceOrder(current))
							{
								if(opstack.peek()!='(')
									{
										System.out.print(opstack.pop());
										top = opstack.peek();
									}
								else
									{
										opstack.push(current);
									}
							}//while
						opstack.push(current);
					}//if
				}//else if*/


			//pointer is operator
			else if(CharStack.isOperator(current))
				{

					if(!opstack.isEmpty())
						{
							char top = opstack.peek();

							while(CharStack.precedenceOrder(top)>= CharStack.precedenceOrder(current) && top != '(' && !opstack.isEmpty())
								{
									top = opstack.peek();
									System.out.print(opstack.pop());
								}//while
						}//if
							opstack.push(current);
				}//else if


			//pointer is left parenthesis
			else if(current == '(')
				{
					opstack.push(current);
				}//else if

			//pointer is right parenthesis
			else if(current == ')')
				{
					while(!opstack.isEmpty())//while
						{
							if(opstack.peek() == '(')
								{
									opstack.rm();
								}//if
							else
								{
									System.out.print(opstack.pop());
								}//else
						}//while
				}//else if

		}//for

	while(!opstack.isEmpty())
		{
				{
					if(opstack.peek() != '(');
						System.out.print(opstack.pop());
				}
		}

System.out.println("");

}//main
}//class