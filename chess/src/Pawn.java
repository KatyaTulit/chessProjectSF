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

        if (checkPos(toLine, toColumn) && column == toColumn) {

            if (destinationSameTeam(chessBoard, toLine, toColumn)) {
                return false;
            }

            int polarity = color.equals("White") ? 1 : -1;
            int lineStart = color.equals("White") ? 0 : 7;
            int distance = color.equals("White") ? toLine - line : line - toLine;

            if (line == lineStart + polarity) {
                return distance == 1 || (distance == 2 && chessBoard.board[line + polarity][column] == null);
            } else return distance == 1;

        } else return false;

    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
