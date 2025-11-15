public class StackNode<E> {
    private E data;
    private StackNode<E> link;

    public StackNode(E initialData, StackNode<E> initialLink) {
        data = initialData;
        link = initialLink;
    }

    public void setData(E newData) { 
        data = newData; 
    }

    public E getData() { 
        return data; 
    }

    public StackNode<E> getLink() { 
        return link; 
    }

    public void setLink(StackNode<E> newLink) { 
        link = newLink; 
    }
}