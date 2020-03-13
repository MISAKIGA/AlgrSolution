package thread.threadForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class SumTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ForkJoinPool pool = new ForkJoinPool();
		
		//crate task
		SumTask task = new SumTask(1,90000);
		
		//Submit task
		ForkJoinTask<Long> result = pool.submit(task);
		
		do {
			System.out.printf("main:Thread Count:%d\n",pool.getActiveThreadCount());
			System.out.printf("main:Paralelism:%d\n",pool.getParallelism());
			
			try {
				Thread.sleep(50);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}while(!task.isDone());
		
		System.out.println(result.get().toString());
	}
}
