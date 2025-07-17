public interface Stack<T> {
    void push(T item) throws StackOverflowException;
    T pop() throws StackUnderflowException;
    T peek() throws StackUnderflowException;
    boolean isEmpty();
    boolean isFull();
}
