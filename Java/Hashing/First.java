public class First {
    
    public static void main(String args[])
    {
        Hashing<String> h = new Hashing<String>(53);
        Minions m = new Minions();
        
        for (int i=0; i<m.count(); i++)
            h.add(m.nameFor(i));
        
        System.out.println(h);        
    }
}