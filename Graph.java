package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

	//HashMap to retrieve Node based on Node id
	HashMap<Integer, Node> nodeLookup = new HashMap<Integer,Node>();
	
	
	public static class Node{
		
		LinkedList<Node> adjacent = new LinkedList<Node>();
		private int id;
		//Constructor
		private Node(int id){
			this.id =id;
		}
		
		
	}//class Node
	
	public Node getNode(int id){
		
		return nodeLookup.get(id);
	}//getNode
	
	public void addEdge(int source,int destination){
		
		Node sourceNode = getNode(source);
		Node destinationNode = getNode(destination);
		
		sourceNode.adjacent.add(destinationNode);
	}//addEdge
	
	
	//Depth First Search
	public boolean hasPathDFS(int source,int destination){
		
		Node s= getNode(source);
		Node d = getNode(destination);
		//To keep Track of Visited Nodes
		HashSet<Integer> visited = new HashSet<Integer>();
		
		return hasPathDFS(s,d,visited);
		
	}
	
	private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited){
		
		//1. Find whether the Node is Visited
		if(visited.contains(source.id)){
			return false;
		}
		
		//2 Mark the Node as Visited
		visited.add(source.id);
		
		//3. If Source Node matches destination Node then Return true
		if(source==destination){
			return true;
		}
		
		//4. Traverse all child node and repeat the same process recursively
		for(Node child: source.adjacent){
			
			if(hasPathDFS(child, destination, visited)){
				return true;
			}
		}
		
		//If there is no path from source to Target
		return false;
	}
	
	
	
	//Breadth First Search
	public boolean hasPathBFS(int source ,int destination){
		
		Node s = getNode(source);
		Node d = getNode(destination);
		
		return hasPathBFS(s,d);
		
	}
	
	private boolean hasPathBFS(Node source,Node destination){
		
		HashSet<Integer> visited = new HashSet<Integer>();
		
		//Consider nextToVisit as a Queue Implementation
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		
		//add node to queue
		nextToVisit.add(source);
		
		while(!nextToVisit.isEmpty()){
			
			//Dequeue the element from List
			Node node = nextToVisit.remove();
			
			//If source matches target
			if(node ==destination){
				
				return true;
			}
		
			//If Node is already Visited
			if(visited.contains(source.id)){
				
				continue;
			}
			
			//Mark Node as visited
			visited.add(source.id);
			
			//Add the neighboring nodes to list
			for(Node child : node.adjacent){
				
				nextToVisit.add(child);
			}//for
			
		}//while
		
		
		return false;
	}
	
	public static void main(String args[]){
		
		Graph g = new Graph();

		Graph.Node n1 = new Graph.Node(1);
		
		//Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		
		g.nodeLookup.put(n1.id, n1);
		g.nodeLookup.put(n2.id, n2);
		g.nodeLookup.put(n3.id, n3);
		g.nodeLookup.put(n4.id, n4);
		
		
		g.addEdge(n1.id, n2.id);
		g.addEdge(n1.id, n3.id);
		g.addEdge(n2.id, n3.id);
		g.addEdge(n3.id, n4.id);
		
		
		System.out.println(g.hasPathDFS(n1.id, n3.id));
		System.out.println(g.hasPathBFS(n1.id, n4.id));
		
		
	}

}



