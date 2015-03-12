package operators;

/**
 * 
 * Assignment Operator Description	Example
 * 
=	Simple assignment operator, Assigns values from right side operands to left side operand	
C = A + B will assign value of A + B into C

+=	Add AND assignment operator, It adds right operand to the left operand and assign the result to left operand	
C += A is equivalent to C = C + A

-=	Subtract AND assignment operator, It subtracts right operand from the left operand and assign the result to left operand	
C -= A is equivalent to C = C - A

*=	Multiply AND assignment operator, It multiplies right operand with the left operand and assign the result to left operand	
C *= A is equivalent to C = C * A

/=	Divide AND assignment operator, It divides left operand with the right operand and assign the result to left operand	
C /= A is equivalent to C = C / A
  
%=	Modulus AND assignment operator, It takes modulus using two operands and assign the result to left operand	
C %= A is equivalent to C = C % A

<<=	Left shift AND assignment operator	
C <<= 2 is same as C = C << 2

>>=	Right shift AND assignment operator	
C >>= 2 is same as C = C >> 2

&=	Bitwise AND assignment operator	
C &= 2 is same as C = C & 2

^=	bitwise exclusive OR and assignment operator	
C ^= 2 is same as C = C ^ 2

|=	bitwise inclusive OR and assignment operator	
C |= 2 is same as C = C | 2

 * @author Pavitra
 *
 */

public class AssignmentOperatorsDemo {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 0;
		System.out.println("a = " + a + ", b = " + b + ", c = " + c + "\n");
		c = a + b;
		System.out.println("c = a + b = " + c);

		c += a;
		System.out.println("c += a  = " + c);

		c -= a;
		System.out.println("c -= a = " + c);

		c *= a;
		System.out.println("c *= a = " + c);

		a = 10;
		c = 15;
		c /= a;
		System.out.println("c /= a = " + c);

		a = 10;
		c = 15;
		c %= a;
		System.out.println("c %= a  = " + c);

		c <<= 2;
		System.out.println("c <<= 2 = " + c);

		c >>= 2;
		System.out.println("c >>= 2 = " + c);

		c >>= 2;
		System.out.println("c >>= a = " + c);

		c &= a;
		System.out.println("c &= 2  = " + c);

		c ^= a;
		System.out.println("c ^= a   = " + c);

		c |= a;
		System.out.println("c |= a   = " + c);
	}
}
