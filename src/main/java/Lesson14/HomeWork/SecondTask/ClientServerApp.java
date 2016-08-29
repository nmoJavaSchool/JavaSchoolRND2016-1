package Lesson14.HomeWork.SecondTask;

/**
 * Created by user on 29.08.16.
 */

import java.util.concurrent.ArrayBlockingQueue;

public class ClientServerApp {

    public static class Message {
        String user;
        String message;

        Message(String user, String message) {
            this.user = user;
            this.message = message;
        }
    }

    public static class Client extends Thread {
        ArrayBlockingQueue<Message> messageService;
        String username;

        public Client(ArrayBlockingQueue<Message> messageService, String name) {
            this.messageService = messageService;
            username = name;
        }

        @Override
        public void run() {
            String line = "message ";
            int counter = 1;
            try {
                while (counter <= 10) {
                    Message message = new Message(username, line + counter);
                    messageService.offer(message);
                    Thread.sleep(1000);
                    ++counter;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            messageService.offer(new Message(username, "exit"));
            try {
                while (messageService.size() > 0) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End " + username + "!");
        }
    }

    public static class Server extends Thread {
        ArrayBlockingQueue<Message> messageService;

        public Server(ArrayBlockingQueue<Message> messageService) {
            this.messageService = messageService;
        }

        @Override
        public void run() {
            System.out.println("Waiting for message...");
            try {
                while (true) {
                    Thread.sleep(1000);
                    if (messageService.size() > 0) {
                        Message receivedMessage = messageService.poll();
                        if (receivedMessage != null) {
                            if(!receivedMessage.message.equals("exit")) {
                                System.out.println("new message: ");
                                System.out.println("       from: " + receivedMessage.user);
                                System.out.println("       body: " + receivedMessage.message);
                            }
                            else {
                                messageService.clear();
                                break;
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        ArrayBlockingQueue<Message> messageArrayBlockingQueue = new ArrayBlockingQueue<Message>(100);

        Server server = null;
        server = new Server(messageArrayBlockingQueue);
        server.start();

        Client[] arrayOfClients = new Client[5];
        for (int i = 0; i < 5; i++) {
            arrayOfClients[i] = new Client(messageArrayBlockingQueue, "client #" + i);
            arrayOfClients[i].start();
        }

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
