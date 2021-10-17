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
            // diagonal
            if ((abs(line - toLine) == abs(column - toColumn)) && line != toLine && column != toColumn) {
                return true;
            // straight
            } else return (abs(line - toLine) > 0 && column == toColumn) || (abs(column - toColumn) > 0 && line == toLine);
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}

