import java.awt.Color;

/** 
 * An instance of this class is a Pillar.
 * @author Napon Kittisiriprasert
 */
public class Pillar extends Piece {
	/** 
	 * Constructor: a new Pillar at position (x, y) 
	 * on Map m with random color. 
	 */
    public Pillar(int x, int y, Map m){
        super(Piece.PILLAR, m);
        setX(x);
        setY(y);
        randomColor();
    }
    
    /** Pillar should change color 1/3 of the time.*/
    public void act(){
        randomColor();
    }
    
    public void randomColor() {
    	int c = rand(0, 2);
    	if(c == 0) {
        	setColor(Color.RED);
        } else if(c == 1) {
        	setColor(Color.GREEN);
        } else {
        	setColor(Color.YELLOW);
        }
    }
    
    /** representation of this piece */
    public String toString() {
        return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
    }
}
