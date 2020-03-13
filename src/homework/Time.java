package homework;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 表示一个时钟
 * @author MISAKIGA
 *
 */
public class Time {
	
	private int hour;
	private int minute;
	private int second;
	
	/**
	 * 设置为24小时制
	 */
	public final static int PRINT_24 = 8497865;
	/**
	 * 设置为12小时制
	 */
	public final static int PRINT_12 = 4254472;
	/**
	 * 模拟时钟走动
	 */
	public void tick() {
		Timer tick = new Timer();
		//tick.schedule(() ->{}, time);
		tick.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				setSecond(getSecond() + 1);
				printTime(Time.PRINT_12);
			}
		}, 1,1000);
	}
	/**
	 *  按照制定格式输出时间
	 * @param printCode 选择输出时间格式，调用Time.PRINT_24输出24小时制，PRINT_12输出12小时
	 */
	public void printTime(int printCode) {
		
		StringBuilder sBuilder = new StringBuilder();
		switch (printCode) {
		case PRINT_12:
			boolean judgeTime = getHour() > 12;
			
			sBuilder.append(judgeTime ? getHour() - 12 : getHour());
			sBuilder.append(":");
			sBuilder.append(getMinute());
			sBuilder.append(":");
			sBuilder.append(getSecond());
			sBuilder.append(judgeTime ? "PM" : "AM");
			
			System.out.println(sBuilder);
			break;
		case PRINT_24:
			sBuilder.append(getHour());
			sBuilder.append(":");
			sBuilder.append(getMinute());
			sBuilder.append(":");
			sBuilder.append(getSecond());
			
			System.out.println(sBuilder);
			break;

		default:
			System.out.println("调用错误!");
			break;
		}
	}
	
	public int getHour() {
		return hour;
	}
	/**
	 * 设置小时，如果输入大于23，则输出23，小于0，则输出0；
	 * @param hour 小时
	 */
	public void setHour(int hour) {
		this.hour = hour > 23 ? 0 : hour < 0 ? 0 : hour;
	}
	public int getMinute() {
		return minute;
	}
	/**
	 * 设置分钟，小于0分钟，存为0，大于60；例：126，则存2小时，6分钟。
	 * @param minute 分钟
	 */
	public void setMinute(int minute) {
		
		if(minute <= 0)
			this.minute = 0;
		else if(minute < 60)
			this.minute = minute;
		else 
		{
			setHour(this.hour + (minute /60));
			this.minute = minute %60;
		}
	}
	public int getSecond() {
		return second;
	}
	/**
	 * 设置秒数，小于0秒，存为0，大于60秒；例：126，则存2分钟，6秒。
	 * @param minute
	 */
	public void setSecond(int second) {
		
		if(second <= 0)
			this.second = 0;
		else if(second < 60)
			this.second = second;
		else 
		{
			setMinute(this.minute + (second /60));
			this.second = second %60;
		}
	}
	/**
	 * 初始化时间（24小时制）
	 * @param hour 小时
	 * @param minute 分钟
	 * @param second 秒
	 */
	public Time(int hour, int minute, int second) 
	{
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	/**
	 * 初始化时间（24小时制）
	 * @param hour 小时
	 * @param minute 分钟
	 */
	public Time(int hour, int minute) 
	{
		this(hour,minute,0);
	}
	/**
	 * 初始化时间（24小时制）
	 * @param hour 小时
	 */
	public Time(int hour)
	{
		this(hour,0,0);
	}
	/**
	 * 初始化时间（24小时制）
	 */
	public Time() { this(0, 0, 0);}
	
}
