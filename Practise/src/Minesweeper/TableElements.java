package Minesweeper;

import java.util.ArrayList;
import java.util.Random;

public class TableElements {
	private ArrayList<Integer> xCoordinate; 
	private ArrayList<Integer> yCoordinate; 
	private int sizeTable;  
	private int countBomb;
	
	public TableElements(int sizeTable) {
		this.sizeTable=sizeTable;
		countBomb = sizeTable*sizeTable/3 -1;
	}
	
	
	
	public int[][] getFinalTableWithoutZeros(){
		int[][] tableWithZeros=calculateTheElementsofTheTableWithZeros();
		int[][] resultTable = new int[sizeTable][sizeTable];
		for(int p=1; p<tableWithZeros.length-1; p++) {
			for(int j=1;j<tableWithZeros.length-1;j++) {
				resultTable[p-1][j-1]=tableWithZeros[p][j];
			}
		}
		return resultTable;
	}
	
	private int[][] calculateTheElementsofTheTableWithZeros() {
		int tableWithZeros[][] = createTableWithBombsAndZerosAround();
		for(int p=1; p<tableWithZeros.length-1; p++) {
			for(int j=1;j<tableWithZeros.length-1;j++) {
				if(tableWithZeros[p][j]!=-1) {
					for(int i=-1; i<=1 ; i++) {
						for(int f=-1 ; f<=1 ; f++) {
							if(tableWithZeros[p+i][j+f]==-1) {
								tableWithZeros[p][j]++;	
							}
						}
					}
							
				}
			}
		}		
				return tableWithZeros;	
	}
	
	public int[][] createTableWithBombsAndZerosAround() {
		calculateRandomCoordinatesBomb();
		int[][] tableBombs = new int[sizeTable+2][sizeTable+2];
		int x ;
		int y;
		for(int i=0;i<countBomb;i++) {
			x=xCoordinate.get(i);
			y=yCoordinate.get(i);
			tableBombs[x+1][y+1]=-1;	
		}
		return tableBombs;
	}
	
	private void calculateRandomCoordinatesBomb(){
		xCoordinate = new ArrayList<Integer>();
		yCoordinate =new ArrayList<Integer>();
		ArrayList<Integer> randomNumbers =  getUniqueNumbersForBomb();
		for(int i=0;i<countBomb ; i++) {
			xCoordinate.add(((int)Math.ceil(((double)randomNumbers.get(i))/(double)sizeTable))-1); //
			if(randomNumbers.get(i)%sizeTable==0){
				yCoordinate.add(sizeTable-1);
			}else{
				yCoordinate.add(randomNumbers.get(i)%sizeTable -1);
			}
		}
	}
	
	private ArrayList<Integer> getUniqueNumbersForBomb(){
		ArrayList<Integer> uniqueNumbersForBomb = new ArrayList<Integer>();
		Random random = new Random();
		for(int i = 0; i < countBomb ; i++) {
			int tempx = random.nextInt(sizeTable*sizeTable) + 1;
			if(uniqueNumbersForBomb.contains(tempx)==true) {
				i--;
			}else {
				uniqueNumbersForBomb.add(tempx);
			}
		}
		return uniqueNumbersForBomb;	
	}
	
	public int getValueofBombs() {
		return countBomb;
	}

}
