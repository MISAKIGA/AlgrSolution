package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class GraphList {

	private ArrayList<String> vertexList;
	private int[][] edges;
	private int numOfEdges;
	private boolean[] isVisited;
	
	public static void main(String[] args) {

		//String vertexValue[] = {"A","B","C","D","E"};
		String vertexValue[] = {"1","2","3","4","5","6","7","8","9"};
		GraphList graph = new GraphList(vertexValue.length);
		//添加节点
		for(String vertex : vertexValue) {
			graph.insertVertexs(vertex);
		}
		//添加边
		//A—B B-C B-C B-D B-e
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		graph.insertEdge(3, 7, 1);
		graph.insertEdge(4, 7, 1);
		graph.insertEdge(2, 5, 1);
		graph.insertEdge(2, 6, 1);
		graph.insertEdge(5, 6, 1);
		
		//显示矩阵
		graph.showGraph();
		
		System.out.println("深度遍历");
		graph.dfs();
		System.out.println();
		
		System.out.println("广度优先");
		graph.bfs();
	}
	
	public GraphList(int n) {
		//初始化矩阵和vertexList
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
	}
	
	//得到第一个领结点的下标
	/**
	 * 
	 * @param index
	 * @return 如果存在返回对应下标
	 */
	public int getFirstNeighbor(int index) {
		for(int j = 0; j< vertexList.size();j++) {
			if(edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	
	//根据前一个领接点下标获取下一个邻接点下标
	public int getNextNeighbor(int v1,int v2) 
	{
		for(int j = v2 + 1;j < vertexList.size();j++) {
			if(edges[v1][j] > 0 ) {
				return j;
			}
		}
		return -1;
	}
	
	//对一个节点进行广度优先遍历
	private void bfs(boolean[] isVisited,int i) {
		//表示队列头节点对应下标
		int u; 
		//邻接节点w
		int w;
		//队列，节点访问的顺序
		LinkedList queue = new LinkedList();
		//访问节点
		System.out.print(getValueByIndex(i) + "->");
		//标记
		isVisited[i] = true; 
		//将节点加入队列
		queue.addLast(i);
		
		while(! queue.isEmpty()) {
			//取出队列的头节点下标
			u = (Integer)queue.removeFirst();
			//得到第一个邻接点的下标
			w = getFirstNeighbor(u);
			while(w != -1) {
				if(!isVisited[w]) {
					System.out.print(getValueByIndex(w) + "->");
					isVisited[w] = true;
					//入队
					queue.addLast(w);
				}
				//以u为前驱点，找到w后面的下一个邻接点
				w = getNextNeighbor(u, w);
			}
		}
	}
	
	public void bfs() {
		isVisited = new boolean[getNumOfVertex()];
		for(int i = 0;i < getNumOfVertex();i++) {
			if(!isVisited[i]) {
				bfs(isVisited,i);
			}
		}
	}
	
	//深度优先算法
	private void dfs(boolean[] isVisited, int i) {
		
		//输出节点
		System.out.print(getValueByIndex(i) + "->");
		//标记已访问
		isVisited[i] = true;
		//查找节点i的邻接点
		int w = getFirstNeighbor(i);
		while(w != -1) {
			if(!isVisited[w]) {
				dfs(isVisited, w);
			}
			
			//如果w节点已被访问
			w = getNextNeighbor(i, w);
		}
	}
	
	//对dfs进行重载
	public void dfs() {
		isVisited = new boolean[getNumOfVertex()];
		for(int i = 0; i < getNumOfVertex(); i ++) {
			if(!isVisited[i]) {
				dfs(isVisited,i);
			}
		}
	}
	
	//显示图的矩阵
	public void showGraph() {
		for(int[] link : edges) {
			System.err.println(Arrays.toString(link));
		}
	}
	//插入节点
	public void insertVertexs(String vertex) {
		vertexList.add(vertex);
	}
	//返回节点个数
	public int getNumOfVertex() {
		return vertexList.size();
	}
	//边数
	public int getNumOfEdges() {
		return numOfEdges;
	}
	//返回节点i对应的数据
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	public int getWeight(int v1,int v2) {
		return edges[v1][v2];
	}
	//添加一条边
	/**
	 * 
	 * @param v1 表示点的下标
	 * @param v2 第二个顶点对应的下标
	 * @param weight 表示
	 */
	public void insertEdge(int v1,int v2,int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight; 
		numOfEdges++;
	}
}
