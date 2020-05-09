package data_structure.linked_list;


public class Josepfu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CircleSingleLinkedList circleSingleLinkedList  = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);
		circleSingleLinkedList.showBoy();
		
	}


}

class CircleSingleLinkedList {
	private Boy first = new Boy(-1);
	public void addBoy(int nums) {
		if(nums < 1) {
			System.out.println("num值不正确");
		}
		
		Boy curBoy = first;
		//创建环形链表
		for (int i = 0; i < nums; i++) {
			//根据编号创建节点
			Boy boy = new Boy(i);
			if(i == 1) {
				first = boy;
				first.setNext(first);//构成环
				curBoy = first;
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}
	
	public void showBoy() {
		if(first == null) {
			System.out.println("null");
			return;
		}
		Boy curBoy = first;
		while(true) {
			System.out.printf("no : %d\n",curBoy.getNo());
			if(curBoy.getNext()==first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}
	
	public void countBoy(int startNo,int countNum,int nums) {
		if(first == null || startNo < 1 || startNo > nums) {
			System.out.println("参数输入有误!");
			return;
		}
		//创建辅助指针,帮助出圈
		Boy helper = first;
		while(true) {
			if(helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		for (int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		
	}
}

class Boy{
	int no;
	Boy next;
	public Boy(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
	
}


class Josepofu1 {
 
    private Boy first = null;
 
 
    public static void main(String[] args) {
        Josepofu1 circleLinkedList = new Josepofu1();
        circleLinkedList.addBoy(25);//这里数目可以自己定
        circleLinkedList.list();
        circleLinkedList.countBoy(1, 2, 25);//从第一个小孩开始报数，数2下，指针往后移动一位，圈里边有25个小孩
    }
 
 
    //添加小孩节点构成一个环形链表
    public void addBoy(int numi) {
        if (numi < 2) {//环形链表里边至少应该有两个值
            System.out.println("numi 值不正确");
        }
        //for 循环创建循环链表
 
        Boy curBoy = null; //辅助指针
 
        for (int i = 1; i <= numi; i++) {
            //根据编号创建一个小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.next = first;//构成环状
                curBoy = first;//辅助指针定义，为了后面的小孩出圈操作，指定头指针前的指针指向
            } else {
                curBoy.next = boy;
                boy.next = first;//这也是为了构成新节点和first节点的指针闭环
                curBoy = boy;//指针移动至下一个节点以便下一次新节点的前一个节点可以指向新节点
            }
        }
    }
 
 
    //根据用户的输入形成小孩出圈的顺序
 
    /**
     * @param startNo  //表示从第几个小孩还是数数
     * @param countNum // 表示数几下
     * @param nums     // 表示最初有多少个小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
        }
 
        Boy helper = first;
        // 创建一个辅助变量helper，事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }
 
        //小孩报数前先让，first and helper 移动k -1 次，以便确定从那个小孩开始报数
        for (int j = 0; j < startNo - 1; j++) {
            first = first.next;
            helper = helper.next;
        }
 
        //当小孩开始报数，让first 和 helper 指针同时移动m  - 1 次，然后出圈，
        while (true) {
            if (helper == first) {
                break;
            }
            //让first 和 helper 指针同时移动 countNum 次
            for (int j = 0; j < countNum - 1; j++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.printf("小孩%d出圈\n", first.no);
            /*指定小孩出圈，出圈小孩前一个小孩的指针指向出圈小孩的下一个小孩，并且指向出圈小孩的头指针指向下一个小孩*/
            first = first.next;
            helper.next = first;
        }
 
        System.out.printf("最后留在圈中的小孩为%d号", helper.no);
 
    }
 
 
    public void list() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("打印小孩编号=%d\n", curBoy.no);
            if (curBoy.next == first) {
                System.out.println("遍历完毕");
                break;
            }
 
            curBoy = curBoy.next;
        }
    }
 
 
}
 
