package Lesson14.HomeWork.FirstTask;

import Lesson14.HomeWork.SecondTask.ClientServerApp;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by user on 29.08.16.
 */
public class TestClientServerApp {
    @Test
    public void TestThread(){
        ArrayBlockingQueue<ClientServerApp.Message> messageArrayBlockingQueue = new ArrayBlockingQueue<ClientServerApp.Message>(100);

        ClientServerApp.Server server = null;
        server = new ClientServerApp.Server(messageArrayBlockingQueue);
        server.start();

        ClientServerApp.Client[] arrayOfClients = new ClientServerApp.Client[5];
        for (int i = 0; i < 5; i++) {
            arrayOfClients[i] = new ClientServerApp.Client(messageArrayBlockingQueue, "client #" + i);
            arrayOfClients[i].start();
        }

        try {
            while (!messageArrayBlockingQueue.isEmpty()) {
                assertNotNull(messageArrayBlockingQueue);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            
        }
        assertEquals(0,messageArrayBlockingQueue.size());
        for (int i = 0; i < 5; i++) {
            try {
                arrayOfClients[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (server != null) {
            try {
                server.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
