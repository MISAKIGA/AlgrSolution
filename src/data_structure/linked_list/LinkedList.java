package data_structure.linked_list;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Random;

import javax.xml.soap.Node;

import org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine;

	
public class LinkedList {
		
	public static void main(String[] args) {
		
		
		System.out.println("TEST DEMO");
	
		  CLType head = null,node; 
		  CLType CL = new CLType();
		  
		  String key,findKey; 

		  Random ran = new Random();
		  
		  for(int i = 0;i < 9;i ++) { 
			  
			  	
			  	  DATA2 nodeData = new DATA2(); 
			  	  
			  	  nodeData.key = String.valueOf(i); 
			  	  nodeData.name = "TEST NODE: " + i; 
			  	  nodeData.age = i + ran.nextInt(50);
			  	  
			  	 // System.out.println("" + nodeData.name + nodeData.age  +":"+ nodeData.key +  "head:");
			  	  
				  head = CL.CLAddEnd(head, nodeData);	//添加节点
			//	  System.out.println("head:" + i + "\t" + (head != null) + "\t" + "has next ?:" + (head != null ? head.nextNode != null : false));
		  }
		  
		  //System.out.println(head != null);
		  
		  CL.CLAllNode2(head);

		  //input node
		  System.out.println("\n======input node start ======");
		  findKey = (ran.nextInt(9)) + "";
		  
		  DATA2 nodeData = new DATA2();
		  nodeData.key = (Integer.parseInt(findKey) + 10) +  ""; 
		  nodeData.name = "TEST INSERT NODE: " + findKey;
		  nodeData.age = Integer.parseInt(findKey) + 10;
		  
		  head = CL.CLInsertNode(head, findKey, nodeData);	//插入链表节点
		  
		  System.out.println("=====input node result====");
		  CL.CLAllNode(head);
		  
		  System.out.println("\n=====search node start======");
		  key = (ran.nextInt(9)) + "";
		  
		  node = CL.CLQueryNode(head, key);
		  
		  if(node != null)
		  {
			  nodeData = node.nodeData;
			  System.out.printf("node search access!!! Result : Key %s show node (%s,%s,%d)\n", key,nodeData.key,nodeData.name,nodeData.age);
		  }
		  else
		  {
			  System.out.printf("linked not find the key %s nodes\n",key);
		  }
		  
		  System.out.println("\n====delete node start=====");
		  System.out.println("linked length:" + CL.CLLength(head));
		  
		  int result = CL.CLDeleteNode(head, key);
		  if(result == 1)
		  {
			  System.out.println("delete node:" + key + " access!!!  linked length:" + CL.CLLength(head));
			  CL.CLAllNode(head);
		  }
		  else
		  {
			  System.out.println("delete node failed!!！");
		  }
	}
	
}
	
	class DATA2
	{
		public DATA2() {
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * 链表的关键字
		 */
		String key;
		String name;
		int age;
	}
	
	class CLType
	{
		public CLType() {
			
		}
		
		/**
		 * 链表节点数据
		 */
		DATA2 nodeData = new DATA2();
		/**
		 * 指向下一节点的 指向头数据（指针）
		 */
		CLType nextNode;
		
		/**
		 * 新增链表节点
		 * @param head 		头
		 * @param nodeData 节点数据
		 * @return
		 */
		CLType CLAddEnd(CLType head,DATA2 nodeData) 
		{
			CLType node,htemp;
			if((node = new CLType()) == null) //申请分配内存
			{
				System.out.println("Failed to apply for memory!");
				return null;
			}
			else
				{
					node.nodeData = nodeData;	//保存数据
					node.nextNode=null;			//设置结点引用为空，即为表尾
				
					if(head == null)			//头引用
					{
						//System.out.println("CLADDEND return head ");
						head = node;
						return head;
					}
					
					htemp = head;
					while(htemp.nextNode != null)//查找链表未尾
					{
						htemp = htemp.nextNode;
					}
					
					//System.out.println("CLADDEND return head and next node");
					htemp.nextNode = node;
					
					return head;
				}
		}
		
		CLType CLInsertFirst(CLType head,DATA2 nodeData)
		{
			CLType node;
			if((node =new CLType()) == null)//分配内存空间
			{
				System.out.println("Failed to apply for memory!");
				return null;
			}
			else
				{
					node.nodeData = nodeData;//存储数据
					node.nextNode = head;	 //指向头引用所指节点
					head = node;			 //头引用指向新增节点
					return head;
				}
		}
		
		/**
		 * 根据key查询链表中的数据节点
		 * @param head
		 * @param key
		 * @return
		 */
		CLType CLQueryNode(CLType head,String key)
		{
			CLType htemp;
			htemp = head;									//保存链表头引用
			while(htemp != null) {				  			//如果节点有效，则进行查询
				if(htemp.nodeData.key.compareTo(key) == 0)	//若节点关键字与传入的关键字相同
				{
					return htemp;							//返回该节点引用
				}
				htemp = htemp.nextNode;
			}
			return null;
		}
		
		/**
		 * 插入节点
		 * @param head		表头
		 * @param findKey	要插入的节点关键字
		 * @param nodeData	新节点数据
		 * @return			返回插入后的新表
		 */
		CLType CLInsertNode(CLType head,String findKey,DATA2 nodeData)
		{
			CLType node,htemp;
			if((node = new CLType()) == null)							//分配 内存空间
			{
				System.out.println("Failed to apply for memory!");
				return null;
			}
			node.nodeData = nodeData;									//保存数据
			htemp = CLQueryNode(head, findKey);							//根据key查询要插入的node
			if(htemp != null)					
			{
				node.nextNode = htemp.nextNode;							//若查到要插入的节点位置（htemp），将新节点的 nextNode 指针 指向 htemp的 nextNode。
				htemp.nextNode = node;									//将 htemp 的  nextNode 节点指向新的节点。 这样做的效果是将新节点插入到了 旧节点（htemp）的后面。
			}
			else														//若没有找到正确的节点位置
			{
				System.out.println("not find access for the key index");
			}
			return head;	
		}
		
		/**
		 * 删除节点
		 * @param head 节点指针头
		 * @param key  要删除的节点  key属性
		 * @return	删除成功返回 1，删除失败 返回 0
		 */
		int CLDeleteNode(CLType head,String key) 
		{
			CLType node,htemp;
			node = head;
			htemp = head;
			
			if(head == null || key.trim().isEmpty())
			{
				return 0;
			}
			
			while(node != null) 
			{
				if(node.nodeData.key.compareTo(key) == 0)
				{
					htemp.nextNode = node.nextNode;		//将要删除的（node）指向数据，赋给它的上一个节点 （htemp），使htemp的指向数据（指针）指向node的下一个节点。
					node = null;						//删除node节点数据	
					
					return 1;							//删除成功，返回1 
				}
				else
				{
					htemp = node;						//若没有找到 节点，则进行下一轮 查找。将当前节点移到下一节点 
					node = node.nextNode;
				}
			}
			
			return 0;
		}
		
		/**
		 * 计算链表长度
		 * @param head
		 * @return
		 */
		int CLLength(CLType head)
		{
			int len = 0;
			CLType htemp;
			htemp = head;
			 
			while(htemp != null)
			{
				len ++ ;
				htemp = htemp.nextNode;
			}
			
			return len;
		}
		
		/**
		 * 读取链表 数据
		 * @param head
		 */
		void CLAllNode(CLType head)
		{
			CLType htemp;
			DATA2 linkedData;
			
			htemp = head;
			while(htemp != null)
			{
				{//read data
					linkedData = htemp.nodeData;
					System.out.printf("NODE（%s,%s,%d）\n", linkedData.key,linkedData.name,linkedData.age);
				}
				
				htemp = htemp.nextNode;
			}
		}
		
		/**
		 * 递归实现 遍历链表
		 * @param head
		 * @return
		 */
		CLType CLAllNode2(CLType head)
		{
			
			if(head == null)
				return null;
			
			DATA2 linkedData = head.nodeData;
			System.out.printf("NODE （%s,%s,%d）\n", linkedData.key,linkedData.name,linkedData.age);
		
			
			return CLAllNode2(head.nextNode);
		}
	}
	

