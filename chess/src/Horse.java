import static java.lang.Math.abs;

public class Horse extends ChessPiece{

    public Horse(String color) {
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

            return ((abs(line-toLine) == 2 && abs(column-toColumn) == 1) || (abs(line-toLine) == 1 && abs(column-toColumn) == 2));
        } else return false;

    }

    @Override
    public String getSymbol() {
        return "H";
    }
}

