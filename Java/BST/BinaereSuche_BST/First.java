public class First {
    
    public static void main(String args[])
    {
        int complexContent[] = {50, 25, 12, 10, 17, 37, 32, 27, 33, 45, 75, 87};
        BST<Integer> complexTree = new BST<Integer>();
        for (int v : complexContent)
            complexTree.insert(v);
        System.out.println(complexTree);
        complexTree.delete(25);
        System.out.println(complexTree);
    }
}