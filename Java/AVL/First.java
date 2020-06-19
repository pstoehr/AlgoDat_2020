public class First {
    
    public static void main(String args[])
    {        
        int complexContent[] = {50, 25, 75, 37, 40};
        AVLTree<Integer> complexTree = new AVLTree<Integer>();
        for (int v : complexContent)
            complexTree.insertRec(v);
        System.out.println(complexTree);
        complexTree.leftRotation(complexTree.root);
        System.out.println(complexTree);
    }
}