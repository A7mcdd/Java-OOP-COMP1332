package Labs.Lab13.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Act3Console {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("type name of file");
		String name = sc.next();

		File file = new File(name);

		StringBuilder code = new StringBuilder();// افضل نحط String builder لانه اسرع بكثير لما نتعامل مع ملفات كبيرة

		Scanner rf;
		try {
			rf = new Scanner(file);
			while (rf.hasNextLine()) {
				code.append(rf.nextLine());
			}
			rf.close();
			sc.close();
			if(isVaildCode(code.toString()))
				System.out.println("the source-code file has correct pairs of grouping symbols.");
			else
				System.out.println("the source-code file has not correct pairs of grouping symbols.");
		} catch (FileNotFoundException e) {
			System.out.println("The file is not exist");
		}
	}

	public static boolean isVaildCode(String text) {
		Stack<Character> stack = new Stack<>();
		char[] c = text.toCharArray();
		for (Character ch : c) {
			if (ch=='('||ch=='{'||ch=='[') {
				stack.push(ch);
			}else if (ch==')'||ch=='}'||ch==']') {
				if (stack.isEmpty()) return false;

				char last = stack.pop();

				if(ch==')'&&last!='(')return false;
				if(ch==']'&&last!='[')return false;
				if(ch=='}'&&last!='{')return false;
			}
		}
		return stack.isEmpty();// اذا مو فاضية يعني ضل اقواس م اتسكرت
	}

}
