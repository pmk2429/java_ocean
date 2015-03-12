package evaluator;

import java.util.*;

public class Evaluator {
	private Stack<Operand> opdStack;
	private Stack<Operator> oprStack;

	public Evaluator() // initialize stack
	{
		opdStack = new Stack<Operand>();
		oprStack = new Stack<Operator>();
	}

	public int eval(String expr) {
		String tok; // variable to hold tokens
		String delimiters = new String("+-*/#!() "); // delimiter for scanner

		Operator buff = new Hash(); // run through abstract method once to
									// initialize hashmap

		// put in values for hashmap; put here instead of abstract class to
		// prevent stack overflow
		Operator.operators.put("+", new Addition());
		Operator.operators.put("-", new Subtraction());
		Operator.operators.put("*", new Multiply());
		Operator.operators.put("/", new Divis());
		Operator.operators.put("#", new Hash());
		Operator.operators.put("!", new Bang());
		Operator.operators.put("(", new leftpar());
		Operator.operators.put(")", new rightpar());

		// # marks the beginning of operation
		Operator start = (Operator) Operator.operators.get("#");

		oprStack.push(start); // put in the operator stack

		// scan input
		StringTokenizer st = new StringTokenizer(expr, delimiters, true);

		while (st.hasMoreTokens()) // while there are things getting scanned
		{

			// if not whitespace, check if operand or operator
			if (!(tok = st.nextToken()).equals(" ")) {
				if (Operand.check(tok)) // if operand, put in stack
				{
					opdStack.push(new Operand(tok));
				} else {
					if (!Operator.check(tok)) // if not operand and operator,
												// input invalid
					{
						System.out.println("*******INVALID TOKEN*********");
						System.exit(1);

					}

					Operator newOpr = (Operator) Operator.operators.get(tok); // if
																				// operator
																				// check
																				// doesn't
																				// fail
																				// push
																				// in
																				// operator
																				// stack

					if (newOpr.priority() == 4) // if operator is a "(" run same
												// process but with "(" and ")"
												// as beginning/end
					{ // instead of "#" and "!"
						oprStack.push(newOpr);
						while (oprStack.peek().priority() != 5) {
							if (!(tok = st.nextToken()).equals(" ")) // check
																		// and
																		// push
																		// in
																		// operand
																		// or
																		// operator
																		// stack
							{
								if (Operand.check(tok)) {

									opdStack.push(new Operand(tok));
								} else {
									if (!Operator.check(tok)) {
										System.out.println("****INVALID TOKEN******");
										System.exit(1);
									}
									Operator parOp = (Operator) Operator.operators.get(tok);

									// if priority is higher in stack than newly
									// read operator, do stack operator first
									while (oprStack.peek().priority() >= parOp.priority()
											&& oprStack.peek().priority() < 4) {
										Operator oldOpr = oprStack.pop();
										Operand op2 = opdStack.pop();
										Operand op1 = opdStack.pop();

										opdStack.push(oldOpr.execute(op1, op2));
									}
									oprStack.push(parOp);
								}

							}

						}

						if (oprStack.peek().priority() == 5) // if the end is
																// ")" run the
																// process
						{
							oprStack.pop(); // remove the ")"

							while (oprStack.peek().priority() != 4) // pop
																	// operators
																	// and do
																	// the
																	// operation
																	// until "("
							{
								Operator cur = oprStack.pop();
								Operand op2 = opdStack.pop();
								Operand op1 = opdStack.pop();
								opdStack.push(cur.execute(op1, op2));

							}
							oprStack.pop(); // remove "(" from the stack

						}

					}

					else { // if the "(" is not detected, run as normal

						while (oprStack.peek().priority() >= newOpr.priority()) // if
																				// the
																				// operator
																				// in
																				// stack
																				// is
																				// higher
																				// priority
																				// do
																				// operation
																				// before
						{ // pushing new operator into stack
							Operator oldOpr = oprStack.pop();
							Operand op2 = opdStack.pop();
							Operand op1 = opdStack.pop();
							opdStack.push(oldOpr.execute(op1, op2));

						}
						oprStack.push(newOpr);
					}

				}

			}

		}

		Operator end = (Operator) Operator.operators.get("!"); // end of the
																// input, put in
																// bang
		oprStack.push(end);

		if (oprStack.peek().priority() == 0) // if "!" is at the end, then run
		{
			oprStack.pop(); // get rid of "!"
			while (oprStack.peek().priority() != 1) // run operators until "#"
													// is reached
			{
				Operator cur = oprStack.pop();
				Operand op2 = opdStack.pop();
				Operand op1 = opdStack.pop();
				opdStack.push(cur.execute(op1, op2));
			}
		}
		return opdStack.peek().getval(); // return final value
	}

}

