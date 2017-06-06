package saksfifth.framework.utils;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class Helper {

    /**   delay for a certain time**/
    public static void delayFor(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
