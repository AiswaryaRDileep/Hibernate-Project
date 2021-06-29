import java.util.Scanner;

public class calc {

	public static void main(String[] args) {
		Double num1 , num2 , result;
		char operator , exit;
		int flag = 0;
		
		Scanner input = null;
		try {
			input = new Scanner(System.in);
			 do {
				System.out.println("Enter first number :");
				num1 = input.nextDouble();
				
				System.out.println("Enter second number :");
				num2 = input.nextDouble();
				
				System.out.println("Select Operator : + , - , * , /");
				operator = input.next().charAt(0);
				
				switch(operator) {
					case '+':
						result = num1 + num2;
						System.out.println(num1 + "+" + num2 + "=" + result);
						break;
					case '-':
						result = num1 - num2;
						System.out.println(num1 + "-" + num2 + "=" + result);
						break;
					case '*':
						result = num1 * num2;
						System.out.println(num1 + "*" + num2 + "=" + result);
						break;
					case '/':
						result = num1 / num2;
						System.out.println(num1 + "/" + num2 + "=" + result);
						break;
					default:
						System.out.println("Invalid Operator");
						break;
				}
				System.out.println("Exit(y/n)");
				exit = input.next().charAt(0);
				if(exit=='y') {
					flag = 1;
				}
			}while(flag==0);
		
		} catch (Exception e) {
			System.out.println(e);
				input.close();
			}
			
		}
		

	}


