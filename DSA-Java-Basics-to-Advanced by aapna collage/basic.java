class main{
public static void main(String args[]) {
	int numOne = 10;
	int numTwo = 5;
	boolean isTrue = true;
	System.out.println(numOne++ + " " + ++numOne); //Output will be 10 12
	System.out.println(numTwo-- + " " + --numTwo); //Output will be 5 3
	System.out.println(!isTrue + " " + ~numOne); //Output will be false -13
}
}
