package com.bstpractise;

import java.util.Random;


public class BSTUtil {
	
	class Node{
		double value;
		Node left;
		Node right;
		Node(double value){
			this.value=value;
		}
	}

	Node root;
    Node parent;
    
    /**
     * 
     * 
     * 
     *  
     */
    
	public Node find(double value) {
		Node temp = root;
		parent=root;
		while (temp != null) {
			if (value == temp.value) {
				return temp;
			} else if (value > temp.value) {
				parent=temp;
				temp = temp.right;
			} else {
				parent=temp;
				temp = temp.left;
			}
		}
		return null;
	}
	
	/**
	 * This 
	 * @param size : Provide BST Size. Those many elements will be generated by RandomAPI.
	 */
	public void insert(int size) {

		Random r = new Random();
		for (int i = 0; i < size; i++) {
			double nodevalue = Math.ceil(  r.nextDouble()*100);
			System.out.println(nodevalue+"*Inserting*");
			insertValue(nodevalue);
		}

	}
	
	private void insertValue(double nodevalue) {
		
		if(root==null) {
			root=new Node(nodevalue);
			return;
		}
		Node ref = find(nodevalue);
		if (ref != null) {
			System.out.println("Value Already Available");
		} else {
			if (nodevalue > parent.value) {
				parent.right = new Node(nodevalue);
			} else {
				parent.left = new Node(nodevalue);
			}
		}
	}
	
	
	public void prettyDisplayBST() {
		
	}
	
	
}
