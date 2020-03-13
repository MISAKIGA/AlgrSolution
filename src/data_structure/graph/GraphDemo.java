package data_structure.graph;

import java.util.Scanner;


public class GraphDemo {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

		
		GraphMatrix gMatrix = new GraphMatrix();
		
		System.out.println("Enter generation graph type:");
		gMatrix.graphType = input.nextInt();				//图的种类
		
		System.out.println("Enter the number of vertices:");
		gMatrix.vertexNum =  input.nextInt();				//输入图顶点数 
		
		System.out.println("Enter the number of edge:");
		gMatrix.edgeNum = input.nextInt();					//输入图边数
		
		GraphOperation gOperation = new GraphOperation();
				
		gOperation.ClearGraph(gMatrix);						//清空图
		gOperation.CreateGraph(gMatrix);					//生成邻接表结构的图
		
		System.out.println("The adjacency matrix dataof themodified image is as follows:");
		
		gOperation.OutGraph(gMatrix);						//输出邻接矩阵	
		gOperation.DeepTraGraph(gMatrix);					//深度优先搜索遍历图
	}

}



class GraphOperation{
	
	Scanner input = new Scanner(System.in);
	
	/**
	 * 深度优化遍历
	 * @param gm
	 */
	void DeepTraGraph(GraphMatrix gm) {
		
		int i;
		
		for (i = 0; i < gm.vertexNum; i++) {		//清除各顶点遍历标志
			gm.isTrav[i] = 0;
		}
		
		System.out.println("Depth-first traversal node:");
		for (i = 0; i < gm.vertexNum; i++) {
			if(gm.isTrav[i] == 0 ) {				//若该节点未遍历
				DeepTraOne(gm, i);					//调用函数遍历
			}
		}
		System.out.println();
	}
	
	/**
	 * 从第N个顶点开始，深度遍历图
	 * @param gm
	 * @param n
	 */
	protected void DeepTraOne(GraphMatrix gm,int n) {
		int i;
		gm.isTrav[n] = 1;							//标记该顶点已处理过
		System.out.printf("->%c",gm.vertex[n]);		//输出节点数据
		
		for (i = 0; i < gm.vertexNum; i++) {		//添加处理节点的操作
			if((gm.edgeWeight[n][i] != GraphMatrix.MAXVALUE) && (gm.isTrav[n] == 0)) {
				DeepTraOne(gm, i);					//递归进行遍历
			}
		}
	}
	
	/**
	 * 输出邻接矩阵
	 * @param gm
	 */
	void OutGraph(GraphMatrix gm) 
	{
		int i,j;
		
		System.out.printf("\t");;
		for (j = 0; j < gm.vertexNum; j++) 
		{
			System.out.printf("\t%c",gm.vertex[j]);	//在第一行输出顶点信息
		}
		System.out.println();
		for (i = 0; i < gm.vertexNum; i++) 
		{						//输出邻接矩阵
			System.out.printf("\t%c", gm.vertex[i]);
			for (j = 0; j < gm.vertexNum; j++) 
			{
				if(gm.edgeWeight[i][j] == GraphMatrix.MAXVALUE) 	//若权值为最大值，则 用 Z 表示无穷大
				{
					System.out.printf("\tZ");
				}
				else
				{
					System.out.printf("\t%d",gm.edgeWeight[i][j]);	//输出边的权值
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * 清空图
	 * @param gm
	 */
	void ClearGraph(GraphMatrix gm) {
		int i,j;
		
		for(i = 0;i < gm.vertexNum;i++) {					//清空矩阵
			for(j = 0;j < gm.vertexNum;j++) {
				gm.edgeWeight[i][j] = GraphMatrix.MAXVALUE;	//设置矩阵中各元素的值为MaxValue
			}
		}
	}
	
	/**
	 * 创建邻接矩阵图
	 * @param gm
	 */
	void CreateGraph(GraphMatrix gm) {
		int i,j,k;
		int weight;				//权
		char eSTARTv,eENDv;		//边的起始点
		
		System.out.println("Enter graph all vertex infomation:");
		for (i = 0; i < gm.vertexNum; i++) {					//输入顶点
			System.out.printf("%dth vertex:",i + 1);
			gm.vertex[i] = (input.next().toCharArray())[0];		//保存到各项顶点数组元素中
		}
		
		System.out.println("Enter the vertices and weights that make up each side:");
		for (k = 0; k < gm.edgeNum; k++) {						//输入边信息
			System.out.printf("%dth edge:",k + 1);
			eSTARTv = input.next().charAt(0);
			eENDv = input.next().charAt(0);
			weight = input.nextInt();
			
			for (i = 0; eSTARTv != gm.vertex[i]; i++);			//在已有的顶点里查找始点
			for (j = 0; eENDv != gm.vertex[j];j++);				//在已有的顶点里查找终点
			
			gm.edgeWeight[i][j]= weight;						//对应位置存储 权 值，表示有一条边。 
			if(gm.graphType == 0) {								//若是无向图，则将权值存在对角位置。
				gm.edgeWeight[j][i] = weight;  
			}
		}
	}
}

/**
 * 定义邻接矩阵结构
 * @author MISAKIGA
 *
 */
class GraphMatrix{
	
	/**
	 * 图的最大顶点数
	 */
	static final int MAXNUM = 20;					
	/**
	 * 最大值（可设为最大整数） 
	 */
	static final int MAXVALUE = 65535;				
	
	/**
	 * 保存顶点信息 
	 */
	char[] vertex = new char[MAXNUM];				
	/**
	 * 图的类型，（0:无向图,1:有向图)
	 */
	int graphType;							
	/**
	 * 顶点的数量 
	 */
	int vertexNum;	
	/**
	 * 保存边的数量 
	 */
	int edgeNum;									
	/**
	 * 保存边的权（weight） 
	 */
	int[][] edgeWeight = new int[MAXNUM][MAXNUM];	
	/**
	 * 遍历标志
	 */
	int[] isTrav = new int[MAXNUM];					
}