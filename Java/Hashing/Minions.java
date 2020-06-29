import java.util.Random;

public class Minions {
    private String names[] = {
        "Barry", "Bob", "Brian", "Carl", "Charlie", "Chris", "Darwin",
        "Dave", "Donnie", "Donny", "Eric", "Henry", "Jerry", "John",
        "Jorge", "Ken", "Kevin", "Lance", "Larry", "Liam", "Mark", "Mel",
        "Mike", "Norbert", "Otto", "Paul", "Phil", "Stuart", "Tim", "Tom",
        "Tony"};
    private Random wuerfel = new Random();
        
    public String nameFor(int i)
    {
        if (i < names.length) return names[i]; else return null;
    }
       
    public int count() {
        return names.length;
    } 
    
    public String getAny()
    {
        return names[wuerfel.nextInt(names.length)];
    }
}