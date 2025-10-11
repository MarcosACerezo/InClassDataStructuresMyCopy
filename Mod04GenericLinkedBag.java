public class Mod04GenericLinkedBag {
    public static void main(String[] args) {
        LinkedBag<Position3D> positionBag = new LinkedBag<>();
        System.out.println("Current size: " + positionBag.size());

        //filling bag
        positionBag.add(new Position3D(1, 2, 3));
        positionBag.add(new Position3D(6, 9, 0));
        positionBag.add(new Position3D(4, 2, 0));
        positionBag.add(new Position3D(8, 00, 8135));
        positionBag.add(new Position3D(1, 2, 3));
        positionBag.add(new Position3D(1, 2, 3));
        positionBag.add(new Position3D(1, 2, 3));
        positionBag.add(new Position3D(1, 2, 3));

        //comparisons
        Position3D OneTwoThreeVector = new Position3D(1, 2, 3);
        Position3D FourFiveSixVector = new Position3D(4, 5, 6);
        System.out.printf("There are %s copies of %s\n", positionBag.countOccurrences(OneTwoThreeVector), OneTwoThreeVector);
        System.out.printf("There are %s copies of %s\n", positionBag.countOccurrences(FourFiveSixVector), FourFiveSixVector);

        System.out.println("Current size: " + positionBag.size());
        
        //grab test
        System.out.println("Grab functionality test");
        for(int i =0; i < 10; i++){
            //System.out.println();
            System.out.println(positionBag.grab());
        }

        LinkedBag<Position3D> secondBag = new LinkedBag<>();
        secondBag.add(new Position3D(8, 00, 8135));
        secondBag.add(new Position3D(1, 2, 3));
        secondBag.add(new Position3D(1, 2, 3));
        secondBag.add(new Position3D(1, 2, 3));
        secondBag.add(new Position3D(1, 2, 3));

        LinkedBag<Position3D> unionBag = LinkedBag.union(secondBag, positionBag);
        System.out.println(unionBag.size());
        Node<Position3D> cursor = unionBag.getHead();
        System.out.println("\n\n Union Bag Information\n");
        while(cursor != null){
            System.out.println(cursor.getData());
            cursor = cursor.getLink();
        }

        System.out.printf("Size of position bag: %d\n", positionBag.size());
        System.out.printf("Size of second bag: %d\n", secondBag.size());
        System.out.printf("Size of union bag: %d\n", unionBag.size());

    }
}


