public class First {
    
    public static void main(String args[])
    {
        // Fur Test mit Internet-Seite aus dem Skript
        SplayTree<Integer> complexTree = new SplayTree<Integer>();
        for (int n=0; n<42; n += 1)
        {
            complexTree.insertRec(n);
        }
        complexTree.isIn(41);
        
        System.out.println(complexTree+"\n");
        
        // Baum aus Frankfurt
        // https://www.informatik.fb2.frankfurt-university.de/~aberndt/algorithmen/Uebung/uebung4loesung.pdf
        int nodes[] = {40, 25, 72, 13, 30, 60, 76, 6, 17, 27, 34, 45, 66, 81, 1, 9, 19, 42, 52, 53, 7};
        SplayTree<Integer> frankfurt = new SplayTree<Integer>();
        for (int v : nodes)
            frankfurt.insertRec(v);
        System.out.println(frankfurt+"\n");

        SplayTree<Integer> splayFrankfurt = new SplayTree<Integer>();
        for (int v : nodes)
            splayFrankfurt.insert(v);
        System.out.println("Als SplayTree:");
        System.out.println(splayFrankfurt+"\n");
        
    }
}