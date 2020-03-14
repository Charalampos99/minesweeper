package Minesweeper;
import java.util.ArrayList;
import java.util.Random;

public class Table {
	private ArrayList<Integer> xCoordinate; //newwwwwwwwwww
	private ArrayList<Integer> yCoordinate; // newwwwwwwwww
	private int sizeTable;  
	private int countBomb;
	
	public Table(int sizeTable) {
		this.sizeTable=sizeTable;
		countBomb = sizeTable*sizeTable/3 ;
	}
	
	public int[][] calculateTable(){
		int[][] coordinates=getRandomCoordinatesBomb();
		int[][] resultTable = new int[sizeTable][sizeTable];
		int[][] midTable = new int[sizeTable+2][sizeTable+2];
		
		int coordinateX;
		int coordinateY;
		//input the bombs with -1 in the bigger size table midtable 
		for(int k=0;k<sizeTable;k++) {
			coordinateX=coordinates[0][k];
			coordinateY=coordinates[1][k];
			midTable[coordinateX+1][coordinateY+1]=-1;	
		}
		//calculate the elements of the table 
		for(int p=1; p<midTable.length-1; p++) {
			for(int j=1;j<midTable.length-1;j++) {
				if(midTable[p][j]!=-1) {
					for(int i=-1; i<=1 ; i++) {
						for(int f=-1 ; f<=1 ; f++) {
							if(midTable[p+i][j+f]==-1) {
								midTable[p][j]++;
								
							}
						}
					}
					
				}
			}
		}
		//return the elements to result table
		for(int p=1; p<midTable.length-1; p++) {
			for(int j=1;j<midTable.length-1;j++) {
				resultTable[p-1][j-1]=midTable[p][j];
			}
		}
		for(int p=0; p<2; p++) {
			for(int j=0;j<sizeTable;j++) {
				System.out.print(coordinates[p][j] +"      ");
			}
			System.out.println();
		}	
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		for(int p=0; p<resultTable.length; p++) {
			for(int j=0;j<resultTable.length;j++) {
				System.out.print(resultTable[p][j] +"      ");
			}
			System.out.println();
		}	
		return resultTable;
		
	}
	
	
	
	
	public int[][] getRandomCoordinatesBomb() {
		int randomNumbers[]=getRandomNumbersForBomb();
		int tableCoordinates[][]=new int[2][countBomb];
		int count=0;
		
		for(int i=0;i<countBomb;i++){  //change the sizeTableTable(private variable ) with randomNumbers.length
			int number=randomNumbers[i];
			int count1=1;
			int control = 0; 
			for(int j=0;j<sizeTable;j++){
				for(int k=0;k<sizeTable;k++) {
					if(count1==number) {
						tableCoordinates[0][i]=j;
						tableCoordinates[1][i]=k;
						control=1;
						break;
					}
					count1++;
				}
				//if control is 1() then stop the two loops to check all the table
				if(control==1) {
					break;
				}
			}
		}	
		return tableCoordinates;
	}
	
	
	public void check() {
		
	}
	
	
	//every unique number corresponds with coordinate of bomb
	//do it with array list
	public int[] getRandomNumbersForBomb() {
		Random random = new Random();
		int[] randomNumbers=new int[countBomb];
		int count=0;
		
		for(int i=0;i<randomNumbers.length;i++) {  
			int tempx = random.nextInt(sizeTable*sizeTable) + 1;
			for(int j=0 ;j<i;j++){									
				if(tempx==randomNumbers[j]) {			
					count++;
				}
			}
			if(count==0) {
				randomNumbers[i]=tempx;
			}
			else {
				i--;
				count=0;
			}
		}
		return randomNumbers;
	}
	
	
	
	public int getValueofBombs() {
		return countBomb;
	}
}
