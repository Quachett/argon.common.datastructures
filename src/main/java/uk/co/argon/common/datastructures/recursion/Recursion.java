 package uk.co.argon.common.datastructures.recursion;

public class Recursion {

	public static void main(String...args) {
		/*System.out.println(factorial(15));
		System.out.println(fibonacci(15));
		System.out.println(sumOfInteger(-14));
		System.out.println(powerOfNum(-3,-1));
		System.out.println(largest(4862,7592));
		System.out.println(decToBin(13));
		System.out.println(reverseString("original String: HelloWorld"));
		countDown(15);
		
		System.out.println("\n=============================");
		System.out.println(5154%2468);*/
		p();
		
	}
	
	private static int factorial(int n) {
		if(n<0)
			return -1;
		if(n==0 || n==1)
			return 1;
		return n* factorial(n-1);
	}
	
	private static int fibonacci(int n) {
		if(n<0)
			return -1;
		if(n==0 || n==1)
			return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	private static int sumOfInteger(int n) {
		if(n<=0)
			return 0;
		return (n%10) + sumOfInteger(n/10);
	}
	
	private static int powerOfNum(int n, int i) {
		if(i<0) return -1;
		if(i==0) return 1;
		return n*powerOfNum(n, i-1);
	}
	
	private static int gcd(int large, int small) {
		if(large<=0 || small<=0)
			return -1;
		if(large==small || large%small==0)
			return small;
		else 
			return gcd(small,large%small);

	}
	
	static private int largest(int m, int n) {
		if(m>=n)
			return gcd(m,n);
		else
			return gcd(n,m);
	}
	
	private static int decToBin(int n) {
		if(n==0)
			return n;
		return (n%2 + 10*decToBin(n/2));
		//return bin;
	}
	
	private static String reverseString(String str) {
		if(str.length()==0) return str;
		return reverseString(str.substring(1)) + str.charAt(0);
	}
	
	private static void countDown(int n) {
		if(n==0) {
			System.out.println(n);
			return;
		}
		System.out.println(n);
		countDown(n-1);
	}
	
	private static void p() { 
        String str = "ABCD"; 
        int n = str.length(); 
        permute(str, 0, n-1); 
    } 
	
	private static void permute(String str, int l, int r) { 
        if (l == r) 
            System.out.println(str); 
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                str = swap(str,l,i); 
            } 
        } 
    } 
  
    /** 
    * Swap Characters at position 
    * @param a string value 
    * @param i position 1 
    * @param j position 2 
    * @return swapped string 
    */
    public static String swap(String a, int i, int j) { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}