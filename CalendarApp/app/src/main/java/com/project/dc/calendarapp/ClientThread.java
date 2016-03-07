package com.project.dc.calendarapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.NotificationCompat;

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

    String serverFromMessage;
    String inputMessage;
    MainActivity activity;

    public ClientThread(String inputMessage, String serverFromMessage, MainActivity activity){
        this.serverFromMessage = serverFromMessage;
        this.inputMessage = inputMessage;
        this.activity = activity;
    }

    private Socket socket;
    private static final int SERVERPORT = 8600;
    private static final String SERVER_IP = "172.20.66.164";

    @Override
    public void run() {
        String str = "";
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

            str = this.inputMessage;
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
            //System.out.println("6)Thread done..i am the main thread with message:" + serverFromMessage);
            String message1 = "";
            if(serverFromMessage.equals("success")) {
                if(str.startsWith("schedule")) {
                    message1 = "Your appointment has been scheduled successfully";
                    System.out.println("Tokenizing..." + str);
                    String[] tokens = str.split(" ");
                    activity.schedule.add(new String(tokens[1]));
                    activity.actualSchedule.add(new String(str));
                }
                else if(str.startsWith("cancel")) {
                    message1 = "Your appointment has been cancelled successfully";
                    String[] tokens = str.split(" ");
                    activity.schedule.remove(new String(tokens[1]));
                    str = str.replace("cancel", "schedule");
                    activity.actualSchedule.remove(new String(str));
                }
            }
            else {
                if(str.startsWith("schedule"))
                    message1 = "Your appointment could not be scheduled. Please try again";
                else if(str.startsWith("cancel"))
                    message1 = "Your appointment could not be cancelled. Please try again";
            }
            showNotification(message1);
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
                str = "";
                this.inputMessage = "";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showNotification( String message) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(activity);
        mBuilder.setSmallIcon(R.drawable.cancel_icon).setColor(Color.rgb(80, 147, 28));
        mBuilder.setVibrate(new long[] {100,250}).setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText(message);
        Intent resultIntent = new Intent(activity, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(activity);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) activity.getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(3, mBuilder.build());
    }
}
