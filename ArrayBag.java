import java.util.Arrays;

public class ArrayBag <E extends Comparable<E>> implements Cloneable{
    private E data[];
    private int manyItems;

    @SuppressWarnings("unchecked")
    public ArrayBag( ){
        final int INITIAL_CAPACITY = 2;
        manyItems = 0;
        data = (E[]) new Comparable[INITIAL_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayBag(ArrayBag<E> other) {
        this.manyItems = other.manyItems;
        this.data = (E[]) new Comparable[other.data.length];
        try{
            for (int i = 0; i < other.manyItems; i++){
                data[i] = (E) other.data[i].getClass().getMethod("clone").invoke(other.data[i]);
            }
        }catch(Exception e){

        }
        
    }

    public void add(E element) {
        if (manyItems == data.length) {
            ensureCapacity((manyItems + 1)*2);
        }
        data[manyItems] = element;
        manyItems++;
    }

    public E get(int index){
        if(index >= manyItems){
            throw new ArrayIndexOutOfBoundsException("Out of bounds");
        }
        return (E) data[index];
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int minimumCapacity) {
        E biggerArray[];
        if (data.length < minimumCapacity) {
            biggerArray = (E[]) new Comparable[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }
    public int countOccurrences(E target){
        int answer = 0;
        for (int index = 0; index < manyItems; index++){
            if (target.equals(data[index])){
                answer++;
            }
        }
        
        return answer;
    }

    public int getCapacity( ) {
        return data.length;
    }
    public int size( ) {
        return manyItems;
    }
    @SuppressWarnings("unchecked")
    public void trimToSize( ) {
        E[] trimmedArray;
        if (data.length != manyItems) {
            trimmedArray = (E[]) new Comparable[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> ArrayBag<T> union(ArrayBag<T> bag1, ArrayBag<T> bag2) {
        ArrayBag<T> result = new ArrayBag<>();
        result.ensureCapacity(bag1.manyItems + bag2.manyItems);
        try{
            for (int i = 0; i < bag1.manyItems; i++){
                result.add((T) bag1.data[i].getClass().getMethod("clone").invoke(bag1.data[i]));
            }
            for (int i = 0; i < bag2.manyItems; i++){
                result.add((T) bag2.data[i].getClass().getMethod("clone").invoke(bag2.data[i]));
            }
        }
        catch (Exception e){
            throw new AssertionError("Cloning not supported", e);
        }
        return result;
    }

    public int search(E target){
        for(int i=0; i< manyItems; i++){
            if(target.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    // BinarySearch method to start with
    // Method to perform binary search on a sorted array
    public int binarySearch(E target) {
        Arrays.sort(data, 0, manyItems);
        int left = 0;
        int right = manyItems - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Check if target is present at mid
            if (data[mid].compareTo(target) == 0) {
                return mid;
            }
            // If target greater, ignore left half
            if (data[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {// If target is smaller, ignore right half
                right = mid - 1;
            }
        }
        // Target was not found in the array
        return -1;
    }
}
