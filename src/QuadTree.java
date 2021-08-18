class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Node{
    Point point;
    Node top_right;
    Node top_left;
    Node down_right;
    Node down_left;

    public Node(Point point) {
        this.point = point;
        this.top_left = null;
        this.top_right = null;
        this.down_left = null;
        this.down_right = null;
    }
}
public class QuadTree {

}
class Main{
    public static void main(String[] args) {

    }
}
