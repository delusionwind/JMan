import java.awt.*;

/** An instance of this class is a J*Man.
 * There should at most one J*Man in a game board at a time
 * @author Napon Kittisiriprasert
 */
public class JMan extends Piece {
    
    /** Constructor: a new J*Man at position (x, y) on Map m
     with color red if c = 0, green if c = 1, and yellow if c = 2. */
    public JMan(int x, int y, int c, Map m){
        super(Piece.JMAN, m);
        setX(x);
        setY(y);
        if(c == 0) {
        	setColor(Color.RED);
        } else if(c == 1) {
        	setColor(Color.GREEN);
        } else {
        	setColor(Color.YELLOW);
        }
    }
    
    /** Constructor: a new J*Man at position (x, y) on Map m
     with color c. Precondition: c is one of
     Color.RED, Color.GREEN, and Color.YELLOW.*/
    public JMan(int x, int y, Color c, Map m){
        super(Piece.JMAN, m);
        setX(x);
        setY(y);
        setColor(c);
    }
    
    /** J*Man should move based on what button is pushed.
     This method is not used. */
    public void act(){
        return;
    }
    
    /** Move J*Man one step based on the value of i:
        0 = up, 1 = down, 2 = left, 3 = right. */
    public void step(int i){
        setActed(true);
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
        Map m = getMap();
        if(m.isInGrid(toX, toY) == false) return;
        Piece piece = m.pieceAt(toX, toY);
        if(piece == null) {
        	m.move(getX(), getY(), toX, toY);
        	return;
        }
        Color pieceColor = piece.getColor();
        if(piece instanceof Block) return;
        if((piece instanceof Walker || piece instanceof Pillar)
        		&& capture(getColor(), pieceColor)) {
        	setColor(pieceColor);
        	m.move(getX(), getY(), toX, toY);
        }
        
    }
    
    public boolean capture(Color A, Color B) {
    	if(A == Color.GREEN && B == Color.RED) return true;
    	if(A == Color.YELLOW && B == Color.GREEN) return true;
    	if(A == Color.RED && B == Color.YELLOW) return true;
    	return false;
    }
    
    /** = representation of this piece */
    public String toString() {
        return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
    }
}
