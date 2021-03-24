package cap05.v2;

public class State {

    private int[][] board;

    public State(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {

//        int[][] b = new int[board.length][board.length];
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                b[i][j] = board[i][j];
//            }
//        }

        return board;
    }

    public void move(Action action, int player) {
        board[action.getI()][action.getJ()] = player;
    }

    public void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf(convert(board[i][j]) + " ");
            }
            System.out.println();
        }
    }

    private char convert(int value) {

        if (value == -1)
            return 'o';
        if (value == 1)
            return 'x';

        return '*';
    }
}
