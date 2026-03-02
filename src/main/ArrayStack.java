package src.main;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T>{
    private T[] theArray;
    private int topOfStack;

    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    ArrayStack() {
        theArray = (T[]) new Object[DEFAULT_CAPACITY];
        topOfStack = -1;
    }

    public void push(T x) {
        if (topOfStack + 1 == theArray.length) {
            doubleArray();
        };
        theArray[++topOfStack] = x;
    }

    public void pop() {
        if (isEmpty()) throw new UnderflowException("ArrayStack pop");
        theArray[topOfStack--] = null;
    }

    public T top() {
        if (isEmpty()) throw new UnderflowException("ArrayStack top");
        return theArray[topOfStack];
    }

    public T topAndPop() {
        if (isEmpty()) throw new UnderflowException("ArrayStack topAndPop");
        return theArray[topOfStack--];
    }

    public boolean isEmpty() {
        return topOfStack == -1;
    }

    public void makeEmpty() {
        topOfStack = -1;
    }
    
    private void doubleArray() {
        theArray = Arrays.copyOf(theArray, theArray.length * 2);
    }
}
