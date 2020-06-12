import java.util.function.Consumer;
import java.util.ArrayList;

public class PiController {

    TreeNode<Integer> createPiTree(int height)
    {
        PiHelper piSupplier = new PiHelper();
        TreeNode<Integer> root = new TreeNode<Integer>(piSupplier.getFirst());
        
        ArrayList<TreeNode<Integer>> queue = new ArrayList<TreeNode<Integer>>();
        int nextLevelCnt = 1;
        
        queue.add(root);
        
        for (int i=1; i<height; i++)
        {
            nextLevelCnt = piHelperLine(piSupplier, nextLevelCnt, queue);
        }
        return root;
    }
    
    private int piHelperLine(PiHelper piSupplier, int toBeHandled, ArrayList<TreeNode<Integer>> queue)
    {
        int nextChildCnt = 0;
        
        for (int i=0; i<toBeHandled; i+=1)
        {
            TreeNode<Integer> node = queue.remove(0);
            int childCnt = node.getValue();
            nextChildCnt += childCnt;
            
            for (int j=0; j<childCnt; j+=1)
            {
                int piValue = piSupplier.getNext();
                TreeNode<Integer> newNode = new TreeNode<Integer>(piValue);
                node.add(newNode); 
                queue.add(newNode);
            }
        }
        return nextChildCnt;
    }
    
    class PiHelper {
        int pi[] = {3,
                    1,4,1,5,9,2,6,5,3,5,
                    8,9,7,9,3,2,3,8,4,6, 
                    2,6,4,3,3,8,3,2,7,9, 
                    5,0,2,8,8,4,1,9,7,1, 
                    6,9,3,9,9,3,7,5,1,0, 
                    5,8,2,0,9,7,4,9,4,4, 
                    5,9,2,3,0,7,8,1,6,4, 
                    0,6,2,8,6,2,0,8,9,9, 
                    8,6,2,8,0,3,4,8,2,5, 
                    3,4,2,1,1,7,0,6,7,9,
                    8,2,1,4,8,0,8,6,5,1, 
                    3,2,8,2,3,0,6,6,4,7, 
                    0,9,3,8,4,4,6,0,9,5, 
                    5,0,5,8,2,2,3,1,7,2, 
                    5,3,5,9,4,0,8,1,2,8, 
                    4,8,1,1,1,7,4,5,0,2,
                    8,4,1,0,2,7,0,1,9,3,
                    8,5,2,1,1,0,5,5,5,9, 
                    6,4,4,6,2,2,9,4,8,9, 
                    5,4,9,3,0,3,8,1,9,6, 
                    4,4,2,8,8,1,0,9,7,5, 
                    6,6,5,9,3,3,4,4,6,1, 
                    2,8,4,7,5,6,4,8,2,3, 
                    3,7,8,6,7,8,3,1,6,5,
                    2,7,1,2,0,1,9,0,9,1};
                       
        int PiIdx = 0;
        
        int getFirst() {
            PiIdx = 0;
            return pi[PiIdx];
        }
        int getNext() {
            PiIdx += 1;
            return pi[PiIdx];
        }
    }
    
    static public void main(String args[])
    {
        PiController treeController = new PiController();
        TreeNode<Integer> rootPi = treeController.createPiTree(4);
        Consumer<TreeNode<Integer>> printNodeInt = a -> {System.out.println(a.getValue());};
        rootPi.printByLevel();       
    }
}