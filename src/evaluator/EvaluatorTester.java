package evaluator;

import java.util.*;


public class EvaluatorTester {

	public static void main(String[] args) 
	{ 
		Evaluator anEvaluator = new Evaluator();
		
		Scanner scanner;
		scanner = new Scanner(System.in);	
		
		System.out.println("Enter expression:");
		while(true)
		{
		String inputExpr = scanner.nextLine(); 
		
		if(inputExpr.equals("exit"))
		{
			break;
		}
		System.out.println(inputExpr + "=" + anEvaluator.eval(inputExpr));
		}	
	}
	
}
