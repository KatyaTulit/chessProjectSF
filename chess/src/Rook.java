import static java.lang.Math.abs;

public class Rook extends ChessPiece{

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (checkPos(toLine, toColumn)) {
            if (destinationSameTeam(chessBoard, toLine, toColumn)) {
                return false;
            }

            if (abs(line - toLine) > 0 && column == toColumn) { // down or up
                for (int i = line + 1; i < toLine; i++) {
                    if (chessBoard.board[i][toColumn] != null) {
                        return false;
                    }
                }
                check = false;
                return true;

            } else if (abs(column - toColumn) > 0 && line == toLine) { // left or right
                for (int i = column + 1; i < toColumn; i++) {
                    if (chessBoard.board[toLine][i] != null) {
                        return false;
                    }
                }
                check = false;
                return true;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}

