package com.project.dc.calendarapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by lakshitha on 3/6/16.
 */
public class CancelAdapter extends ArrayAdapter<String> {
    private final List<String> scheduledItems;

    private Button cancelButton;
    private MainActivity mainActivity;

    public CancelAdapter(Context context, int resource, List<String> scheduledItems, MainActivity mainActivity) {
        super(context, resource, scheduledItems);
        this.scheduledItems = scheduledItems;
        this.mainActivity = mainActivity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String scheduledItem = scheduledItems.get(position);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.cancel_list_row, null);
        cancelButton = (Button) row.findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callToCancel(scheduledItem);
                notifyDataSetChanged();
            }
        });

        TextView nameTextView = (TextView) row.findViewById(R.id.schedule);
        nameTextView.setText(scheduledItem);

        return row;
    }

    public void callToCancel(String scheduledItem) {

        System.out.println("Scheduled Item:" + scheduledItem);

        System.out.println("Actual schedule.....");
        for(String item: mainActivity.actualSchedule) {
            System.out.println("Item is:" + item);
        }

        System.out.println("Schedule.....");

        for(String item: mainActivity.schedule) {
            System.out.println("Item is:" + item);
        }

        int position = Collections.binarySearch(mainActivity.schedule, scheduledItem);
        System.out.println("Position is:" + position);

        String messageToServer = mainActivity.actualSchedule.get(position);

        messageToServer = messageToServer.replace("schedule", "cancel");

        String serverFromMessage = "";
        System.out.println("Coming here...on click....");

        Thread t = new Thread(new ClientThread(messageToServer, serverFromMessage, mainActivity));
        t.start();
        System.out.println("1)Thread done..i am the main thread with message:" + serverFromMessage);

        try {
            t.join();
            System.out.println("2)Thread done..i am the main thread with message:" + serverFromMessage);
            Thread.sleep(1000);
            System.out.println("3)Thread done..i am the main thread with message:" + serverFromMessage);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.out.println("4)Thread done..i am the main thread with message:" + serverFromMessage);
            e.printStackTrace();

        }


        System.out.println("5) Thread done..i am the main thread with message:" + serverFromMessage);


    }







}



