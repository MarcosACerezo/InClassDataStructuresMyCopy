public class Position implements Cloneable{
    private int y;
    private int x;


    public Position(Position other){
        this.x = other.x;
        this.y = other.y;
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public Position clone() {
      return new Position(this.x, this.y);
    }

    @Override
    public boolean equals (Object other){
        if(other instanceof Position){
            Position otherPoint = (Position) other;
            return this.x==otherPoint.x && this.y== otherPoint.y;
        }
        return false;
    }

    @Override 
    public String toString(){
        return String.format("X value: %d   Y value: %d", x, y);
    }


}
