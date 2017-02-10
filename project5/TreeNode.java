/**
 * Navin Abichandani
 * ID-110313627
 * Homework #5
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project5;
/**
 *This class is responsible for making the tree node object.
 */
public class TreeNode {
	/**
	 * Keywords is used to identify the node.
	 * Left refers to the left child of the node.
	 * Right refers to the right child of ther node.
	 */
	private String[] keywords;
	private TreeNode left;
	private TreeNode right;
	/**
	 * Creates a TreeNode
	 * @param keywords the words used to describe the node.
	 */
	public TreeNode(String[] keywords){
		this.keywords = keywords;
	}
	/**
	 * Gets keywords
	 * @return keywords
	 */
	public String[] getKeywords() {
		return keywords;
	}
	/**
	 * Sets keywords
	 * @param keywords words used to describe the cursor
	 */
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	/**
	 * Gets left node
	 * @return Left
	 */
	public TreeNode getLeft() {
		return left;
	}
	/**
	 * Sets left node
	 * @param left left child of the node
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	/**
	 * Gets right node
	 * @return Right
	 */
	public TreeNode getRight() {
		return right;
	}
	/**
	 * Sets right node
	 * @param right right child of the node 
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}
	/**
	 * Returns whether the node is a leaf
	 * @return the boolean on whether the node has children.
	 */
	public boolean isLeaf(){
		if(this.getRight() == null && this.getLeft() == null){
			return true;
		}
		return false;
	}
}
