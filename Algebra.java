// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,-4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
		System.out.println(pow(-3,3));      // 3^5
   		System.out.println(div(25,7));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		while (x2 != 0) {
			if (x2 < 0) {
				x1--;
				x2++;
			} 
			else {
				x1++;
				x2--;
			}
		} 
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x1 == 0 && x2 < 0) {
				int x3 = 0;
				while (x2 < 0) {
					x3++;
					x2++;
				}
				return x3;
		} else {
			while (x2 != 0) {
				if (x2 < 0 && x1 > 0) {
					x1--;
					x2++;
				} else if (x2 < 0 && x1 < 0) {
					x1++;
					x2++;
				} else {
					x1--;
					x2--;
				}
			} 
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int x3 = x1;
		int opsitex1 = minus(0, x1);
		int opsitex2 = minus(0, x2);
		if (x1 == 0 || x2 == 0) {
			return 0;
		}
		if (x2 < 0 && x1 < 0)  {
			x3 = minus(0, x1);
			for (int i = 1; i < opsitex2; i++) {
				opsitex1 = plus(opsitex1,x3);
			}
			return opsitex1;
		} else if (x2<0 && x1>0) {
			for(int i=1;i<opsitex2;i++) {
				x1 = plus(x1, x3);
			}
			return minus(0, x1);
		} 
		else {
			for (int i = 1; i < x2; i++) {
				x1 = plus(x1, x3);
			}
		}
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int m = x;
		if (x == 0) {
			return 0;
		}
		if (n==1) {
			return x;
		}
		if (n == 0) {
			return 1;
		}
		if (x < 0) {
			int temp = x;
			for (int i = 1; i < n; i++) {
				x = times(x,temp);
			} 
			return x;
		} else {
			for (int i = 1; i < n; i++) {
				x = times(x, m);
			}
		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int counter = 0;
		boolean isNegetive = false;
		
		if (x1 == 0) {
			return 0;
		}

		if (x2 == 0) {
			return 0;
		} 

		if (x1 == x2) {
			return 1;
		}

		if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
			isNegetive = true;

			if (x1 < 0) {
				x1 = times(x1, -1);
			}

			if (x2 < 0) {
				x2 = times(x2, -1);
			}
		}

		if (x1 < 0 && x2 < 0) {
			if (x1 < 0) {
				x1 = times(x1, -1);
			}

			if (x2 < 0) {
				x2 = times(x2, -1);
			}
		}

		while (x1 >= x2) {
			x1 = minus(x1 , x2);
			counter++;
		}

		if (isNegetive) {
			return times(counter, -1);
		} else {
			return counter;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int x3 = div(x1, x2);
		int x4 = times(x2, x3);
		int mod = minus(x1, x4);
		return mod;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		for (int i = 1; i <= x; i++) {
			if (times(i, i) == 0) {
				return i;
			} else {
				if (times(plus(i, 1), plus(i, 1)) > x) {
					return i;
				}
			}
		} 
		
		return 0;
	}	  	  
}