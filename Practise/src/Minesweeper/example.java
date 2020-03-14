package Minesweeper;

public class example {
	
	public static void main(String[] args) {
		//System.out.println(Math.ceil));
		Table1 object = new Table1(4);
		object.calculateRandomCoordinatesBomb();
		//object.createTableWithBombsAndZerosAround();
		object.calculateTheElementsofTheTableWithZeros();
		object.getFinalTableWithoutZeros();
		//object.check();
		
		
	}

}
