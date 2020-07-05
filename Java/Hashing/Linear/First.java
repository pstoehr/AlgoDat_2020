public class First {
    
    public static void main(String args[])
    {
        LinearHashing<MyNumber> h = new LinearHashing<MyNumber>(7);

        System.out.println(h.add(new MyNumber(78)));
        System.out.println(h.add(new MyNumber(57)));
        System.out.println(h.add(new MyNumber(80)));
        System.out.println(h.add(new MyNumber(23)));
        
        System.out.println(h);        

        System.out.println(h.isIn(new MyNumber(80)));

    }
}

