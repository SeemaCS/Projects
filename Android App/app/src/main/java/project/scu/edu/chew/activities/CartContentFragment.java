package project.scu.edu.chew.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.CartItem;
import project.scu.edu.chew.models.UserSession;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class CartContentFragment extends Fragment {

    Button orderButton;

    final static private long ONE_SECOND = 1000;
    final static private long TWENTY_SECONDS = ONE_SECOND * 20;
    PendingIntent pi;
    BroadcastReceiver br;
    AlarmManager am;
    public CartContentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart_content, container, false);

        ListView listView = (ListView) view.findViewById(R.id.cart_list_view);

        SharedPreferences gobblePreferences = getActivity().getSharedPreferences("GOBBLE_PREFS", getActivity().MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gobblePreferences.getString("currentSession", "");
        UserSession userSession = gson.fromJson(json, UserSession.class);
        List<CartItem> cartItems = userSession.getCartItems();
        setup();
        TextView totalText = (TextView) view.findViewById(R.id.ctotal);
        TextView cartItemMsg = (TextView) view.findViewById(R.id.noItemMsg);


//        List<FoodItem> foodItems = new ArrayList<>();
//        foodItems.add(new FoodItem("Pasta", "food11.jpg"));
//        foodItems.add(new FoodItem("Pizza", "food11.jpg"));

        listView.setAdapter(new CartAdapter(getActivity().getBaseContext(), R.layout.cart_list_row, cartItems, gobblePreferences, totalText, cartItemMsg));
       // orderButton = (Button) view.findViewById(R.id.orderButton);
//        orderButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
//                alertDialog.setTitle("NOTIFICATION");
//                alertDialog.setMessage("WOULD YOU LIKE TO SET AN ALARM TO REMIND YOU WHEN YOUR ORDER IS READY?");
//                alertDialog.setIcon(R.drawable.gobble_logo);
//
//                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface arg0, int arg1) {
//                        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() +
//                                TWENTY_SECONDS, pi);
//                        ;
//                    }
//                });
//                alertDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface arg0, int arg1) {
//                    }
//                });
//                alertDialog.show();


                //Toast.makeText(getActivity().getBaseContext(), "Order has been placed", Toast.LENGTH_SHORT).show();
               // ((CartActivity10)getActivity()).showNotification();
//            }
//        });

        if(cartItems.size() <= 0) {
            cartItemMsg.setVisibility(View.VISIBLE);
        } else {
            cartItemMsg.setVisibility(View.INVISIBLE);
            ((CartActivity10)getActivity()).startListening(); // starts listening
        }


        double totalValue = userSession.getTotalValueInCart();
        System.out.println("Getting total Value:" + totalValue);
        totalText.setText("Total: $" + Double.toString(totalValue));
        // Inflate the layout for this fragment
        return view;
    }
    private void setup() {
        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context c, Intent i) {
                //Toast.makeText(c, "Your order has been placed", Toast.LENGTH_LONG).show();
                ((CartActivity10) getActivity()).showNotification();
            }
        };
        getActivity().registerReceiver(br, new IntentFilter("com.authorwjf.wakeywakey"));
        pi = PendingIntent.getBroadcast( getActivity(), 0, new Intent("com.authorwjf.wakeywakey"),
                0 );
        am = (AlarmManager)(getActivity().getSystemService(Context.ALARM_SERVICE ));
    }
}
