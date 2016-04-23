package Chess;

public class PiecePosition {
    
	/**
         * Esta función te devuelve si la posición pasada con los parámetros
         * columna y fila está dentro de los límites del tablero.
         * @param column Columna de la posición
         * @param row Fila de la posición
         * @return true si es una posición válida, false en otro caso.
         */
	public static boolean isAvailable(int column, int row) {
		return column >= 0 && column < 8 && row >= 0 && row < 8;
	}

	/**
         * Esta función te devuelve si al incrementar la columna y la fila de 
         * la posición de una pieza, la nueva posición está dentro de los límites
         * del tablero.
         * @param position Posición actual de la pieza
         * @param columnIncrement Columna de la nueva posición
         * @param rowIncrement Fila de la nueva posición
         * @return true si la nueva posición está dentro de los límites del
         * tablero, false en otro caso.
         */
	static boolean isAvailable(PiecePosition position, int columnIncrement, int rowIncrement) {
		if (position == null)
			return false;
		
		int newColumn = position.getColumn() + columnIncrement;
		int newRow = position.getRow() + rowIncrement;
		return isAvailable(newColumn, newRow);
	}

	/**
         * A esta función se le pasa la posición de la pieza como parámetro y 
         * te devuelve si la columna y fila están dentro de los límites del 
         * tablero.
         * @param position Posición de la pieza
         * @return true si la ficha está dentro del tablero, false en otro caso.
         */
	static boolean isAvailable(PiecePosition position) {
		if (position == null)
			return false;
		return isAvailable(position.getColumn(), position.getRow());
	}

	private int column, row;

	/**
         * Esta función guarda la columna y la fila de la posición de la pieza.
         * @param column Columna de la pieza
         * @param row Fila de la pieza
         */
	public PiecePosition(int column, int row) {
		this.column = column;
		this.row = row;
	}
	
	/**
         * Esta función devuelve la columna de la posición de la pieza
         * @return 
         */
	public int getColumn() {
		return column;
	}

	/**
         * Esta función devuelve la fila de la posición de la pieza
         * @return 
         */
	public int getRow() {
		return row;
	}
	
        /**
         * Esta función intenta guardar la posición de una ficha pasada con 
         * los parámetros columna y fila
         * @param column
         * @param row
         * @return true si ha podido, false en otro caso.
         */
	public boolean setValues(int column, int row) {
		if (isAvailable(column, row)) {
			this.column = column;
			this.row = row;			
			return true;
		}
		return false;
	}
	
	/**
         * Dada una columna y una fila, esta función devuelve la nueva posición
         * de la pieza.
         * @param columnCount Cantidad de columnas a desplazar la pieza
         * @param rowCount Cantidad de filas a desplazar la pieza
         * @return 
         */
	public PiecePosition getDisplacedPiece(int columnCount, int rowCount) {		
		if (!isAvailable(this, columnCount, rowCount))
			return null;
		int newColumn = getColumn() + columnCount;
		int newRow = getRow() + rowCount;
		return new PiecePosition(newColumn, newRow);
	}
	
	/**
         * Esta función clona la posición de la pieza en la que estamos.
         * @return 
         */
	public PiecePosition clone() {
		return new PiecePosition(column, row);
	}
	
	/**
         * Dada una posición, esta función te devuelve si es la misma posición
         * de la pieza en la que estás.
         * @param aPosition Posición a comprobar si es la misma.
         * @return 
         */
	public boolean equals(PiecePosition aPosition) {
		return aPosition.getColumn() == getColumn() && aPosition.getRow() == getRow();
	}
}
