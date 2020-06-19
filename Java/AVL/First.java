public class First {
    
    public static void main(String args[])
    {
        /*
        BST<Integer> l = new BST<Integer>();
        for (int i=0; i<5; i++)
            l.insert(i);
        System.out.println(l);
        
        int values[] = {3,1,4,0,2};
        BST<Integer> b = new BST<Integer>();
        for (int v : values)
            b.insert(v);
        System.out.println(b);

        BST<Integer> lr = new BST<Integer>();
        for (int i=0; i<5; i++)
            lr.insertRec(i);
        System.out.println(l);
        
        BST<Integer> br = new BST<Integer>();
        for (int v : values)
            br.insertRec(v);
        System.out.println(b);

        System.out.println(b.isIn(42));
        System.out.println(b.isIn(4));
        */
        System.out.println("<" + n.getValue() + ">");
        
        int complexContent[] = {50, 25, 12, 10, 17, 37, 32, 27, 33, 45, 75, 87};
        AVLTree<Integer> complexTree = new AVLTree<Integer>();
        for (int v : complexContent)
            complexTree.insertRec(v);
        System.out.println(complexTree);
        complexTree.delete(25);
        System.out.println(complexTree);
    }
}