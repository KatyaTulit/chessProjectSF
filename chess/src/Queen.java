import static java.lang.Math.abs;

public class Queen extends ChessPiece{

    public Queen(String color) {
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

            // diagonal
            if ((abs(line - toLine) == abs(column - toColumn)) && line != toLine && column != toColumn) {
                for (int i = 1; i < abs(line - toLine); i++) {
                    int tempLine = line + (i * (int) Math.signum(toLine - line));
                    int tempColumn = column + (i * (int) Math.signum(toColumn - column));
                    if (chessBoard.board[tempLine][tempColumn] != null) {
                        return false;
                    }
                }
                return true;
            // straight
            } else if (abs(line - toLine) > 0 && column == toColumn) { // down or up
                for (int i = line + 1; i < toLine; i++) {
                    if (chessBoard.board[i][toColumn] != null) {
                        return false;
                    }
                }
                return true;
            } else if (abs(column - toColumn) > 0 && line == toLine) { // left or right
                for (int i = column + 1; i < toColumn; i++) {
                    if (chessBoard.board[toLine][i] != null) {
                        return false;
                    }
                }
                return true;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}

