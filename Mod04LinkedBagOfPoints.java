public class Mod04LinkedBagOfPoints {
    public static void main(String[] args) {
        IntLinkedBag myBag = new IntLinkedBag();

        System.out.println("Current size: " + myBag.size());

        myBag.add(100);
        myBag.add(150);
        myBag.add(100);

        System.out.println("There are " + myBag.countOccurrences(100) + " copies.");
        System.out.println("There are " + myBag.countOccurrences(300) + " copies.");

        myBag.remove(100);
        System.out.println("Current size: " + myBag.size());
        
        
        System.out.println("grab() test\n");
        myBag.add(332);
        myBag.add(231);
        myBag.add(865);
        myBag.add(1);
        myBag.add(898);
        for(int i =0; i < 5; i++){
            //System.out.println();
            System.out.println(myBag.grab());
        }

        Position3DLinkedBag positionBag = new Position3DLinkedBag();

        System.out.println("Current size: " + positionBag.size());

        positionBag.add(new Position3D(1, 2, 3));
        positionBag.add(new Position3D(6, 9, 0));
        positionBag.add(new Position3D(4, 2, 0));

        System.out.println("There are " + positionBag.countOccurrences(new Position3D(1, 2, 3)) + " copies.");
        System.out.println("There are " + positionBag.countOccurrences(new Position3D(4, 5, 6)) + " copies.");

        myBag.remove(100);
        System.out.println("Current size: " + positionBag.size());
        
        
        positionBag.add(new Position3D(8, 00, 8135));
        positionBag.add(new Position3D(1, 2, 3));
        positionBag.add(new Position3D(1, 2, 3));
        positionBag.add(new Position3D(1, 2, 3));
        positionBag.add(new Position3D(1, 2, 3));
        for(int i =0; i < 5; i++){
            //System.out.println();
            System.out.println(positionBag.grab());
        }
    }
}
