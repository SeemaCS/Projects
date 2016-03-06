package com.project.dc.calendarapp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class ClientThread implements  Runnable {

    String serverFromMessage = "";
    String inputMessage;

    public ClientThread(String inputMessage, String serverFromMessage){
        this.serverFromMessage = serverFromMessage;
        this.inputMessage = inputMessage;
    }


    private Socket socket;
    private static final int SERVERPORT = 9500;
    private static final String SERVER_IP = "172.20.66.164";


    @Override
    public void run() {

        try {
            System.out.println("Starting client thread...");
            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
            socket = new Socket(serverAddr, SERVERPORT);
            if(socket != null) {
                System.out.println("Socket obtained...");
            }
            else {
                System.out.println("Socket null...");

            }
            serverFromMessage = "";

            String str = this.inputMessage;
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            out.println(str);
            out.flush();
            System.out.println("Sent msg to server...");

            // Thread.sleep(1100);

            InputStream ios = socket.getInputStream();
            String message = null;
            Scanner scan = new Scanner(ios);
            if(scan.hasNext()) {
                message = scan.nextLine();

                if (message != null) {
                    serverFromMessage = message;
                }
            }
            socket.close();

            System.out.println("Got message from server..." + message);
            System.out.println("6)Thread done..i am the main thread with message:" + serverFromMessage);

        } catch (UnknownHostException e1) {

            e1.printStackTrace();

        } catch (IOException e1) {

            e1.printStackTrace();

        }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        finally {
            try {
                socket.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }

    }
}
