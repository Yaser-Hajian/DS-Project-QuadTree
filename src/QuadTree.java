import java.util.Scanner;

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
    public boolean search_point(Point point){
        if (root == null){
            return false;
        }
        if (root.point.x == point.x && root.point.y == point.y){
            return true;
        }

        Node current = root;
        while (true){
            if (point.x >= current.point.x && point.y > current.point.y){
                current = current.top_right;
                if (current == null){
                    return false;
                }
                if (current.point.x == point.x && current.point.y == point.y){
                    return true;
                }
            } else if (point.x > current.point.x && point.y <= current.point.y){
                current = current.down_right;
                if (current == null){
                    return false;
                }
                if (current.point.x == point.x && current.point.y == point.y){
                    return true;
                }
            } else if (point.x < current.point.x && point.y >= current.point.y){
                current = current.top_left;
                if (current == null){
                    return false;
                }
                if (current.point.x == point.x && current.point.y == point.y){
                    return true;
                }
            }
            else if (point.x <= current.point.x && point.y < current.point.y){
                current = current.down_left;
                if (current == null){
                    return false;
                }
                if (current.point.x == point.x && current.point.y == point.y){
                    return true;
                }
            }
        }
    }
    public int search_area(Node node ,Point point1, Point point2){
        if (node == null){
            return 0;
        }

        Node current = node;
        if (current.point.x >= point1.x &&
                current.point.x <= point2.x &&
                current.point.y >= point1.y &&
                current.point.y <= point2.y)   {
            return 1+
                    search_area(current.down_left , point1 , point2)+
                    search_area(current.down_right , point1 , point2)+
                    search_area(current.top_left , point1 , point2)+
                    search_area(current.top_right , point1 , point2);
        }else if (current.point.x < point1.x && current.point.y < point1.y){
            return search_area(current.top_right , point1,point2);
        }else if (current.point.x < point1.x && point1.y < current.point.y && current.point.y < point2.y){
            return  search_area(current.top_right , point1 , point2)+
                    search_area(current.down_right, point1, point2);
        }else if (current.point.x <= point1.x && current.point.y >= point2.y){
            return search_area(current.down_right , point1,point2);
        }else if (current.point.x > point1.x && current.point.x < point2.x && current.point.y >= point2.y){
            return  search_area(current.down_right,point1,point2)+
                    search_area(current.down_left,point1,point2);
        }else if (current.point.x >= point2.x && current.point.y >= point2.y){
            return search_area(current.down_left , point1,point2);
        }else if (current.point.x > point2.x && current.point.y > point1.y && current.point.y < point2.y){
            return  search_area(current.top_left , point1 ,point2)+
                    search_area(current.down_left , point1, point2);
        }else if (current.point.x >= point2.x && current.point.y <= point1.y){
            return search_area(current.top_left , point1,point2);
        }else {
            return  search_area(current.top_left , point1 , point2)+
                    search_area(current.top_right , point1 , point2);
        }

    }
}
class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        QuadTree quadTree= new QuadTree();
        while (input.hasNext()){
            String operation = input.next();
            switch (operation){
                case "Insert":

                    break;
                case "Search":

                    break;
                case "Area":

                    break;
            }
        }
    }
}
