package linktsp.util;

/**
 * This class allows us to take a line from a file and parse it
 * to extract the intended variables
 */
public class Token {
    /*
     * Instance variables
     */

    // The id of the point / city
    private int id;

    // The coordinates of the point
    private Point point;

    /**
     * Constructor with all the variables that form part of this structure
     * @param id the id of the city
     * @param x the x coordinates of the city
     * @param y the y coordinates of the city
     */
    public Token(int id, double x, double y) {
        this.id = id;
        this.point = new Point(x, y);
    }

    /**
     * Getter that allows us to get the id of the city
     * @return int the id of the city
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter that allows us to get the point coordinates of the city
     * @return linkernighan.tsp.Point representing the coordinates of the city
     */
    public Point getPoint() {
        return this.point;
    }

}