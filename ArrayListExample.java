import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println("First element: " + numbers.get(0));
        numbers.remove(1);
        boolean containsTwenty = numbers.contains(20);
        System.out.println("Contains 20? " + containsTwenty);
        int size = numbers.size();
        System.out.println("Size of the list: " + size);
        Collections.sort(numbers);
        for (Integer num : numbers) {
            System.out.println("Number: " + num);
        }
        
        ArrayList<Position3D> points = new ArrayList<>();
        for(int i=0; i < 5;i++){
            points.add(new Position3D());
        }
        System.out.println(points.getFirst());
        System.out.println(points.getLast());

        points.remove(1);

        if(!points.contains(Position3D.ORIGIN)){
            points.add(1, Position3D.ORIGIN.clone());
        }
        System.out.println(points.size());

        Collections.sort(points, Collections.reverseOrder());
    }
    
}
