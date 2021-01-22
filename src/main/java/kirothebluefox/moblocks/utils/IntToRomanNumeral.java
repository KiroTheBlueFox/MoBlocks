package kirothebluefox.moblocks.utils;

public class IntToRomanNumeral { 
	private static int sub_digit(char num1, char num2, int i, char[] c) { 
		c[i++] = num1; 
		c[i++] = num2; 
		return i; 
	} 

	private static int digit(char ch, int n, int i, char[] c) { 
		for (int j = 0; j < n; j++) { 
			c[i++] = ch; 
		} 
		return i; 
	} 

	public static String getRomanFromNumber(int number) { 
		char c[] = new char[10001]; 
		int i = 0; 
		String numberString = "";

		if (number <= 0) { 
			return "INVALID NUMBER"; 
		} 

		while (number != 0) { 
			if (number >= 1000) { 
				i = digit('M', number / 1000, i, c); 
				number = number % 1000; 
			}
			else if (number >= 500) { 
				if (number < 900) { 
					i = digit('D', number / 500, i, c); 
					number = number % 500; 
				}
				else { 
					i = sub_digit('C', 'M', i, c); 
					number = number % 100; 
				} 
			}
			else if (number >= 100) { 
				if (number < 400) { 
					i = digit('C', number / 100, i, c); 
					number = number % 100; 
				}
				else { 
					i = sub_digit('C', 'D', i, c); 
					number = number % 100; 
				} 
			}
			else if (number >= 50) { 
				if (number < 90) { 
					i = digit('L', number / 50, i, c); 
					number = number % 50; 
				}
				else { 
					i = sub_digit('X', 'C', i, c); 
					number = number % 10; 
				} 
			}
			else if (number >= 10) { 
				if (number < 40) { 
					i = digit('X', number / 10, i, c); 
					number = number % 10; 
				}
				else { 
					i = sub_digit('X', 'L', i, c); 
					number = number % 10; 
				} 
			}
			else if (number >= 5) { 
				if (number < 9) { 
					i = digit('V', number / 5, i, c); 
					number = number % 5; 
				}
				else { 
					i = sub_digit('I', 'X', i, c); 
					number = 0; 
				} 
			}
			else if (number >= 1) { 
				if (number < 4) { 
					i = digit('I', number, i, c); 
					number = 0; 
				}
				else { 
					i = sub_digit('I', 'V', i, c); 
					number = 0; 
				} 
			} 
		} 

		for (int j = 0; j < i; j++) { 
			numberString += c[j]; 
		}
		
		return numberString;
	}
} 
//This code is contributed by PrinciRaj1992

