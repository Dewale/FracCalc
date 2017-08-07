import java.util.*;

public class FractionCalculator{
	public static void main(String[] args){
		System.out.println("This program is a fraction calculator");
		System.out.print("It will add, subtract, multiply and div");
		System.out.println("ide fractions until you type Q to quit.");
		System.out.print("Please enter your fractions in the form a/b, ");
		System.out.println("where a and b are integers.");
		System.out.print("-------------------------------------------");
		System.out.println("-------------------------------------");
		
		Scanner input = new Scanner(System.in);
		String operand = " ";
		Fraction a = new Fraction();
		Fraction b = new Fraction();

		while(!operand.equals("q")){
			operand = getOperation(input);
			a = getFraction(input);
			b = getFraction(input);
			System.out.println(a.toString()+" "+operand+" "+b.toString()+" "+ run(a,b,operand));
		}
	}
	public static String getOperation(Scanner input){
		System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
		String s = input.next();
		
		if((s.equals("+"))||(s.equals("-"))||(s.equals("/"))||(s.equals("*"))||(s.equals("="))){
			return s;
		}else if( s.equals("q") || s.equals("Q")){
			input.close();
			System.exit(0);
			return "Quit";
		}else{
			return getOperation(input);
		}
	}
	public static boolean validFraction(String input){
		String[] tokens = input.split("/");
		if(tokens.length > 2){
			return false;
		} else {
            for (int i =0; i < tokens.length; i++) {
                try {
                    Integer.parseInt(tokens[i]);
                } catch(Exception e) {
                    return false;
                }
            }
            return true;
        }
	}
	public static Fraction getFraction(Scanner input){
		System.out.print("Please enter a fraction (a/b) or integer(a): ");
		String s = input.next();

		if(validFraction(s)){
			String[] tokens = s.split("/");
			if(tokens.length > 1){
				return new Fraction(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
			}else{
				return new Fraction(Integer.parseInt(tokens[0]));
			}
		}else{
			return getFraction(input);
		}
	}
	public static String run(Fraction a,Fraction b, String operator){
		Fraction res = new Fraction();
		if(operator.equals("+")){
			res = a.add(b);
		}else if(operator.equals("-")){
			res = a.subtract(b);
		}else if(operator.equals("*")){
			res = a.multiply(b);
		}else if(operator.equals("/")){
			res = a.divide(b);
		}else if(operator.equals("=")){
			boolean equal = a.equals(b);
			return "is " + Boolean.toString(equal);
		}
		return "= " + res.toString();
	}
}