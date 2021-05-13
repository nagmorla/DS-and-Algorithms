package com.bstpractise;

public class BSTUtilClientClass {

	public static void main(String[] args) {
		BSTUtil bs = new BSTUtil();
		java.util.Scanner sc1 = new java.util.Scanner(System.in);
		do {
			System.out.println(" " + "1. Insert Node. \n" + "2. Search Node \n " + "3. Pretty Display BST \n " + "9. Exit \n");

			int userOption = sc1.nextInt();
			switch (userOption) {
			case 1:
				System.out.println("Enter How many Nodes you want to enter:");
				int numberofNodes = sc1.nextInt();
				bs.insert(numberofNodes);
				break;
			case 4:
				bs.prettyDisplayBST();
				break;

			case 9:
				System.exit(0);
			}
		} while (true);
	}
}
