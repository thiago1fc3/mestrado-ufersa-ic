package cap05.v2;

public class App {

    public static void main(String[] args) {

        int[][] board = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        var state = new State(board);

        var algorithm = new Minimax();

        state.move(algorithm.decision(new State(state.getBoard())), 1);
        state.move(new Action(1, 1), -1);
        state.move(algorithm.decision(new State(state.getBoard())), 1);
        state.move(new Action(0, 0), -1);
        state.move(algorithm.decision(new State(state.getBoard())), 1);
        state.move(new Action(0, 1), -1);
        state.move(algorithm.decision(new State(state.getBoard())), 1);

        state.print();

    }
}
