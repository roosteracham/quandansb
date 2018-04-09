package 刷题.剑指offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class 包含min函数的栈 {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /*int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    public void push(int node) {

        if (node < min) {
            min = node;
        }
        if (node >= min && node < secondMin) {
            secondMin = node;
        }
        stack1.push(node);
    }

    public void pop() {

        int p = stack1.pop();
        if (p == min) {
            min = Integer.MAX_VALUE;
            while (stack1.size() != 0) {
                int m = stack1.pop();
                if (m < min) {
                    min = m;
                }
                stack2.push(m);
            }
            while (stack2.size() != 0) {
                stack1.push(stack2.pop());
            }
        }
    }

    public int top() {

        return stack1.size();
    }

    public int min() {

        return min;
    }*/


    public void push(int node) {

        stack1.push(node);
        if (stack2.empty()) {
            stack2.push(node);
        } else if (node <= stack2.peek()){
            stack2.push(node);
        }
    }

    public void pop() {

        if (stack1.peek() == stack2.peek()) {
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {

        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        包含min函数的栈 a = new 包含min函数的栈();
        a.push(3);
        System.out.println(a.min());
        a.push(4);
        System.out.println(a.min());
        a.push(2);
        System.out.println(a.min());
        a.push(3);
        System.out.println(a.min());
        a.pop();
        System.out.println(a.min());
        a.pop();
        System.out.println(a.min());
        a.pop();
        System.out.println(a.min());
        a.push(0);
        System.out.println(a.min());
    }
}
