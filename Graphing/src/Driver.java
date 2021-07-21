/**
 * Driver used For testing and Showing use of Graph
 * @author Abhrajit Ghosh
 *
 */
public class Driver {
	public static void main(String[] args)  {
		 Helper.start();
	    }
}

class Helper{
	public static void start() {
		Graph graph = new Graph();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        System.out.println("is Empty? "+graph.IsEmpty());
        graph.insert(a,b);
        graph.insert(b,c);
        graph.insert(b,d);
        graph.insert(c,e);
        graph.insert(b,a);
        graph.insert(e,f);
        graph.Delete(e,f);
        System.out.println("after inserting is Empty? "+graph.IsEmpty());
        graph.traverse();

        System.out.println("edge? a to b "+graph.Edge(a,b));
        System.out.println("edge? d to a "+graph.Edge(d,a));
        graph.DFSTraverse(a);
        System.out.println("vertices"+graph.getVerti());
        System.out.println("edges"+graph.getEdge());
	}
}
