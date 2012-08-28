package org.ethanfu.study;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConcurrentCalculator {
	private ExecutorService exec;
	private CompletionService<Long> completionService;
	private int cpuCoreNumber;

	class SumCalculator implements Callable<Long> {
		private int[] numbers;
		private int start;
		private int end;

		public SumCalculator(final int[] numbers, int start, int end) {
			this.numbers = numbers;
			this.start = start;
			this.end = end;
		}

		public Long call() throws Exception {
			Long sum = 0l;
			for (int i = start; i < end; i++) {
				sum += numbers[i];
			}
			System.out.println("22233332");
			if (sum == 45){
				System.out.println("2222");
				Thread.sleep(5000);
			}
			return sum;
		}

	}

	public ConcurrentCalculator() {
		cpuCoreNumber = Runtime.getRuntime().availableProcessors();
		exec = Executors.newFixedThreadPool(cpuCoreNumber);
		completionService = new ExecutorCompletionService<Long>(exec);
	}

	public Long sum(final int[] numbers) {
		for (int i = 0; i < cpuCoreNumber; i++) {
			int increment = numbers.length / cpuCoreNumber + 1;
			int start = increment * i;
			int end = increment * i + increment;
			if (end > numbers.length)
				end = numbers.length;
			SumCalculator subCalc = new SumCalculator(numbers, start, end);
			if (!exec.isShutdown()) {
				completionService.submit(subCalc);
			}
		}

		return getResult();
	}

	public Long getResult() {
		Long result = 0l;
		for (int i = 0; i < cpuCoreNumber; i++) {
			try {
				Long subSum;
				subSum = completionService.take().get(2, TimeUnit.MILLISECONDS);
				result += subSum;

			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				System.out.println("ggggg");
				e.printStackTrace();
			}
		}

		return result;
	}

	public void close() {
		exec.shutdown();
	}

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 34 };
		ConcurrentCalculator calc = new ConcurrentCalculator();
		Long sum = calc.sum(numbers);
		System.out.println(sum);
		calc.close();

		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
		Runnable pinger = new Runnable() {
			public void run() {
				System.out.println("PING!");
			}
		};

		// ses.scheduleAtFixedRate(pinger, 5, 5, TimeUnit.SECONDS);
	}
}
