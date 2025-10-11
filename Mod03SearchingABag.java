public class Mod03SearchingABag {
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