package cap05.v2;

import java.util.ArrayList;
import java.util.List;

public class Minimax {

    public Action decision(State state) {

        var actions = available(state);

        for (var a : actions) {

            state.move(a, 1);

            var r = min(state);

            if (r == 1) {
                return a;
            }
        }

        return new Action(1, 1);
    }


    private int max(State state) {

        if (isTerminal(state))
            return utility(state);

        var v = Integer.MIN_VALUE;

        for (var a : available(state)) {
            state.move(a, 1);
            v = Math.max(v, min(state));
        }

        return v;
    }

    private int min(State state) {

        if (isTerminal(state))
            return utility(state);

        var v = Integer.MAX_VALUE;

        for (var a : available(state)) {
            state.move(a, -1);
            v = Math.min(v, max(state));
        }

        return v;
    }

    private boolean isTerminal(State state) {
        return isWinner(state) || available(state).isEmpty();
    }

    private List<Action> available(State state) {
        var actions = new ArrayList<Action>();

        var board = state.getBoard();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    actions.add(new Action(i, j));
                }
            }
        }

        return actions;
    }

    private int utility(State state) {

        if (isWinner(state, -1))
            return -1;

        if (isWinner(state, 1))
            return 1;

        return 0;
    }

    private boolean isWinner(State state) {
        return isWinner(state, -1) || isWinner(state, 1);
    }

    private boolean isWinner(State state, int player) {

        var board = state.getBoard();

        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        return false;
    }

}
