package practice;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	private final int MAX_SIZE = 10;
	private Queue<Integer> q = new LinkedList<Integer>();
	
	class Producer implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			while(true) {
			if (q.size() == MAX_SIZE) {
				try {
					synchronized(this) {
						System.out.println("Producer waiting ...");
						while(true)
							this.wait();
					}
				} catch (InterruptedException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				synchronized(this) {
					int n = (int) Math.random()+10;
					System.out.println("Producer produced: " + n);
					q.add(n);
					notifyAll();
				}
			}
		}
		}
		
	}
	
	class Consumer implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			
			while(true) {
			if (q.isEmpty()) {
				try {
					synchronized(this) {
						System.out.println("Consumer waiting ...");
						this.wait();	
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			synchronized(this) {
				notifyAll();
				System.out.println("Consumer consumed: " + q.remove());
			}
		}
		}
	}
	
	public static void main(String [] args) {
		
		ProducerConsumer pc = new ProducerConsumer();
		
		new Thread(pc.new Producer()).start();
		new Thread(pc.new Consumer()).start();
	}
}
