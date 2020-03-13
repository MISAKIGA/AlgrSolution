package homework;

public class TestTime {

	public static void main(String[] args) {
		
		Time time = new Time(23,59,59);
		time.printTime(Time.PRINT_12);
		
		Time time2 = new Time();
		time2.setHour(13);
		time2.setMinute(34);
		time2.setSecond(56);
		time2.printTime(Time.PRINT_24);
		
		Time time1 = new Time(11,58);
		time1.printTime(Time.PRINT_12);
		time.tick();
	}

}
