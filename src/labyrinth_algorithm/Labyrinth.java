package labyrinth_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labyrinth {

	public static void main(String[] args) {

		RandMap map = new RandMap();
		map.printNumMap(map.createNumMap(10, 10));
		
		System.out.println("=========BMAP========");
		map.printNumMap(map.getBMap());
		
	}

}

class RandMap{
	
	private int wigth = 10;
	private int hight = 10;
	/**
	 * 未使用标志
	 */
	private final static int UNUSEDFLAG = -1;
	
	private static int[][] numMap;
	private static int[][] bMap;
	private static int[][] path;
	private Random rand = new Random();
	
	
	/**
	 * 创建 一个map
	 * @param wigth map 的宽度
	 * @param hight	map 的高度
	 * @return 一个随机生成的迷宫map
	 */
	public int[][] createNumMap(int wigth,int hight)
	{
		this.wigth = wigth--;
		this.hight = hight--;
		
		//初始化所有格子
		numMap = new int[this.hight][this.wigth];
		initMap();
		
		//生成迷宫路线
		randMap(wigth,hight,Directions.OTHER);
		
		//初始化寻路
		initBMap(hight + 1,wigth + 1);
		
		return numMap;
	}

	private void initBMap(int hight, int width) {
		
		bMap = new int[hight][width];
		
		for (int i = 0; i < hight; i++) {
			for (int j = 0; j < width; j++) {
				if(this.numMap[i][j] == UNUSEDFLAG)
					bMap[i][j] = 1;
				else
					bMap[i][j] = 0; 
			}
			
		}
		/*int x,y,z;
		
		for (int i = 0; i < hight; i++) {
			for (int j = 0; j < width; j++) {
				
				x = i * 3 + 1;
				y = j * 3 + 1;
				z = numMap[i][j];
				int[][] b = bm(z);
				//System.out.println("=== bm(z) ===x:" + x+":y:" + x+":z:" + z);
				//System.out.println(bMap[x][y]);
				//System.out.println("=== Lattice ===");
			
				 for (int k = 0; k < b.length; k++) { for (int k2 = 0; k2 < b.length; k2++) {
				 System.out.print(b[k][k2] + ","); } System.out.println(); }
				 
				
				bMap[x - 1][y - 1] = b[0][0];
				bMap[x + 1][y - 1] = b[2][0];
				bMap[x - 1][y + 1] = b[0][2];
				bMap[x + 1][y + 1] = b[2][2];
				bMap[x - 1][y] = b[0][1];
				bMap[x + 1][y] = b[2][1];
				bMap[x][y - 1] = b[1][0];
				bMap[x][y + 1] = b[1][2];
			}
		}*/
		path = bMap;
	}
	
	public int[][] bm(int x)
    {
        int[][] a = new int[3][3];

        switch (x)
        {
        	case -1:
        		a = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        		break;
            case 0:
                a = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
                break;
            case 1:
                a = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
                break;
            case 2:
                a = new int[][] { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 } };
                break;
            case 3:
                a = new int[][] { { 1, 0, 1 }, { 1, 0, 0 }, { 1, 1, 1 } };
                break;
            case 4:
                a = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
                break;
            case 5:
                a = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
                break;
            case 6:
                a = new int[][] { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 0, 1 } };
                break;
            case 7:
                a = new int[][] { { 1, 0, 1 }, { 1, 0, 0 }, { 1, 0, 1 } };
                break;
            case 8:
                a = new int[][] { { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 } };
                break;
            case 9:
                a = new int[][] { { 1, 0, 1 }, { 0, 0, 1 }, { 1, 1, 1 } };
                break;
            case 10:
                a = new int[][] { { 1, 1, 1 }, { 0, 0, 0 }, { 1, 1, 1 } };
                break;
            case 11:
                a = new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 1, 1 } };
                break;
            case 12:
                a = new int[][] { { 1, 1, 1 }, { 0, 0, 1 }, { 1, 0, 1 } };
                break;
            case 13:
                a = new int[][] { { 1, 0, 1 }, { 0, 0, 1 }, { 1, 0, 1 } };
                break;
            case 14:
                a = new int[][] { { 1, 1, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
                break;
            case 15:
                a = new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
                break;

        }

        return a;

    }

	static enum Directions{
		UP(1),RIGHT(2),DOWN(4),LEFT(8),OTHER(0);
		
		private int value;
		
		private Directions(Integer value) {
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	}
	
	private void randMap(int wigth,int hight,Directions status) {
		
		//存储方向
		List<Directions> directions = new ArrayList<>();
		directions.add(Directions.UP);//上
		directions.add(Directions.RIGHT);//右
		directions.add(Directions.DOWN);//下
		directions.add(Directions.LEFT);//左
		
		Directions oldDirectionStatus = Directions.OTHER;//前进（递归）之前的方向
		
		switch (status) {
			case UP:
				oldDirectionStatus = Directions.DOWN;
				break;
			case RIGHT:
				oldDirectionStatus = Directions.LEFT;
				break;
			case DOWN:
				oldDirectionStatus = Directions.UP;
				break;
			case LEFT:
				oldDirectionStatus = Directions.RIGHT;
				break;
		}
		
		numMap[hight][wigth] = oldDirectionStatus.value;
		
		//test
		//System.out.println("now i'm in that while outside point numMap data :" + numMap[hight][wigth] +":"+ oldDirectionStatus.name() +":"+ status.name());
		
		while (directions.size() > 0) {
			
			int w = wigth;
			int h = hight;
			int randDirection = rand.nextInt(directions.size());
			
			//随机获取下一个前进方向
			Directions nextDirection = directions.get(randDirection);
			
			//获取到要前进的方向后，进行移动
			switch (nextDirection) {
				case UP:
					h--;
					break;
				case RIGHT:
					w++;
					break;
				case DOWN:
					h++;
					break;
				case LEFT:
					w--;
					break;
			}
			//删除当前格子已使用的方向
			directions.remove(randDirection);

			if((h <= hight && w <= wigth) && (h >= 0 && w >= 0) && numMap[h][w] == UNUSEDFLAG) {
				
				//用于判断格子方向 
				numMap[hight][wigth] = nextDirection.value | oldDirectionStatus.value;
				System.out.println("XOR:" + numMap[hight][wigth] + "\tnext:" + nextDirection + "\toldDirS:" + oldDirectionStatus);
				System.err.println("now i'm int that while if inside point numMap data:" + numMap[hight][wigth]);
				
				//进行递归循环
				randMap(h, w, nextDirection);
			}
		}
		
		
	}

	/**
	 * 打印迷宫
	 */
	public void  printNumMap(int[][] numMap) {
		if(numMap == null)
			throw new RuntimeException("init map error,numMap is null!");
		
		//打印所有格子
		for(int i = 0;i < this.wigth;i ++) {
			for(int j = 0;j < this.hight;j ++) {
				
				//若是没有走过的格子，则输出墙
				//if(numMap[i][j] == UNUSEDFLAG)
					//System.out.print("1 , ");
				System.out.print(numMap[i][j] + "   ,   ");
				
				//走过的格子，则输出路
				//System.out.print("0 , ");
			}
			System.out.println();
		}
	}
	
	//初始化迷宫
	private int[][] initMap() {

		
		if(numMap == null)
			throw new RuntimeException("init map error,numMap is null!");
		
		//初始化所有格子为未使用状态
		for(int i = 0;i < this.wigth;i ++) {
			for(int j = 0;j < this.hight;j ++) {
				
				numMap[i][j] = UNUSEDFLAG;
			}
		}
		
		return numMap;
	}
	
	public int[][] getBMap(){
		return this.bMap;
	}
}