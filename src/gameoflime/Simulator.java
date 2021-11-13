
package gameoflime;

public class Simulator {
    
	 int numberOfSquares;
	   Cell[][] gridOfCells;
	   boolean running = false;
	   int countIteretion;

	   public Simulator(int numberOfSquares) {
	      this.numberOfSquares = numberOfSquares;
	      this.countIteretion = 0;
	      this.gridOfCells = new Cell[numberOfSquares][numberOfSquares];

	      for(int i = 0; i < this.numberOfSquares; ++i) {
	         for(int j = 0; j < this.numberOfSquares; ++j) {
	            this.gridOfCells[i][j] = new Cell(false);
	         }
	      }

	   }

	   public boolean isRunning() {
	      return this.running;
	   }

	   public void setRunning() {
	      this.running = true;
	   }

	   public void resetRunning() {
	      this.running = false;
	   }

	   public Cell getCell(int i, int j) {
	      return i >= 0 && i < this.numberOfSquares && j >= 0 && j < this.numberOfSquares ? this.gridOfCells[i][j] : null;
	   }

	   public int getNumberOfSquares() {
	      return this.numberOfSquares;
	   }

	   public void randomGridCell() {
	      double n = Math.random();

	      for(int i = 0; i < this.gridOfCells.length; ++i) {
	         for(int j = 0; j < this.gridOfCells.length; ++j) {
	            boolean f = Math.random() >= 0.5D;
	            this.gridOfCells[i][j].setState(f);
	         }
	      }

	   }

	   void setCellState(int i, int j) {
	      this.gridOfCells[i][j].setState(true);
	   }

	   void update() {
	      Cell[][] temp = new Cell[this.numberOfSquares][this.numberOfSquares];
	      if (this.running) {
	         ++this.countIteretion;

	         for(int i = 0; i < this.numberOfSquares; ++i) {
	            for(int j = 0; j < this.numberOfSquares; ++j) {
	               Cell currentCell = this.gridOfCells[i][j];
	               boolean f = this.stayAlive(currentCell.isAlive(), i, j);
	               temp[i][j] = new Cell(f);
	            }
	         }

	         this.gridOfCells = temp;
	      }
	   }

	   int countAliveNeigbors(int x, int y) {
	      int counter = 0;

	      for(int i = -1; i < 2; ++i) {
	         if (this.isCellAlive(x + i, y - 1)) {
	            ++counter;
	         }

	         if (this.isCellAlive(x + i, y + 1)) {
	            ++counter;
	         }
	      }

	      if (this.isCellAlive(x + 1, y)) {
	         ++counter;
	      }

	      if (this.isCellAlive(x - 1, y)) {
	         ++counter;
	      }

	      return counter;
	   }

	   boolean stayAlive(boolean isAlive, int x, int y) {
	      int count = this.countAliveNeigbors(x, y);
	      if (isAlive) {
	         if (count == 2 || count == 3) {
	            return true;
	         }
	      } else if (count == 3) {
	         return true;
	      }

	      return false;
	   }

	   boolean isCellAlive(int x, int y) {
	      Cell c = this.getCell(x, y);
	      return c != null && c.isAlive();
	   }

	   void resetAll() {
	      this.gridOfCells = new Cell[this.numberOfSquares][this.numberOfSquares];
	      this.countIteretion = 0;

	      for(int i = 0; i < this.numberOfSquares; ++i) {
	         for(int j = 0; j < this.numberOfSquares; ++j) {
	            this.gridOfCells[i][j] = new Cell(false);
	         }
	      }

	   }

	   public int getCountIteration() {
	      return this.countIteretion;
	   }
	}