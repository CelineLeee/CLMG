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
		 * 		replace the value of the node in the subtree.
		 * Please compare keys using compareTo method.
		 * e.g. when "int compare = KEY0.compareTo(KEY1)"
		 * 		if compare == 0, this means KEY0 is equal to KEY1
		 * 		if compare > 0, KEY0 > KEY1
		 * 		if compare < 0, KEY0 < KEY1
		 * @param key
		 * @param value
		 * @return
		 * 			None
		 */
		public void insert(Key key, E value) {
			if (mKey == null) {
				mKey = key;
				mValue = value;
			}

			else {
				int compare = key.compareTo(mKey);
				if (compare < 0) {
					if (mLeft == null)
						mLeft = new Node(key, value);
					else
						mLeft.insert(key, value);
				}
				else if (compare > 0) {
					if (mRight == null)
						mRight = new Node(key, value);
					else
						mRight.insert(key, value);
				}
				else if (compare == 0)
					mValue = value;
			}
		}

		/**
		 * Find the value of item by the key in the subtree, the root of which is this node.
		 * @param key
		 * @return
		 * 			the value of item matched with the given key.
		 * 			null, if there is no matching node in this subtree.
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
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the preorder traversal.
		 */
		public String preorder() {
			System.out.println(this.toString());
			if (mLeft != null)
				mLeft.preorder();
			if (mRight != null)
				mRight.preorder();
			return null;
		}

		/**
		 * Traverse with the inorder in this subtree.
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the inorder traversal.
		 */
		public String inorder() {
			mLeft.inorder();
			System.out.print(this.toString());
			mRight.inorder();
			return null;
		}

		/**
		 * Traverse with the postorder in this subtree.
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the postorder traversal.
		 */
		public String postorder() {
			mLeft.postorder();
			mRight.postorder();
			System.out.print(this.toString());
			return null;
		}

		/**
		 * Find the height of this subtree
		 * @return
		 * 			height
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
		 * @return
		 * 			height
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
		 * @return
		 * 			the node of which parent needs to point after the deletion.
		 */
		public Node delete(Key key) {
			Node ss = new Node(null, null);
			int compare = key.compareTo(mKey);
			if (find(key) != null) {
				if (compare == 0) {
					if (mLeft == null && mRight == null) {
						mKey = null;
						mValue = null;
						ss = null;
					}
					else if (mLeft != null && mRight == null) {
						ss = mLeft;
						mKey = mLeft.getKey();
						mValue = mLeft.getValue();
						mRight = mLeft.mRight;
						mLeft = mLeft.mLeft;
					}
					else if (mLeft == null && mRight != null) {
						ss = mRight;
						mKey = mRight.getKey();
						mValue = mRight.getValue();
						mLeft = mRight.mLeft;
						mRight = mRight.mRight;
					}
					else {

					}

				}
				else if (compare < 0) {
					mLeft = mLeft.delete(key);
				}
				else if (compare > 0) {
					mRight = mRight.delete(key);
				}
			}
			return ss;

//			Node parent = this;
//			Node ss = new Node(null, null);
//			int compare = key.compareTo(mKey);
//			if (find(key) != null)
//				if (compare == 0) {
//					if (mLeft == null && mRight == null) {
//						parent.mLeft = null;
//						parent.mRight = null;
//						ss = null;
//						System.out.print(1);
//					}
//					else if (mLeft == null && mRight != null) {
//						System.out.print(parent);
//						parent.mRight = mRight;
//						ss = mRight;
//						System.out.print(2);
//						System.out.print(ss);
//					}
//					else if (mLeft != null && mRight == null) {
//						parent.mLeft = mLeft;
//						ss = mLeft;
//					}
//					else {
//						Node s = mRight.findMin();
//						mKey = s.getKey();
//						mValue = s.getValue();
//						if (s == mRight)
//							parent.mRight = s.mRight;
//						else
//							s.mLeft = s.mRight;
//						ss = s;
//					}
//				}
//				else if (compare < 0)
//					mLeft.delete(key);
//				else if (compare > 0) {
//					if (mLeft == null && mRight != null) {
//						Node parent2 = this;
//						System.out.print(parent);
//						System.out.println(0);
//						mRight.delete(key);
//					}
//					else if (mLeft == null && mRight == null)
//						this.delete(key);
//				}
//			return ss;
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
