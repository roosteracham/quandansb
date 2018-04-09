package 刷题.剑指offer;

import java.util.Stack;

public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);
    }

    public int pop() {

        while (stack1.size() != 1) {
            stack2.push(stack1.pop());
        }
        int out = stack1.pop();
        while (stack2.size() != 0) {
            stack1.push(stack2.pop());
        }
        return out;
    }
}
