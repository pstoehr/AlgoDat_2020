public class First {
    
    public static void main(String args[])
    {
        SplayTree<Integer> complexTree = new SplayTree<Integer>();
        /*
        for (int n=0; n<16; n += 1)
        {
            complexTree.insertRec(n);
        }
        System.out.println(complexTree+"\n");
        
        System.out.println("To Node");
        complexTree.printWayToNode(15);
        System.out.println();

        System.out.println("From Node");
        complexTree.printWayBack(15);
        System.out.println();
        */
        // #####     #####     #####     #####     #####     #####
        int nodes[] = {40, 25, 72, 13, 30, 60, 76, 6, 17, 27, 34, 45, 66, 81, 1, 9, 19, 42, 52, 53, 7};
        complexTree = new SplayTree<Integer>();
        for (int v : nodes)
            complexTree.insertRec(v);
        System.out.println(complexTree+"\n");
        
        System.out.println("To Node");
        complexTree.printWayToNode(3);
        System.out.println();

        System.out.println("From Node");
        complexTree.printWayBack(3);
        System.out.println();

    }
}