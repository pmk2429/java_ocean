package operators;

/**
 * 
 * Java defines several bitwise operators, which can be applied to the integer
 * types, long, int, short, char, and byte.
 * 
 * Bitwise operator works on bits and performs bit-by-bit operation. 
 * Assume if, 
 * a = 60; and b = 13; now in binary format they will be as follows:
 * 
 * a = 0011 1100
 * 
 * b = 0000 1101
 * 
 * -----------------
 * 
 * a&b = 0000 1100
 * 
 * a|b = 0011 1101
 * 
 * a^b = 0011 0001
 * 
 * ~a = 1100 0011
 * 
 * The following table lists the bitwise operators:
 * 
 	Assume integer variable A holds 60 and variable B holds 13 then:
 
	&	Binary AND Operator copies a bit to the result if it exists in both operands.	
	(A & B) will give 12 which is 0000 1100

	|	Binary OR Operator copies a bit if it exists in either operand.	
	(A | B) will give 61 which is 0011 1101

	^	Binary XOR Operator copies the bit if it is set in one operand but not both.	
	(A ^ B) will give 49 which is 0011 0001

	~	Binary Ones Complement Operator is unary and has the effect of 'flipping' bits.	
	(~A ) will give -61 which is 1100 0011 in 2's complement form due to a signed binary number.

	<<	Binary Left Shift Operator. The left operands value is moved left by the number of bits specified by the right operand.	
	A << 2 will give 240 which is 1111 0000

	>>	Binary Right Shift Operator. The left operands value is moved right by the number of bits specified by the right operand.	
	A >> 2 will give 15 which is 1111

	>>>	Shift right zero fill operator. The left operands value is moved right by the number of bits specified by the right operand and shifted values are filled up with zeros.	
	A >>>2 will give 15 which is 0000 1111

 * @author Pavitra
 * 
 */

public class BitwiseDemo {
	public static void main(String[] args) {

		int a = 60; /* 60 = 0011 1100 */
		int b = 13; /* 13 = 0000 1101 */
		int c = 0;
		System.out.println("a = " + a + ", b = " + b + "\n");
		c = a & b; /* 12 = 0000 1100 */
		System.out.println("a & b = " + c);

		c = a | b; /* 61 = 0011 1101 */
		System.out.println("a | b = " + c);

		c = a ^ b; /* 49 = 0011 0001 */
		System.out.println("a ^ b = " + c);

		c = ~a; /*-61 = 1100 0011 */
		System.out.println("~a = " + c);

		c = a << 2; /* 240 = 1111 0000; this will move a=60 LEFT shift by 2 bits */
		System.out.println("a << 2 = " + c);

		c = a >> 2; /* 215 = 1111; this will move a=60 RIGHT shift by 2 bits */
		System.out.println("a >> 2  = " + c);

		c = a >>> 2; /* 215 = 0000 1111 */
		System.out.println("a >>> 2 = " + c);
	}
}
