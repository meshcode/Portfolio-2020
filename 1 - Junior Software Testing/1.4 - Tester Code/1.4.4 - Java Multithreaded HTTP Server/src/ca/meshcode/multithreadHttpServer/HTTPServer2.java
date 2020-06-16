package ca.meshcode.multithreadHttpServer;

//MMK
//win: CMD ipconfig to see my ip v4: ie 192.168.56.1:8088
//load in regular browser

//Example 5.14A Multithreaded HTTP Server
import java.io.*;
import java.net.*;

public class HTTPServer2 {
    public static void main(String args[]) {
        int port =8088;
        ServerSocket web;
        try {
            web = new ServerSocket(port);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return;
        }

        while(true){
            System.out.println("MultiThreaded Web Server Running on port: "+ port);
            try{
                Socket client = web.accept();
                System.out.println("Accepted Client : " + client);
                HTTPServer2Thread s = new HTTPServer2Thread(client);
                s.start();
            }
            catch(Exception e){
                System.out.println("Error: " + e);
                return;
            }
        }
    }
}
class HTTPServer2Thread extends Thread{
    Socket client;
    HTTPServer2Thread(Socket client){
        this.client = client;
    }
    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());

            String str = ".";
            while (!str.equals("")){
                str = in.readLine();
                System.out.println(": " +str);
            }
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Server: Java HTTP Server");
            out.println("");
            // Send the HTML page
            out.println("<H1>Hello World!</H1>");
            out.flush();
            out.close();
            client.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}