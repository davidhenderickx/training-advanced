package helper;

/**
 * Contains helper functionality regarding waiting and sleeping
 * 
 * @author dhenderickx
 *
 */
public class Waiter {
	
	/**
	 * Waits for 1000ms
	 */
	public void waitFor() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

}
