import java.util.Arrays;
class ArrayBag<E extends Comparable> implements Cloneable {
    private E[ ] data;
    private int manyItems;

    public ArrayBag( ) {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data = (E[]) new Comparable[INITIAL_CAPACITY];
    }
    public void add(E element){
        if (manyItems == data.length)
            ensureCapacity((manyItems + 1)*2);
        data[manyItems] = element;
        manyItems++;
    }
    public void ensureCapacity(int minimumCapacity) {
        E biggerArray[ ];
        if (data.length < minimumCapacity) {
            biggerArray = (E[]) new Comparable[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }
    public int countOccurrences(E target){
        int answer =0, index;
        for (index = 0; index < manyItems; index++)
        if (target.equals(data[index]))
            answer++;
        return answer;
    }
    public int getCapacity( ) {
        return data.length;
    }
    public int size( ) {
        return manyItems;
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
        int right = manyItems;
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
public class SearchExample {
    public static void main(String[] args) {
        ArrayBag<Integer> myBag = new ArrayBag<Integer>();
        myBag.add(20);
        myBag.add(-100);
        myBag.add(10);
        myBag.add(3);
        myBag.add(50);
        myBag.add(4054);
        myBag.add(234234);
        myBag.add(123123);
        myBag.add(234234);
        myBag.add(543543);
        myBag.add(343);
        System.out.println("Integer Bag section");
        System.out.println("There are "+ myBag.countOccurrences(3)+ " copies.");
        System.out.println("There are "+ myBag.countOccurrences(30)+ " copies.");

        System.out.println("Current size: " + myBag.size());
        int index = myBag.search(343);
        //bag is unsorted up to this point
        if(index == -1){
            System.out.println("The element you are looking for was not found");
        }else{
            System.out.printf("The item was located at index: %d\n", index);
        }

        //binary search functionality
        index = myBag.binarySearch(3);
        if(index == -1){
            System.out.println("Element not found in the array.");
        }else{
            System.out.printf("The element was found at index: %d\n", index);
        }

        //created many items because we need to know the values of each one
        ArrayBag<Position3D> newBag = new ArrayBag<Position3D>();
        //before sort 5 is at index 5 because it is the sixth element
        //after sort 5 is at index 4 because it is fourth element
        for(int i=10; i>=1; i--){
            newBag.add(new Position3D(i, i, i));
        }
        Position3D searchItem = new Position3D(5, 5, 5);
        index = newBag.search(searchItem);
        System.out.println("\nPOSITION 3D SECTION");
        if(index == -1){
            System.out.println("[Sequential Search] Element not found in the array.");
        }else{
            System.out.printf("[Sequential Search] The element was found at index: %d\n", index);
        }

        index = newBag.binarySearch(searchItem);
        if(index == -1){
            System.out.println("[Binary Search] Element not found in the array.");
        }else{
            System.out.printf("[Binary Search] The element was found at index: %d\n", index);
        }
    }
}