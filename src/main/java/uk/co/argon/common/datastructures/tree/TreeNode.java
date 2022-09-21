package uk.co.argon.common.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
	T data;
	List<TreeNode<T>> children;

	public TreeNode(T data) {
		this.data = data;
		this.children = new ArrayList<TreeNode<T>>();
	}
	
	public void addChild(TreeNode<T> node) {
		this.children.add(node);
	}
}
