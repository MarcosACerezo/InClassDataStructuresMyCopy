import java.util.EmptyStackException;

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

    public void display() {
        StackNode<E> current = top;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getLink();
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
}