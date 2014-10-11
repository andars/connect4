public class NimNode
{
    int sum;
    int value;
    NimNode n1, n2;
    boolean turn;
    public NimNode(int sum, boolean player) {
        this.sum = sum;
        turn = player;
        if (sum >= 20 && !player) {
            value = 1;
        } else if (sum >= 20 && player) {
            value = 0;
        } else if (player) {
             n1 = new NimNode(sum + 1, !player);
             n2 = new NimNode(sum + 2, !player);
        
            value = Math.max(n1.value, n2.value);
        } else {
             n1 = new NimNode(sum + 1, !player);
             n2 = new NimNode(sum + 2, !player);
        
            value = Math.min(n1.value, n2.value);
        }
    }
}
