package com.dmlab;
import javax.swing.*;
import java.security.KeyStore;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<? super Key>, E> {

	class Node {
		private Key mKey;
		private E mValue;

		private Node mLeft;
		private Node mRight;

		public Node(Key key, E value) {
			mKey = key;
			mValue = value;
			mLeft = null;
			mRight = null;
		}

		public Key getKey() {
			return mKey;
		}

		public E getValue() {
			return mValue;
		}

		/**
		 * Insert a node to the subtree, the root of which is this node.
		 * If the subtree already has node with the given key in the param,
		 * replace the value of the node in the subtree.
		 * Please compare keys using compareTo method.
		 * e.g. when "int compare = KEY0.compareTo(KEY1)"
		 * if compare == 0, this means KEY0 is equal to KEY1
		 * if compare > 0, KEY0 > KEY1
		 * if compare < 0, KEY0 < KEY1
		 *
		 * @param key
		 * @param value
		 * @return None
		 */
		public void insert(Key key, E value) {
			if (mKey == null) {
				mKey = key;
				mValue = value;
			} else {
				int compare = key.compareTo(mKey);
				if (compare < 0) {
					if (mLeft == null)
						mLeft = new Node(key, value);
					else
						mLeft.insert(key, value);
				} else if (compare > 0) {
					if (mRight == null)
						mRight = new Node(key, value);
					else
						mRight.insert(key, value);
				} else if (compare == 0)
					mValue = value;
			}
		}

		/**
		 * Find the value of item by the key in the subtree, the root of which is this node.
		 *
		 * @param key
		 * @return the value of item matched with the given key.
		 * null, if there is no matching node in this subtree.
		 */
		public E find(Key key) {
			int compare = key.compareTo(mKey);
			if (compare == 0)
				return mValue;
			else if (compare < 0)
				return mLeft.find(key);
			else if (compare > 0)
				return mRight.find(key);
			else
				return null;
		}

		@Override
		public String toString() {
			return "[" + String.valueOf(mKey) + ":" + String.valueOf(mValue) + "]";
		}

		/**
		 * Traverse with the preorder in this subtree.
		 *
		 * @return The String to be printed-out which contains series of nodes as the preorder traversal.
		 */
		public String preorder() {
			String r = "";
			if (this != null) {
				r = r.concat(this.toString());
				if (mLeft != null)
					r = r.concat(mLeft.preorder());
				if (mRight != null)
					r = r.concat(mRight.preorder());
			}
			return r;
		}

		/**
		 * Traverse with the inorder in this subtree.
		 *
		 * @return The String to be printed-out which contains series of nodes as the inorder traversal.
		 */
		public String inorder() {
			String r = "";
			if (this != null) {
				if (mLeft != null)
					r = r.concat(mLeft.inorder());
				r = r.concat(this.toString());
				if (mRight != null)
					r = r.concat(mRight.inorder());
			}
			return r;
		}

		/**
		 * Traverse with the postorder in this subtree.
		 *
		 * @return The String to be printed-out which contains series of nodes as the postorder traversal.
		 */
		public String postorder() {
			String r = "";
			if (this != null) {
				if (mLeft != null)
					r = r.concat(mLeft.postorder());
				if (mRight != null)
					r = r.concat(mRight.postorder());
				r = r.concat(this.toString());
			}
			return r;
		}

		/**
		 * Find the height of this subtree
		 *
		 * @return height
		 */
		public boolean iscomplete(Node root) {
			if (mLeft != null) {
				if (iscomplete(mLeft) == false)
					return false;
			} else if (mRight != null) {
				if (iscomplete(mRight) == false)
					return false;
			}
			return true;
		}

		/**
		 * Find the height of this subtree
		 *
		 * @return height
		 */
		public int height() {
			int height = 1;
			if (mLeft == null && mRight != null)
				height = mRight.height() + 1;
			else if (mLeft != null && mRight == null)
				height = mLeft.height() + 1;
			else if (mLeft != null && mRight != null) {
				int left = mLeft.height();
				int right = mRight.height();
				if (left >= right)
					height = left + 1;
				else
					height = right + 1;
			}
			return height;
		}

		public Node findMin() {
			if (mLeft == null)
				return this;
			else
				return mLeft.findMin();
		}

		/**
		 * Delete a node,the key of which match with the key given as param, from this subtree.
		 * You may need to define new method to find minimum of the subtree.
		 *
		 * @return the node of which parent needs to point after the deletion.
		 */

		public Node delete(Key key) {
			// pointer to store the parent of the current node
			Node parent = null;
			// start with the root node
			Node curr = this;

			// search key in the BST and set its parent pointer
			while (curr != null && curr.mKey != key) {
				parent = curr;
				int compare = key.compareTo(mKey);
				if (compare < 0)
					curr = curr.mLeft;
				else if (compare > 0)
					curr = curr.mRight;
			}
			if (curr != null) {
				// Case 1: node to be deleted has no children, i.e., it is a leaf node
				if (curr.mLeft == null && curr.mRight == null) {
					if (curr == this)
						return null;
					else if (parent.mLeft == curr)
						parent.mLeft = null;
					else if (parent.mRight == curr)
						parent.mRight = null;
				}

				// Case 2: node to be deleted has two children
				else if (curr.mLeft != null && curr.mRight != null) {
					// find its inorder successor node
					Node successor = curr.mRight.findMin();

					// store successor value
					Key k = successor.mKey;
					E val = successor.mValue;

					// recursively delete the successor. Note that the successor
					// will have at most one child (right child)
					mRight.delete(successor.mKey);

					// copy value of the successor to the current node
					curr.mKey = k;
					curr.mValue = val;
				}

				// Case 3: node to be deleted has only one child
				else {
					// choose a child node
					Node child = (curr.mLeft != null) ? curr.mLeft : curr.mRight;
					if (curr == this) {
						this.mKey = child.mKey;
						this.mValue = child.mValue;
						this.mLeft = child.mLeft;
						this.mRight = child.mRight;
					}
					else if (curr == parent.mLeft)
						parent.mLeft = child;
					else if (curr == parent.mRight)
						parent.mRight = child;
				}
			}
			return this;
		}
	}

	private Node mRoot;
	public BinaryTree() {
		mRoot = null;
	}

	public void insert(Key key, E value) {
		if (mRoot == null) {
			mRoot = new Node(key, value);
		} else {
			mRoot.insert(key, value);
		}
	}

	public void delete(Key key) {
		if (mRoot == null)
			return;
		mRoot = mRoot.delete(key);
	}

	public E find(Key key) {
		if (mRoot == null)
			return null;
		return mRoot.find(key);
	}

	public void preorder() {
		System.out.print("preorder : ");
		if (mRoot == null) {
			System.out.println("None");
			return;
		}
		System.out.println(mRoot.preorder());
	}

	public void inorder() {
		System.out.print("inorder : ");
		if (mRoot == null) {
			System.out.println("None");
			return;
		}
		System.out.println(mRoot.inorder());

	}

	public void postorder() {
		System.out.print("postorder : ");
		if (mRoot == null) {
			System.out.println("None");
			return;
		}
		System.out.println(mRoot.postorder());
	}

	public int height() {
		if (mRoot == null)
			return 0;
		return mRoot.height();
	}

	public void iscomplete()
	{	boolean flag = mRoot.iscomplete(mRoot);
		if (flag)
			System.out.println("The tree is complete binary tree.");
		else
			System.out.println("The tree is not complete.");
	}

}
