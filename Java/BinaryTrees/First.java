
public class First {
    BinaryNode<Integer> createTree()
    {
        BinaryNode<Integer> zero = new BinaryNode<Integer>(0);
        BinaryNode<Integer> one = new BinaryNode<Integer>(1);
        BinaryNode<Integer> five = new BinaryNode<Integer>(5);
        BinaryNode<Integer> seven = new BinaryNode<Integer>(7);
        BinaryNode<Integer> eight = new BinaryNode<Integer>(8);
        BinaryNode<Integer> nine = new BinaryNode<Integer>(9);
    
        seven.leftChild = one;
        seven.rightChild = nine;
        nine.leftChild = eight;
        one.leftChild = zero;
        one.rightChild = five;
    
        return seven;
    }
    
    static public void main(String args[])
    {
        First treeController = new First();
        BinaryNode<Integer> root = treeController.createTree();
        System.out.println(root);
        
        System.out.println(root.hoehe());
    }
}