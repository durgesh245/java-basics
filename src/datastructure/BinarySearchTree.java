package datastructure;

/*
BST -> Property -:
1. one parent node can have max 2 child node.  min node can be 0. Also possibility to have 1 child node.
2. In BST all the left node are less then root node and right child. All right node are greater then left child and root node.
3. Root node is greater then left node and less then child node.
4. We generally avoid to store duplicate values in CST but can be done by taking addition variable as count. We can also defined a formula to sent the duplicate value to
the left or right as per the pre-defined defination. Extraction will happen in te same way.
5. BST have 4 tppe of traversal
    a-> Pre-Order  -> Root-Left-Right
    b-> In-Order   -> Left-Root-Right -> This gives us the data in ascending order
    c-> Post-Order -> Right-Root-Left
    d-> Level Order -> Travers node at each level from Left to Right

6. Element search in BST generally have O(log N) complexity. Here N is total number of element.
 */

class TreeNode{
    private int value;
    private TreeNode leftChild;
    private TreeNode righChild;

    public TreeNode(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRighChild() {
        return righChild;
    }

    public void setRighChild(TreeNode righChild) {
        this.righChild = righChild;
    }

    public void insert(int value){
        //Not inserting the duplicate value
        if(this.value == value){
           return;
        }
        //Handling for left side if value is less
        if(this.value > value){
             if(this.leftChild == null){
                 this.leftChild = new TreeNode(value);
             }  else {
                 this.leftChild.insert(value); //Performing the nested operation for automatic traversal
             }
        }

        //Handling for right side if value is less
        if(this.value < value){
            if(this.righChild == null){
                this.righChild = new TreeNode(value);
            }  else {
                this.righChild.insert(value); //Performing the nested operation for automatic traversal
            }
        }
    }

    public void inOrderTraversal(){

        if(this.leftChild != null){
            this.leftChild.inOrderTraversal();
        }

        System.out.println("Value ->"+this.value);  // Ascending order

        if(this.righChild != null){
            this.righChild.inOrderTraversal();
        }
    }


    public TreeNode get(int val){
        if(this.value == val){
            System.out.println(this+"this val=>"+this.value);
            return this;
        }
       // System.out.println("After calling ");
        //Handling for left side if value is less
        if(this.value > val){
            if(this.leftChild != null){
                return this.leftChild.get(val); //Performing the nested operation for automatic traversal
            }
        }

        //Handling for right side if value is less
        if(this.value < val){
            if(this.righChild != null){
                return this.righChild.get(val); //Performing the nested operation for automatic traversal
            }
        }

        return null;
    }

    public TreeNode min(){
        if(this.leftChild != null)
            return leftChild.min();
        else
            return this;
    }

    public TreeNode max(){
        if(this.righChild != null)
            return righChild.max();
        else
            return this;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", righChild=" + righChild +
                '}';
    }
}

class Tree{
    private TreeNode root =null;

    public void insert(int value){
        if(root == null){
            root = new TreeNode(value);
        }else {
            root.insert(value);
        }
    }

    public void inOrderTraversal(){
        if(root != null){
            root.inOrderTraversal();
        }
    }

    public TreeNode get(int val){
        TreeNode treeNode = null;
        if(root == null){
            return treeNode;
        }else {
            treeNode =  root.get(val);
        }
        return treeNode;
    }

    public TreeNode min(){
        if(root != null)
            return root.min();

        return null;
    }
    public TreeNode max(){
        if(root != null)
            return root.max();

        return null;
    }

    public TreeNode delete(int value){
        return delete(root, value);
    }



    /*
    Writting  the delete case which is most completed piece here
    There could be three cases of deletion
    Case-1 -> Leaf node without any left or right child
    Case-2 -> Node with either a left child or a right child.
    Case-3 -> Node with both left child or a right child
            -> For case-3 we have to choose mechanism of Only left or Only right for the replacement
                If we are choosing only left then value should be highest in the left subtree.
                If we are choosing only right then value should be lowest in the right subtree.
     */

    public TreeNode delete(TreeNode subtree, int value){
        if(subtree == null){
            return subtree;
        }

        //Here we are performing the recursive replacement calling.
        if(value < subtree.getValue()){
            subtree.setLeftChild(delete(subtree.getLeftChild(), value));
        }
        else if (value > subtree.getValue()){
            subtree.setRighChild(delete(subtree.getRighChild(), value));
        }else {
            //Delete or replacement case started
            // Case-1 And Case-2
            if(subtree.getLeftChild() == null){
                return subtree.getRighChild();  // Replacing with right child. it can have value or can be null; handle both case-1 and case-2
            }else if(subtree.getRighChild() == null){
                return subtree.getLeftChild(); // Replacing with left child. it can have value or can be null; handle both case-1 and case-2
            }else {
                //Case-3   Going to use min function by traversing at right side. Means get value from parent or right child
                TreeNode maxValueNode =  subtree.getRighChild().max();
                //Replacing the subtree value with the largest value from the tree.
                subtree.setValue(maxValueNode.getValue());
                //Deleting the node from right child
                subtree.setRighChild(delete(subtree.getRighChild(), maxValueNode.getValue()));
            }

        }

        return subtree;
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        int[] input = {44, 23, -22, -1, 0, 22, 99, 100, 102};
        Tree t = new Tree();
        for (int i = 0 ; i < input.length; i++){
           // System.out.println(input[i]);
            t.insert(input[i]);
        }

        //In order traversal

        t.inOrderTraversal();

        // Get method
       // System.out.println(t.get(23));
       // System.out.println(t.get(155));

        System.out.println(t.max());
        System.out.println(t.min());

        //Delete cases
        t.delete(0);
        t.delete(-22);
        t.inOrderTraversal();
    }
}
