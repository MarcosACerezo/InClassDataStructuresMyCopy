import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedStack<E> implements Cloneable {
    private StackNode<E> top;

    public LinkedStack() {
        top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public E peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.getData();
    }

    public E pop() {
        if (top == null)
            throw new EmptyStackException();

        E answer = top.getData();
        top = top.getLink();
        return answer;
    }

    public void push(E item) {
        top = new StackNode<E>(item, top);
    }

    //runtime O(n) because we have to traverse the whole list to display every element  
    public void display() {
        StackIterator<E> iter = new StackIterator<E>(top);
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }

    //Runtime O(n)
    public LinkedStack<E> flip(){
        if(top == null){
            return null;//there are no elements in this linked stack
        }
        LinkedStack<E> flippedStack = new LinkedStack<>();
        StackNode<E> cursor = top;
        while(cursor != null){
            flippedStack.push(cursor.getData());
            cursor=cursor.getLink();
        }

        return flippedStack;
    }

    public static <E> boolean equals(LinkedStack<E> stack1, LinkedStack<E> stack2){
        StackNode<E> cursor1 = stack1.top;
        StackNode<E> cursor2 = stack2.top;
        while(cursor1 != null || cursor2 != null){
            if(!cursor1.getData().equals(cursor2.getData())){
                return false;
            }
            cursor1 = cursor1.getLink();
            cursor2 = cursor2.getLink();
        }
        return (cursor1 == null && cursor2 == null);
    }

    class StackIterator<E> implements Iterator<E> {
        private StackNode<E> current;

        public StackIterator(StackNode<E> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException("The stack is empty");

            E answer = current.getData();
            current = current.getLink();
            return answer;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(
                "You are not allowed to remove an element from the stack!"
            );
        }
    }
}