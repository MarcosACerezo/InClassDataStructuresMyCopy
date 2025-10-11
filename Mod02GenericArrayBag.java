public class Mod02GenericArrayBag {
    public static void main(String[] args) {
        ArrayBag<Position3D> myBag = new ArrayBag<>();
        // System.out.println("Current Capacity: " + myBag.getCapacity());
        myBag.add(new Position3D(10,10,10));
        myBag.add(new Position3D(20,20,20));
        myBag.add(new Position3D(10,10,10));
        // System.out.println("Current Capacity: " + myBag.getCapacity());
        myBag.trimToSize();
        System.out.println("Current Capacity: " + myBag.getCapacity());
        System.out.println("Current size: " + myBag.size());
        ArrayBag<Position3D> copiedBag = new ArrayBag<>(myBag);
        for(int i=0; i<myBag.size(); i++){
            System.out.println(copiedBag.get(i)); 
        }

        copiedBag.add(new Position3D(40,40,40));
        System.out.println("Copied bag Size: " + copiedBag.size());
        System.out.println("Copied Bag Capacity: " + copiedBag.getCapacity());
        ArrayBag<Position3D> unionBag = ArrayBag.union(myBag, copiedBag);
        System.out.println("Union Bag Size: " + unionBag.size());
        System.out.println("Union Bag Capacity: " + unionBag.getCapacity());
    }
}
