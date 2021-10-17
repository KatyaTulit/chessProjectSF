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

        if (checkPos(toLine) && checkPos(toColumn)) {
            if ((abs(line - toLine) > 0 && column == toColumn) || (abs(column - toColumn) > 0 && line == toLine)) {
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