/*********************************************************************
 * here lies OPERAND CLASS
 *
 ***********************/

class Operand {
	private int opernd; // value to to hold int value

	public Operand(String x) // constructor method to create operand with string
								// input
	{
		opernd = Integer.valueOf(x);

	}

	public Operand(int x) // constructor method to create operand with int input
	{
		opernd = x;
	}

	public int getval() // return value
	{
		return opernd;
	}

	public static boolean check(String x) // check if the value is an integer
	{
		try {
			Integer.parseInt(x);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}

	}

}

/*********************************************************************
 * here lies OPERATOR CLASS and Operators
 *
 ***********************/
abstract class Operator // abstract class for all operator subclasses
{

	public static HashMap<String, Object> operators = new HashMap<String, Object>(); // initialize
																						// hashmap

	public abstract Operand execute(Operand x, Operand y); // execute abstract
															// method

	public abstract int priority(); // operation priority abstract method

	public static boolean check(String x) // check if string value is an
											// accepted operator
	{
		if (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("!") || x.equals("#")
				|| x.equals("(") || x.equals(")")) {

			return true;

		} else {
			return false;
		}
	}

}

class Addition extends Operator {
	public Operand execute(Operand x, Operand y) // run addition operation
	{
		Operand z = new Operand(x.getval() + y.getval());
		return z;
	}

	public int priority() // return addition priority value (2)
	{
		return 2;
	}
}

class Subtraction extends Operator {
	public Operand execute(Operand x, Operand y) // run substraction operation
	{
		Operand z = new Operand(x.getval() - y.getval());
		return z;
	}

	public int priority() // return subtraction priority value (2)
	{
		return 2;
	}

}

class Multiply extends Operator {
	public Operand execute(Operand x, Operand y) // run multiplication operation
	{
		Operand z = new Operand(x.getval() * y.getval());
		return z;
	}

	public int priority() // return multiplication priority value (3)
	{

		return 3;
	}
}

class Divis extends Operator {

	public Operand execute(Operand x, Operand y) // run division operation
	{
		Operand z = new Operand(x.getval() / y.getval());
		return z;
	}

	public int priority() // return division priority value (3)
	{

		return 3;
	}
}

class Hash extends Operator {
	public Hash() // constructor
	{

	}

	public Operand execute(Operand x, Operand y) // not suppose to have
													// execution return 0
	{
		System.out.println("This is not suppose to be read");
		Operand z = new Operand(0);
		return z;
	}

	public int priority() // return priority of "#" 1
	{

		return 1;
	}
}

class Bang extends Operator {
	public Operand execute(Operand x, Operand y) // not suppose to have
													// execution, return 0
	{
		System.out.println("This is not suppose to be read");
		Operand z = new Operand(0);
		return z;
	}

	public int priority() // return priority of "!" 0
	{
		return 0;
	}
}

class leftpar extends Operator {
	public Operand execute(Operand x, Operand y) // not suppose to have
													// execution return 0
	{
		System.out.println("This is not suppose to be read");
		Operand z = new Operand(0);
		return z;
	}

	public int priority() // return value of "("
	{
		return 4;
	}
}

class rightpar extends Operator {
	public Operand execute(Operand x, Operand y) // not suppose to have
													// execution return 0
	{
		System.out.println("This is not suppose to be read");
		Operand z = new Operand(0);
		return z;
	}

	public int priority() // return value of ")"
	{
		return 5;
	}
}