public class First {
    
    public static void main(String args[])
    {
        Hashing<String> h = new Hashing<String>(53);
        Minions m = new Minions();
        
        for (int i=0; i<m.count(); i++)
            h.add(m.nameFor(i));
        
        System.out.println("Peter " + h.delete("Peter") + "false");
        System.out.println("Kevin " + h.delete("Kevin") + "true");        

    }
}