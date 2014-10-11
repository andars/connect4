public class Node{
    public GameBoard state;
    int turn;
    int value;
    
    public Node(GameBoard state, int turn, int depth) {
        this.state = state;
        this.turn = turn;
        if (depth == 0 || gameOver()) {
            this.value = evaluateState();
            return;
        } else if (turn == 0) {
            int max = 0;
            for (int col = 0; col<state.getWidth(); col++) {
                GameBoard copy = state.clone();
                
                Node n = new Node(copy.dropDisc(
            }
        }
        
        
        
    }
    
    public int evaluateState() {
        return Math.random() > 0.5 ? 0 : 1;
    }
    
    public boolean gameOver() {
        return false;
    }
}