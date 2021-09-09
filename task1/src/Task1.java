public class Task1 {
  public static void main(String[] args) {
	if (args.length < 2) {
	  System.out.println("Not enough arguments!");
	  return;
	}
//	System.out.printf("N = %s, M = %s\n", args[0], args[1]);
	
	int n = Integer.parseInt(args[0]);
	int m = Integer.parseInt(args[1]);
	
	System.out.println(solve(n, m));
  }
  
  public static String solve(int n, int m) {
	String result = "1";
	if (m < 1 || n < 1)
	  return result;
	if (n == 1)
	  return result;
	
	int curr = 1;
	int countOnes = 1;
	while (true) {
	  int next;
	  if (n >= curr + m - 1) {
		next = curr + m - 1;
	  } else {
		next = (curr + m - 1) % n;
		if (next == 0) {
		  next = curr + 1;
		}
	  }
	  if (next == 1)
		countOnes++;
	  if (countOnes > 1)
		break;
	  curr = next;
	  result += String.valueOf(curr);
	}
	return result;
  }
}
