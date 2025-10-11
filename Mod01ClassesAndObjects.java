public class Mod01ClassesAndObjects {
  public static void main(String[] args) {
    Position3D point1 = new Position3D(1.0, 2.0, 3.0);
    Position3D point2 = new Position3D(4.0, 5.0, 6.0);
    System.out.println("Point 1: " + point1);
    System.out.println("Point 2: " + point2);
    
    Position3D point3 = new Position3D();
    System.out.println("Point 3 (random): " + point3);
    
    double distance = Position3D.distanceTo(Position3D.ORIGIN, point3);
    System.out.printf("Distance from point3 to origin: %.2f%n", distance);
    
    Position3D point4 = point2.clone();
    System.out.println("Point 4 (clone of Point 2): " + point4);

    System.out.println("Point 2 equals Point4: " + point2.equals(point4));
    System.out.printf("Point 2 shallow clone of Point 4? %b\n", point2 == point4);

    point2 = null;
    // System.out.println("Point2 equals Point4 after point2=null? " + point2.equals(point4));
    //Null pointer exception
  }
}