package homework.data_structure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack<E> implements homework.data_structure.stack.inteface.Stack<E> {

    private int top;
    private E[] data;

    public Stack(){
        data = (E[])new Object[16];
        top = -1;
    }

    @Override
    public boolean isEmpty(){
        return top == -1;
    }

    @Override
    public E peek(){
        return data[top];
    }

    @Override
    public E pop() throws Exception {
        if(isEmpty()){
            throw new Exception("stack null");
        }
        //栈为空，抛出异常，后面代码不会运行。
        //先取值
        E e = data[top];
        //弹出栈顶元素，top指针-1
        data[top--] = null;
        //返回值
        return e;
    }

    @Override
    public E push(E e) throws Exception {
        if((top + 1) == data.length-1){
            throw new Exception("stack full");
        }
        data[++top] = e;
        return e;
    }

    public boolean hasNext(){
        return top-1 >= -1;
    }

    @Override
    public int size(){
        return top + 1;
    }

    public static void main(String[] args) throws Exception {

        Stack<String> stack = new Stack<>();
        stack.push("hihi");
        stack.push("h22i");
        stack.push("h34hi");
        stack.push("hi54i");

        System.out.println("stack size:" + stack.size());
        Thread.sleep(200);
        while(stack.hasNext()){
            System.err.println(stack.pop());
        }
        System.out.println("stack is empty:" + stack.isEmpty());
    }
}
