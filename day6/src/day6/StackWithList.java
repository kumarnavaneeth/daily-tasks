package day6;

import java.util.ArrayList;
import java.util.List;

public class StackWithList {
	private List<Integer> stack = new ArrayList<>();

	void push(int x) {
		stack.add(x);
		System.out.println(x + " item has been pushed to the stack");
	}

	int pop() {
		if (stack.isEmpty()) {
			System.out.println("stack underflow");
			return -1;
		}
		return stack.remove(stack.size() - 1);
	}

	int peek() {
		if (stack.isEmpty()) {
			System.out.println("stack underflow");
			return -1;
		}
		return stack.get(stack.size() - 1);
	}

	void display() {
		System.out.println(stack);
	}
	public static void main(String[] args) {
		StackWithList list=new StackWithList();
		list.push(10);
		list.push(20);
		list.push(30);
		list.display();
		System.out.println("item removed is:"+list.pop());
		System.out.println("peek element is:"+list.peek());
	}
}
