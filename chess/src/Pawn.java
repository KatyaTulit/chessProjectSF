public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (checkPos(toLine) && checkPos(toColumn) && column == toColumn) {

            if (destinationSameTeam(chessBoard, toLine, toColumn)) {
                return false;
            }

            if (color.equals("White")) {
                if (line == 1) {
                    return toLine - line == 1 || (toLine - line == 2 && chessBoard.board[line+1][column] == null);
                } else return toLine - line == 1;
            } else if (color.equals("Black")) {
                if (line == 6) {
                    return line - toLine == 1 || (line - toLine == 2 && chessBoard.board[line-1][column] == null);
                } else return line - toLine == 1;

            } else return false;

        } else return false;

    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
