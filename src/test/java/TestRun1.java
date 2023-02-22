import org.testng.annotations.Test;

/**
 * Author: dinudonney
 * Date: 22/02/23
 */
public class TestRun1 extends InitDriver {
    @Test
    public void test1() throws Exception {
        setDriver("chrome","https://www.google.com/");
        System.out.println("ThreadID: " +Thread.currentThread().getId()+ " TR1 + Chrome + Google");
        Thread.sleep(10000);
        closeBrowser();
    }
    @Test
    public void test2() throws Exception {
        setDriver("chrome","https://www.amazon.in/");
        System.out.println("ThreadID: " +Thread.currentThread().getId()+ " TR1 + Chrome + Amazon");
        Thread.sleep(10000);
        closeBrowser();
    }
    @Test
    public void test3() throws Exception {
        setDriver("firefox","https://www.myntra.com/");
        System.out.println("ThreadID: " +Thread.currentThread().getId()+ " TR1 + Firefox + Myntra");
        Thread.sleep(10000);
        closeBrowser();
    }
}
