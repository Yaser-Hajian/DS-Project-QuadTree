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
    public Node root;

    public QuadTree(){
        root=null;
    }

    public void insert(Point point){
        Node newNode = new Node(point);
        if (root == null){
            root=newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true){
            parent = current;
            if (point.x >= current.point.x && point.y > current.point.y){
                current = current.top_right;
                if (current == null){
                    parent.top_right = newNode;
                    return;
                }
            }
            else if (point.x > current.point.x && point.y <= current.point.y){
                current = current.down_right;
                if (current == null){
                    parent.down_right = newNode;
                    return;
                }
            }
            else if (point.x < current.point.x && point.y >= current.point.y){
                current = current.top_left;
                if (current == null){
                    parent.top_left = newNode;
                    return;
                }
            }
            else if (point.x <= current.point.x && point.y < current.point.y){
                current = current.down_left;
                if (current == null){
                    parent.down_left = newNode;
                    return;
                }
            }
        }
    }
}
class Main{
    public static void main(String[] args) {

    }
}
