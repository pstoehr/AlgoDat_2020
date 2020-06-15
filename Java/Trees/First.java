import java.util.function.Consumer;
import java.util.ArrayList;

public class First {

    public TreeNode<String> createTree()
    {
        TreeNode<String> beverages = new TreeNode<String>("Beverages");
        TreeNode<String> hot = new TreeNode<String>("Hot");
        
        TreeNode<String> tea = new TreeNode<String>("Tea");
        TreeNode<String> coffee = new TreeNode<String>("Coffee");
        TreeNode<String> chocolate = new TreeNode<String>("Chocolate");

        TreeNode<String> green = new TreeNode<String>("Green");
        TreeNode<String> black = new TreeNode<String>("Black");
        TreeNode<String> chai = new TreeNode<String>("Chai");


        TreeNode<String> cold = new TreeNode<String>("Cold");

        TreeNode<String> limo = new TreeNode<String>("Limo");
        TreeNode<String> milk = new TreeNode<String>("Milk");
        
        TreeNode<String> citrone = new TreeNode<String>("Citrone");
        TreeNode<String> orange = new TreeNode<String>("Orange");
        
        TreeNode<String> sweet = new TreeNode<String>("Sweet");
        TreeNode<String> sour = new TreeNode<String>("Sour");
        
        beverages.add(hot);
        hot.add(tea);
        hot.add(coffee);
        hot.add(chocolate);
        tea.add(green);
        tea.add(black);
        tea.add(chai);

        beverages.add(cold);
        cold.add(limo);
        cold.add(milk);
        limo.add(citrone);
        limo.add(orange);   
/*        
        citrone.add(sweet);
        citrone.add(sour);
*/
        return beverages; 
    }
    static public void main(String args[])
    {
        First treeController = new First();
        TreeNode<String> rootBeverages = treeController.createTree();
/*        rootBeverages.printByLevel();
        
        Consumer<TreeNode<String>> printNodeStr = a -> {System.out.print(a.getValue() + " ");};
        rootBeverages.breadthFirst(printNodeStr);
*/
        System.out.println("true --> " + rootBeverages.isIn("Tea"));
        System.out.println("false --> " + rootBeverages.isIn("Apple"));
    }
}