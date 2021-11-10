public abstract class ChessPiece {
    protected String color;
    protected boolean check = true;

    protected ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    public boolean checkPos(int line, int column) {
        return line >= 0 && line <= 7 && column >= 0 && column <=7;
    }

    public boolean destinationSameTeam(ChessBoard chessBoard, int toLine, int toColumn) {
        return chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].color.equals(getColor());
    }

}
