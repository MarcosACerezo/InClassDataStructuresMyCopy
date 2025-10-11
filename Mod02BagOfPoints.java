public class Mod02BagOfPoints {
    public static void main(String[] args) {
        Position3DArrayBag myBag = new Position3DArrayBag();
        System.out.println("Current Capacity: " + myBag.getCapacity());
        myBag.add(new Position3D());
        myBag.add(new Position3D());
        myBag.add(new Position3D());
        System.out.println("Current Capacity: " + myBag.getCapacity());
        myBag.trimToSize();
        System.out.println("Current Capacity: " + myBag.getCapacity());

        Position3DArrayBag cloneBag = new Position3DArrayBag(myBag);
        System.out.println("cloneBag size: " + cloneBag.size());
        System.out.println("myBag size: " + myBag.size());
        for(int i=0; i<cloneBag.size(); i++){
            System.out.println("CLONE Points share same address: " + (cloneBag.get(i) == myBag.get(i)));
            System.out.println("CLONE Points share same values: " + (cloneBag.get(i).equals(myBag.get(i))));
        }
        Position3DArrayBag unionBag = Position3DArrayBag.union(myBag, cloneBag);

        System.out.println(myBag.size());
        System.out.println(cloneBag.size());
        System.out.println(unionBag.size());
        for(int i=0; i<myBag.size(); i++){
            System.out.println("\nUNION Points share same address: " + (myBag.get(i) == unionBag.get(i)));
            System.out.println("UNION Points share same values: " + (myBag.get(i).equals(unionBag.get(i))));
        }
        for(int i=myBag.size(); i<unionBag.size(); i++){
            System.out.println("\nUNION Points share same address: " + (cloneBag.get(i - 3) == unionBag.get(i)));
            System.out.println("UNION Points share same values: " + (cloneBag.get(i - 3).equals(unionBag.get(i))));
        }

    }
}

/**
 * runtime analysis
 * 
 * add - Best case: O(1)    Worst case: O(n)
 * size Worst case: O(1)
 * union - O(n)
 * new constructor - O(n)
 */