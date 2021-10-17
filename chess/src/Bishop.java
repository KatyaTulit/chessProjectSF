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
            return (abs(line - toLine) == abs(column - toColumn)) && line != toLine && column != toColumn;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}

