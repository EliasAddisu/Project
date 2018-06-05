import java.util.Timer;

public class NewsRequest{
    public static void main(String[] args) {
        Timer timer = new Timer();
        while (true){
            try {
                Thread.sleep(10000000);
                timer.schedule(new NewsLoader(),10000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
