public class First {
    
    public static void main(String args[])
    {
        BST<Integer> l = new BST<Integer>();
        for (int i=0; i<5; i++)
            l.insert(i);
        System.out.println(l);
        
        int values[] = {3,1,4,0,2};
        BST<Integer> b = new BST<Integer>();
        for (int v : values)
            b.insert(v);
        System.out.println(b);

        System.out.println();
        
        BST<Integer> lr = new BST<Integer>();
        for (int i=0; i<5; i++)
            lr.insertRec(i);
        System.out.println(lr);
        
        BST<Integer> br = new BST<Integer>();
        for (int v : values)
            br.insertRec(v);
        System.out.println(br);
        
        br.delete(1);
        System.out.println(br);
    }
}