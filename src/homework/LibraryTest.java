package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryTest {

	public static void main(String[] args) {
		
		borrowingMchine();
		
		for (int i = 0; i < USERS.size(); i++) {
			
			String user_cardID = USERS.get(i);//模拟用户 i来借书
			
			User user = foxCard(user_cardID);
			System.out.println("=========用户来借书了============");
			System.out.println("你好，用户：" + user.getId());
			DebitCard user_cardData = user.getDebitCard(); 
			
			user_cardData.bookBorrow(6 + i);			//借书
			user_cardData.bookBorrow(2);
			user_cardData.bookReturn(4 + i);			//还书
			user_cardData.queryCardStatus();			//查询
		}
		
		System.out.println("=======无卡登录=========");
		User userNet = netLogin("hhxN2", "123456");
		if(userNet != null) {
			System.out.println("你好，用户：" + userNet.getId());
			DebitCard debitCard = userNet.getDebitCard();
			
			debitCard.queryCardStatus();			//查询
			debitCard.bookBorrow(3);			//借书
			debitCard.bookBorrow(3);
			debitCard.bookReturn(3);			//还书
			debitCard.queryCardStatus();			//查询
		}else {
			System.out.println("登录失败，用户名或密码错误!");
		}
		
		
	}
	//模拟用户的借书卡
	static List<String> USERS = new ArrayList<>();
	//数据库，保存用户信息
	static Map<String, User> DATA = new HashMap<>();
	//模拟插卡
	public static User foxCard(String uuid) {
		
		if(DATA.containsKey(uuid)) {
			return DATA.get(uuid);
		}
		
		System.out.println("无效卡");
		return null;
	}
	//模拟无卡登录
	public static User netLogin(String userId,String passwd) {
			
		for(Map.Entry<String, User> user: DATA.entrySet()) {
			User user1 = user.getValue();
			if(user1.getId().trim().equals(userId) && user1.getPassword().trim().equals(passwd)) {
				return user1;
			}
		}
		return null;

	}
	/**
	 *  模拟借书机注册
	 */
	public static void borrowingMchine() {
		
		
		User cUser = new User(); 
		DATA.put(cUser.getToken(), cUser); //保存数据
		USERS.add(cUser.getToken());//用户拿到了借书卡
		
		
		try {
			User dUser = new User("hhxN3", "hhx", "4481228199902034334", "广交",null);
			DATA.put(dUser.getToken(), dUser);
			USERS.add(dUser.getToken());
			
			User dUser01 = new User("hhxN2", "hhx", "4481228199902123456", "广交",null);
			DATA.put(dUser01.getToken(), dUser01);
			USERS.add(dUser01.getToken());
		} catch (Exception e) { 
			e.getMessage();
		}
		 
		
	}
}
