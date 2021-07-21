import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
/*
 * Graph class is the main class
 */

public class Graph {
	   Map<Node, ArrayList<Node>> adjMap;
	   int verti=0;
	   int edge=0;
	    public Graph(){
	    	//Initializes adjMap as hashmap
	        adjMap = new HashMap<>();
	    }
	    
	    public int getVerti(){
	    	verti=adjMap.size();
	    	return verti;
	    }
	    public int getEdge() {
	    	return edge;
	    }

	    public void insert(Node source, Node destination){
	    	
	        //checks for key or source
	    	if(!adjMap.keySet().contains(destination)){
	            //for vertex with no edges
	            adjMap.put(destination, null);
	        }
	    	
	        if(!adjMap.keySet().contains(source)){
	            //puts in the source
	            adjMap.put(source, null);
	        }
	        
	        ArrayList<Node> tempList = adjMap.get(source);
	        if(tempList == null){
	            tempList = new ArrayList<>();
	        }
	        
	        
	        tempList.add(destination);
	        edge++;
	        adjMap.put(source, tempList);
	        
	        
	    }
	    
	    public boolean IsEmpty() {
	    	return adjMap.isEmpty();
	    }
	    
	    public void Delete(Node source, Node destination) {
	    	  ArrayList<Node> tempList = adjMap.get(source);
		        if(tempList == null){
		            tempList = new ArrayList<>();
		        }
		        tempList.remove(destination);
		        edge--;
	    	adjMap.remove(source,tempList);
	    }
	    
	    
	    //checks if has edge
	    public boolean Edge(Node source, Node destination){
	    	if(adjMap.containsKey(source) && adjMap.get(source) != null && adjMap.get(source).contains(destination)) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }

	    public void traverse(){
	        for(Node rootNode: adjMap.keySet()){
	            System.out.printf("going from node " + rootNode.getName() + " to ");
	            ArrayList<Node> vertices = adjMap.get(rootNode);
	            if(vertices != null) {
	            	
	                for (Node adjNode : adjMap.get(rootNode)){
	                    System.out.print(adjNode.getName());
	                }
	            }
	            System.out.println();
	        }
	    }
	    //DFS Traversal
	    public void DFSTraverse(Node node){
	        List<Node> pastNode = new ArrayList<>();
	        Stack<Node> stack = new Stack<>();
	        stack.push(node);
	        pastNode.add(node);
	        while (!stack.isEmpty()){
	            List<Node> edges = adjMap.get(stack.peek());
	            if (edges != null){
	            	
	                Node useNode = edges.stream().filter(edge -> !pastNode.contains(edge)).findFirst().orElse(null);
	                if (useNode != null){
	                    stack.push(useNode);
	                    if (!pastNode.contains(useNode)) {
	                        pastNode.add(useNode);
	                    }
	                }
	                else{
	                    stack.pop();
	                }
	            }
	            else {
	                stack.pop();
	            }
	        }
	        pastNode.stream().forEach(node1 -> System.out.println(node1.getName()));
	    }
}


