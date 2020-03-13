package homework;

import java.util.Scanner;
import java.util.UUID;

/**
 * 借书卡，用于图书馆借书，内部有用户类结构与一些借书还书等操作
 * @author MISAKIGA hhx
 *
 */
public class DebitCard{
	
	//已借书数
	private Integer borrowed;
	//可借书数
	private Integer canBorrowed;
	//本次借出数
	private Integer bookBorrow;
	//本次还书数
	private Integer bookReturn;
	//是否已注册
	//private boolean isRegistered;
	
	/**
	 * 注册并指定该卡的借用次数
	 * @param user
	 */
	public DebitCard(int canBorrowed) {
		initCard(canBorrowed);
	}
	/**
	 * 初始化（注册）借书卡
	 *
	 */
	public DebitCard() {
		initCard(10);
	}
	/**
	 * 初始化数据
	 */
	private void initCard(int canBorrowed) {
		this.borrowed = 0;
		this.canBorrowed = 10;
		this.bookBorrow = 0;
		this.bookReturn = 0;
	}
	
	/**
	 * 借书
	 * @param bookNum 借书数
	 */
	public void bookBorrow(int bookNum) {
		
		if(canBorrowed > 0 && (canBorrowed - bookNum) >= 0) {
			
			canBorrowed -= bookNum;	//可借书减少
			borrowed += bookNum;	//已借书叠加
			bookBorrow = bookNum; //本次借出
			
			System.out.printf("本次借书：%d 本，可借书： %d 本，已借书: %d 本 \n",bookBorrow,canBorrowed,borrowed);
		}
		else
			System.out.println("借书量太多，请减少（本）：" + (canBorrowed - bookNum));
	}
	
	/**
	 * 还书
	 * @param bookNum 还书数
	 */
	public void bookReturn(int bookNum) {
		
		if((borrowed - bookNum) >= 0 && bookNum <= borrowed) {
			
			canBorrowed += bookNum;	//可借书增加
			borrowed -= bookNum;	//已借书减少
			bookReturn = bookNum; //本次还书
			
			System.out.printf("本次还书：%d 本，可借书： %d 本，已借书: %d 本 \n",bookReturn,canBorrowed,borrowed);
		}
		else
			System.out.println("你有借这么多书吗？");
	}
	/**
	 * 查询，该卡的状态
	 */
	public void queryCardStatus() {
		System.out.printf("当前卡可借书： %d 本，已借书: %d 本 \n",canBorrowed,borrowed);
	}
}

/**
 * 用户类
 * @author MISAKIGA hhx
 *
 */
class User{
	//账号
	private String id;
	//持卡人姓名
	private String name;
	//身份证号码
	private String identificaitonNumber;
	//地址
	private String address;
	//密码
	private String password;
	//令牌
	private String token;
	//借书卡
	private DebitCard debitCard;
	//控制台输入
	private static Scanner input = new Scanner(System.in);
	
	
	
	/**
	 *  注册用户并指定一张卡
	 * @param debitCard 指定的卡
	 */
	public User(DebitCard debitCard) {
		userRegistered(id, name, identificaitonNumber, address, password,debitCard);
	}
	
	/**
	 * 初始化注册用户
	 * @param id 账号
	 * @param name 姓名
	 * @param identificaitonNumber 身份证号
	 * @param address 地址
	 * @param password 密码
	 * @throws Exception 
	 */
	public User(String id, String name, String identificaitonNumber, String address,String password) throws Exception {
		userRegistered(id, name, identificaitonNumber, address, password,new DebitCard());
	}
	/**
	 * 从控制台输入数据注册用户和借书卡
	 */
	public User() {
		userRegistered();
	}
	
	public static boolean isIDNumber(String IDNumber) {
        if (IDNumber.trim() != "" && IDNumber.length() == 18) {
        	//TODO 正则判断是否是合法身份证号
            return true;
        }
        
        return false;
	}
	
	
	//注册用户
	private void userRegistered(String id, String name, String identificaitonNumber, String address,String password,DebitCard debitCard) {
		
		this.id = id;
		this.name = name;
		
		this.identificaitonNumber = identificaitonNumber;	
		this.address = address;
		//密码默为身份证后六位
		this.password = identificaitonNumber.substring(13, identificaitonNumber.length());
		
		this.debitCard = debitCard;
	}
	//注册用户
	private void userRegistered() {
			
		System.out.println("-----注册用户- - - - - -");
		
		System.out.println("请输入账号");
		String id = input.next();
		
		System.out.println("请输入姓名");
		String name = input.next();
		
		System.out.println("请输入身份证");
		String identificaitonNumber = input.next();
		for (;!User.isIDNumber(identificaitonNumber);) {
			System.out.println("请输入正确的身份证号！");
			identificaitonNumber = input.next();
		}
		
		System.out.println("请输入地址");
		String address = input.next();
		//如果用户为空，则注册一个用户。
		
		System.out.println("正在注册。。。");
		
		userRegistered(id, name, identificaitonNumber, address, address,new DebitCard());
		
		System.out.println("注册成功 ! 密码为身份证后六位");
		
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取令牌
	 * @return
	 */
	public String getToken() {
		if(token == null)
			token = UUID.randomUUID().toString();
		
		return this.token;
	}
	/**
	 * 刷新令牌
	 * @return
	 */
	public String refreshToken() {
		
		token = UUID.randomUUID().toString();
		return this.token;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentificaitonNumber() {
		return identificaitonNumber;
	}
	public void setIdentificaitonNumber(String identificaitonNumber) throws Exception {
		if(isIDNumber(identificaitonNumber))
			this.identificaitonNumber = identificaitonNumber;
		else {
			this.identificaitonNumber = "";
			throw new Exception("输入的身份证号格式错误！");
		}
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public DebitCard getDebitCard() {
		return this.debitCard;
	}
	
}
