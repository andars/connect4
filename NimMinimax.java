public class NimMinimax
{
    public static void main(String args[]) {
        NimNode root = new NimNode(0, true);
        System.out.println("Add 1: " + root.n1.value);
        System.out.println("Add 2: " + root.n2.value);
        
        printTree(root);
        System.out.println(root.value);
    }
    
    public static void printTree(NimNode n) {
        if (n.n1 == null || n.n2 == null) return;
        String turn;
        if (n.turn)
            turn = "My turn";
        else
            turn = "Your turn";
            
        System.out.println("Add 1 (sum = " + n.sum + "," + turn + "): " + n.n1.value);
        System.out.println("Add 2 (sum = " + n.sum + "," + turn + "): " + n.n2.value);
        if (n.n1 != null) printTree(n.n1);
        if (n.n2 != null) printTree(n.n2);
    }
}
