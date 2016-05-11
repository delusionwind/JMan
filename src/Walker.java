import java.awt.Color;

/** 
 * An instance of this class is a Walker.
 * @author Napon Kittisiriprasert
 */
public class Walker extends Piece {
	/** 
	 * Constructor: a new Walker at position (x, y) 
	 * on Map m with random color. 
	 */
    public Walker(int x, int y, Map m){
        super(Piece.WALKER, m);
        setX(x);
        setY(y);
        int c = rand(0, 2);
        if(c == 0) {
        	setColor(Color.RED);
        } else if(c == 1) {
        	setColor(Color.GREEN);
        } else {
        	setColor(Color.YELLOW);
        }
    }
    
    /** Walker should move 1/3 of the time.*/
    public void act(){
        if(rand(0, 2) == 0) {
        	int i = rand(0, 3);
        	int toX = getX();
            int toY = getY();
            if(i == 0) {
            	toY -= 1;
            } else if(i == 1) {
            	toY += 1;
            } else if(i == 2) {
            	toX -= 1;
            } else {
            	toX += 1;
            }
            if(getMap().isEmpty(toX, toY)) {
            	getMap().move(getX(), getY(), toX, toY);
            }
        }
    }
    
    /** representation of this piece */
    public String toString() {
        return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
    }
}
