public class First {
    
    public static void main(String args[])
    {
        AVLTree<Integer> complexTree = new AVLTree<Integer>();
        complexTree.insertRec(3);
        complexTree.insertRec(3);
        complexTree.insertRec(4);
        
        System.out.println(complexTree+"\n");
    }
}