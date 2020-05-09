package homework.data_structure.stack;

import homework.data_structure.stack.inteface.Stack;

/**
 * @author MISAKIGA
 */
public class StackLinked<E> implements Stack<E> {

    public static void main(String[] args) throws Exception {


        String[] notation = {"3","17","15","-","*","18","6","/","+"};
        System.out.println("逆波兰表达式结果为：" + calculate(notation));

    }
    public static Integer calculate(String[] notation) throws Exception {
        Stack<String> stack = new homework.data_structure.stack.Stack<>();

        //逆波兰表达式:
        // 如果当前字符为变量或者为数字，则压栈，
        // 如果是运算符，则将栈顶两个元素弹出作相应运算，结果再入栈，最后当表达式扫描完后，栈里的就是结果。
        //步骤分析：
        //如果是数字则压栈
        //如果是运算符，则 1. 弹出2位栈顶内的数字。2. 对两位数字使用（匹配到的运算符）进行运算。将结果压栈。
        //例如 9，6，5，- ，+；依次遍历该数组，匹配到数组则压栈，
        // 如果匹配到运算符 - ，则对栈顶内两位数字 6，5进行运算 6-5=1；结果压栈
        // 此时栈内元素为 9，1；重复以上步骤，继续往后遍历，此时遍历到 运算符 +；
        // 弹出2位栈顶内的数字 1，9；进行运算 9 + 1 = 10；遍历完毕，此时，栈内为计算结果。
        for (String str:
             notation) {
            switch (str){
                case "+":
                case "-":
                case "*":
                case "/":
                    operation(stack,str);
                    break;
                default:
                    stack.push(str);
                    break;
            }
        }
        //返回运算结果，
        return Integer.valueOf(stack.pop());
    }

    public static void operation(Stack<String> stack,String operator) throws Exception{
        Integer o1,o2;
        if(!stack.isEmpty() && stack.size() >= 2) {
            o1 = Integer.valueOf(stack.pop());
            o2 = Integer.valueOf(stack.pop());

            switch (operator){
                case "-" :
                    stack.push(String.valueOf(o2 - o1));
                    break;
                case "+" :
                    stack.push(String.valueOf(o2 + o1));
                    break;
                case "*" :
                    stack.push(String.valueOf(o2 * o1));
                    break;
                case "/" :
                    stack.push(String.valueOf(o2 / o1));
                    break;
                default:
                    throw new Exception("非法的运算符");
            }
        }
    }

    private Node head;
    private int size;

    public StackLinked(){
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E peek() {
        return head.data;
    }

    @Override
    public E pop() throws Exception {

        E e = popFirst();
        return e;
    }

    private E popFirst() throws Exception{

        if (isEmpty()){
            throw new Exception("stack null");
        }

        //这里的顺序不能乱，如果把第三步放到第一步，弹出了栈顶缺没有拿到元素，则造成返回的是栈顶的下一个元素。
        //1.获取头节点，栈顶
        Node temp = head;
        //2.取出栈顶元素数据
        E data = temp.data;
        //3.取出栈顶下一个元素,将栈顶指针指向下一个元素
        head = head.next;

        //释放temp
        temp.data = null;
        temp.next = null;
        temp = null;

        size--;
        return data;
    }

    @Override
    public E push(E e) throws Exception {

        pushFirst(e);
        return e;
    }

    @Override
    public int size() {
        return 0;
    }

    private void pushFirst(E e) {

        //这里的顺序不能乱，如果把第3步放到第2步，
        // 第3步会因为节点被覆盖而丢式原来的栈数据。
        // 并报空异常
        //1.创建新节点，元素赋值
        Node newNode = new Node(null,e);
        //2.将当前节点的next指针指向原栈顶
        newNode.next = head;
        //3.将当前节点设置为栈顶
        head = newNode;

        size++;
    }

    private Node forEach(){

        return head.next;
    }

    public class Node {
        Node next;
        E data;
        private Node(Node next,E data){
            this.next = next;
            this.data = data;
        }
    }
}
