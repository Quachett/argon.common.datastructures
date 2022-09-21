package uk.co.argon.common.datastructures.stack;

public class TestStack {

	public static void main(String[] args) {
		test();
	}
	
	private static void test() {
		Stack<Integer> stack = new Stack<>();
		stack.push(15);
		stack.push(7);
		stack.push(159);
		stack.push(28);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.toString());
	}

}
