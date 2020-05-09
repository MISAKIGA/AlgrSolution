package homework.data_structure.graph;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import design_patterns.homework.reflect.Test;

public class Graph {

	@Test
	public static void main(String[] args) {
		
		//Class Test
		Graph graph = new Graph(9);
		graph.insertEdge(0, 1);
		graph.insertEdge(0, 2);
		graph.insertEdge(1, 3);
		graph.insertEdge(1, 4);
		graph.insertEdge(3, 7);
		graph.insertEdge(4, 7);
		graph.insertEdge(2, 5);
		graph.insertEdge(2, 6);
		graph.insertEdge(5, 6);

		Deque<Integer> dots = graph.adj(7);
		Iterator<Integer> iterator = dots.iterator();
		while(iterator.hasNext()) {
			//System.out.println("dots:" + dots.removeFirst());
			System.out.println("dots:" + iterator.next());
		}
		
		System.out.println("深度遍历");
		graph.dfs();
		
		System.out.println();
		System.out.println("广度遍历");
		graph.bfs();
	}
	
	//vertex 点数量
	private final int numOfVertex;
	//edge 边
	private int numOfEdge;
	//存储邻接表信息，一个链表代表一个顶点
	private Deque<Integer>[] adj;
	
	public Graph(int V) {
		//初始化顶点数量
		this.numOfVertex = V;
		//初始化边的数量
		this.numOfEdge = 0;
		//初始化具有v个顶点的邻接表
		this.adj = new LinkedList[V];
		//初始化领接表中的空队列
		for(int i = 0;i < adj.length;i ++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	Deque<Integer> waitSearch;
	int count;
	
	//广度遍历
	public void bfs() {
		boolean[] flag = new boolean[numOfVertex];
		waitSearch = new LinkedList<Integer>();
		count = 0;
		for(int i = 0; i < adj.length; i++) {
			if(! flag[i]) {
				bfs(i,flag);
			}
		}
	}
	
	private void bfs(int v, boolean[] flag) {
		
		//1. 输出当前信息；标记
		//2. 把当前顶点放入队列中；
		//3. 使用while循环从队列中取出待搜索的节点wait，进行搜索邻接表
		//4. 遍历wait节点邻接表，得到每一个顶点w
		//5. 如果当前顶点w未被搜索，则递归搜索与w顶点相通的其他顶点
		System.out.print(v + "->");
		flag[v] = true;
		waitSearch.addLast(v);
		while(!waitSearch.isEmpty()) {
			Integer wait = waitSearch.removeFirst();
			for(Integer w : adj[wait]) {
				if(! flag[w]) {
					bfs(w,flag);
				}
			}
		}
		//相通的顶点数量
		count++;
	}
	//深度遍历
	public void dfs() {
		count = 0;
		boolean[] flag = new boolean[numOfVertex];
		for (int i = 0; i < adj.length; i++) {
			if(!flag[i]) {
				dfs(i, flag);
			}
		}
	}
	
	private void dfs(int v,boolean[] flag) {
		//1.输出当前节点信息;标记已被搜索0
		//2. 获取当前节点的下的所有邻近节点
		//3. 如果该邻接点未被标记，则使用该邻接点继续递归搜索，下一个邻接点。
		System.out.print(v + "->");
		flag[v] = true;
		for(Integer w : adj[v]) {
			if(! flag[w]) {
				dfs(w,flag);
			}
		}
		//相通的顶点数量
		count++;
	}
	//返回当前顶点数量
	public int V() {
		return numOfVertex;
	}

	//返回当前图边的总数
	public int numOfEdge() {
		return numOfEdge;
	}
	
	//添加一条边，v -> w. w：v的目标邻近顶点
	public void insertEdge(int v, int w) {
		adj[v].offerLast(w);
		//把v添加到w的链表中，这样w就多了一个相邻点v
		adj[w].offerLast(v);
		numOfEdge++;
	}

	//获取和顶点v相邻的所有顶点(v 顶点下的链表信息)
	public Deque<Integer> adj(int v){
		return adj[v];
	}
	
/**
 * eror
 */
	//深度遍历
	public void dfs1() {
		boolean[] flag = new boolean[adj.length];
		int count = 0;
		//遍历所有顶点
		for(int i = 0;i < adj.length;i++) {
			dfs1(flag, i, count);
		}
	}
	
	public void dfs1(boolean[] flag, int v ,int count) {
		//递归思路
		//初始化标记
		//1. 访问顶点；标记该顶点已访问；
		//2. 查找下一个邻接点 w = getNext（v）；
		//3. w存在循环遍历 
		//4. 如果w未被访问 从顶点w出发递归执行该算法 dfs（flag,w）
		//5. w = 顶点v的下一个邻接点
		System.out.print(v + "->");
		flag[v] = true;
		int w = getFirstNeighbor(v);
		while(w != -1) {
			if(! flag[w]) {
				dfs1(flag, w, count++);
			}
			w = getNextNeighbor(w,v);
		}
	}
	
	public int getNextNeighbor(int v1,int v2) {
		
		int t = -1;
		Iterator<Integer> iterator = adj[v1].iterator();
		while(iterator.hasNext()) {
			int t1 = iterator.next();
			if(t1 != v2) {
				t = t1;
			}
		}
		return t;
	}
	
	public int getFirstNeighbor(int v) {
		if(adj.length > v && adj[v] != null) {
			return adj[v].peek(); 
		}
		return -1;
	}
 }
