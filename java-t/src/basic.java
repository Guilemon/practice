
import java.util.Scanner;

public class basic {

	public static void main(String[] args) {
//		primitive types
		int a = 9;
//		class/object types
		Integer num = Integer.valueOf(a);//pooling from int
		String k = "no name"; //literal
		
		System.out.println(k+" has "+num+" apples");
		
//		faster than +=, since that creates new copy on
//		each iteration
		StringBuffer al = new StringBuffer("alias");
		al.append(" has noname");
		System.out.println(al);
		
		Scanner input = new Scanner(System.in);
		System.out.println("choose a, b or c");
		String flag = input.nextLine();
		try {
		switch(flag) {
		case "a":
			System.out.println("you choose a");
			break;
		case "b":
			System.out.println("you choose b");
			break;
		case "c":
			System.out.println("you choose c");
			break;
		default:
			System.out.println("There is no good answer");
			break;
		}
		} finally {
			input.close();
		}
		
		
		
//		arrays:
//		array of objects is refrence types array
//		since they only refrence to the object in
//		memory
		
//		array 2 types - primitive types , refrence types
		
//		enhanced for loops for arrays only used for retriveing
//		the values, not modifing the array values
		
		int[] arr = {1,4,5,6,7};
		String[] strB = new String[2];
		
		for(int i: arr) {
			System.out.printf("%3d\n", i);
		}

	}

}
