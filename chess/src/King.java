import static java.lang.Math.abs;

public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (checkPos(toLine) && checkPos(toColumn)) {
            if (destinationSameTeam(chessBoard, toLine, toColumn)) {
                return false;
            }

            if ((line != toLine || column != toColumn) && abs(line - toLine) <= 1 && abs(column - toColumn) <= 1) {
                check = false;
                return true;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {

        /*  будет проверять, находится ли поле,
        на котором стоит король (или куда собирается пойти) под атакой.
        Если это так, то метод должен вернуть true, иначе — false. Это позволит нам проверять шахи.*/

        for (int l = 0; l <= 7; l++) {
            for (int c = 0; c <=7; c++) {
                // not a threat if the same team or an empty cell
                if (board.board[l][c] != null) {
                    if (!board.board[l][c].color.equals(getColor()) &&
                            board.board[l][c].canMoveToPosition(board, l, c, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

