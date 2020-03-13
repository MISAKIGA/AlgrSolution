package thread.threadForkJoin;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long>{

	private static final long serialVersionUID = -5704317324827167537L;
	public static final int THREAD_HOLD = 5;
	private int end;
	private int start;

	public SumTask(int start,int end) {
		this.start = start;
		this.end = end;
	}
	

	@Override
	protected Long compute() {
		
		Long sum = 0L;
		
		//if that task <= THREAD_HOLD so canCompute is ture
		boolean canCompute = (end - start) <= THREAD_HOLD;
		
		if(canCompute) {
			for(int i = start;i <= end; i++) {
				sum += i;
			}
		}else {
			
			//task > THREAD_HOLD,separate into two tasks.
			int middle = (end + start) / 2;
			SumTask subTask1 = new SumTask(start,middle);
			SumTask subTask2 = new SumTask(middle + 1,end);
			
			//subTask1.fork();subTask2.fork();
			
			invokeAll(subTask1,subTask2);
			
			Long sum1 = subTask1.join();
			Long sum2 = subTask2.join();
			
			sum = sum1 +sum2;
		}
		
		return sum;
	}
}
