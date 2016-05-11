
/** 
 * An instance of this class is a Block.
 * @author Napon Kittisiriprasert
 */
public class Block extends Piece {
    
    /** 
     * Constructor: a new Block at position (x, y) on Map m.
     */
    public Block(int x, int y, Map m){
        super(Piece.BLOCK, m);
        setX(x);
        setY(y);
    }
    
    /** 
     * Block should not move.
     * This method is not used.
     */
    public void act(){
        return;
    }
    
    /** representation of this piece */
    public String toString() {
        return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
    }
}
