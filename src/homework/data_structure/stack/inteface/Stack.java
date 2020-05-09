package homework.data_structure.stack.inteface;

public interface Stack<E> {

    boolean isEmpty();
    E peek();
    E pop() throws Exception;
    E push(E e) throws Exception;
    int size();
}
