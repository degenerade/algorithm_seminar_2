package src.main;

public interface Stack<T> {
    void push(T x);
    void pop();
    T top();
    T topAndPop();
    boolean isEmpty();
    void makeEmpty();
}