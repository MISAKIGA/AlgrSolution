package thread.threadExecutorPool;

import java.util.Random;
import java.util.concurrent.Callable;

public class SumTestBean implements Callable<Integer>{

	
	
	private volatile Integer start;
	private volatile Integer end;
	private volatile Integer result;	
	
	public SumTestBean(Integer start, Integer end) {
		this.start = start;
		this.end = end;
		this.result = this.start;
	}

	@Override
	public Integer call() throws Exception {

		for (int i = this.start + 1; i < this.end; i++) {
			
			result = result + i;    
	 	}
		
		Thread.sleep(new Random().nextInt(1000));
		System.out.printf(":%s:%d\n",Thread.currentThread().getName(),result);
		
		return result;
	}

}
