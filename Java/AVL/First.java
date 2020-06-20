public class First {
    
    public static void main(String args[])
    {
        AVLTree<Integer> complexTree = new AVLTree<Integer>();
        for (int n=0; n<16; n += 1)
        {
            complexTree.insertRec(n);
        }
        System.out.println(complexTree+"\n");
        complexTree.delete(7);
        System.out.println(complexTree+"\n");
    }
}