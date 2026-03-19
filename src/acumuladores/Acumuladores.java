package acumuladores;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila 
	 * donde todos sus elementos sean múltiplos del número recibido por 
	 * parámetro.
	 * 
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 * 
	 * @param mat
	 * @param num
	 * @return
	 */
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) { 
		boolean acumulador = false;

		if ( estaVacia(mat) || esNegativo(num)) {
			return false;
		}

		for (int i=0; i<mat.length; i++) {
			acumulador = acumulador || filaConTodosElemMultiplos(mat[i], num);

			//agrego esta comprobacion solo para salir y no itere innecesariamente una vez haya encontrado una fila
			if (acumulador) {
				break;
			}
		}
		return acumulador;
	}

	public boolean filaConTodosElemMultiplos(int[] fila, int num) {
		boolean acumulador = true;
		for(int i=0; i<fila.length; i++) {
			acumulador = acumulador && esMultiplo(fila[i], num);
		}
		return acumulador;
	}

	public boolean estaVacia(int[][]mat) {
		return mat==null || mat.length == 0;
	}

	public boolean esNegativo(int num) {
		return num<=0;
	}

	public boolean esMultiplo(int num, int numrecibido) {
		return num % numrecibido == 0;
	}
	
	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 * 
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz 
	 * está vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) { 
		boolean acumulador=true;

		if ((estaVacia(mat1) || estaVacia(mat2)) || tienenDistintasDimensiones(mat1, mat2)) {
			return false;
		}

		for (int i=0; i< mat1.length; i++) {
			acumulador = acumulador && verificarInterseccion(mat1[i],mat2[i]);
		}

		if(!acumulador) {
			return false;
		}

        return acumulador;
	}


	public boolean tienenDistintasDimensiones(int[][]mat1, int[][]mat2) {
		return mat1.length != mat2.length;
	}

	public boolean sonNumIguales(int num1, int num2) {
		return num1==num2;
	}

	public boolean verificarInterseccion(int[]filamat1, int[]filamat2) {
		boolean acumulador = false;

		for (int i=0; i<filamat1.length; i++) {
			acumulador = acumulador || filaContieneNum(filamat2, filamat1[i]);
		}

		return acumulador;
	}

	public boolean filaContieneNum(int[]fila, int num) {
		boolean acumulador = false;
		for (int i=0; i<fila.length; i++) {
			acumulador = acumulador || sonNumIguales(fila[i], num);
		}
		return acumulador;
	}





	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna
	 * fila cuya suma de todos sus elementos sea mayor estricto que la suma de
	 * todos los elementos de la columna indicada por parámetro.
	 * 
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve 
	 * falso.
	 * 
	 * @param mat
	 * @param nColum
	 * @return
	 */
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) { 
		boolean acumulador = false;

		if(estaVacia(mat) || !esColumnaValida(mat, nColum)) {
			return false;
		}
		int sumaTotalCol = sumaTotalColumna(mat, nColum);


		for(int i=0; i<mat.length; i++) {
			acumulador = acumulador || (sumaTotalCol < sumaTotalFila(mat[i]));

			if (acumulador) {
				break;
			}
		}

		return acumulador;
	}

	public int sumaTotalColumna(int[][]mat, int nColumn) {
		int total=0;

		for (int fila=0; fila<mat.length; fila++) {
			total+=mat[fila][nColumn];
		}

		return total;
	}

	public int sumaTotalFila(int[]filamat) {
		int total=0;

		for (int i=0; i<filamat.length; i++) {
			total+=filamat[i];
		}
		return total;
	}

	public boolean esColumnaValida(int[][]mat, int nColumn) {
		return nColumn>=0 && nColumn<mat[0].length;
	}
	
	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de
	 * cada matriz, columna a columna.
	 * 
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz 
	 * está vacía, devuelve falso. 
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) { 
		boolean acumulador = true;
		if ((estaVacia(mat1) || estaVacia(mat2)) || tienenDistintasCantColum(mat1,mat2)) {
			return false;
		}

		for (int nCol=0; nCol<mat1[0].length; nCol++) {
			acumulador = acumulador && verificarInterseccionCol(mat1,mat2,nCol);
		}

		return acumulador;

	}

	public boolean verificarInterseccionCol(int[][]mat1, int[][]mat2, int nCol) {
		boolean acumulador = false;

		for (int fila=0; fila<mat1.length; fila++) {
			acumulador = acumulador || columnaContieneNum(mat2, nCol, mat1[fila][nCol]);

			if (acumulador) {
				break;
			}
		}
		return acumulador;
	}

	public boolean tienenDistintasCantColum(int[][]mat1, int[][]mat2) {
		return mat1[0].length != mat2[0].length;
	}

	public boolean columnaContieneNum(int[][]mat, int nCol, int num) {
		boolean acumulador = false;

		for (int fila=0; fila<mat.length; fila++) {
			acumulador = acumulador || sonNumIguales(mat[fila][nCol], num);

			if (acumulador) {
				break;
			}
		}

		return acumulador;
	}

}
