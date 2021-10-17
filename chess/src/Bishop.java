import static java.lang.Math.abs;

public class Bishop extends ChessPiece{

    public Bishop(String color) {
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

            if ((abs(line - toLine) == abs(column - toColumn)) && line != toLine && column != toColumn) {
                for (int i = 1; i < abs(line - toLine); i++) {
                    int tempLine = line + (i * (int) Math.signum(toLine - line));
                    int tempColumn = column + (i * (int) Math.signum(toColumn - column));
                    if (chessBoard.board[tempLine][tempColumn] != null) {
                        return false;
                    }
                }
                return true;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}

