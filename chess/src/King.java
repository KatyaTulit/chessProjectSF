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

        return false;
    }
}

