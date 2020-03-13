package thread.threadExecutorPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class SumTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
		
		List<Future<Integer>> resultList = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			 Future<Integer> result = executor.submit(new SumTestBean(i * 100 + 1,(i + 1) * 100));
			 resultList.add(result);
		}
		
		do {
			
			System.out.printf("Main: Done task: %d \n",executor.getCompletedTaskCount());
			for (int j = 0; j < resultList.size(); j++) {
				
				Future<Integer> result = resultList.get(j);
				System.out.printf("Main:Task %d: %s\n",j,result.isDone());
			}

			try {
				Thread.sleep(50);
			}catch (Exception e) {
			}
			
		}while(executor.getCompletedTaskCount() < resultList.size());
		
		int total = 0;
		for (int i = 0; i < resultList.size(); i++) {
			
			Future<Integer> result = resultList.get(i);
			total += result.get();
		}
		
		System.out.println("Sum = "+total);
	}

}
