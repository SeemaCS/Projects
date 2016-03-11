package project.scu.edu.chew.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.CartItem;
import project.scu.edu.chew.models.UserSession;

/**
 * Created by lakshitha on 2/2/16.
 */

// Display items in the cart added along with details.
public class CartAdapter extends ArrayAdapter<CartItem> {

    private final List<CartItem> cartItems;
    Button cancelButton;
    SharedPreferences gobblePreferences;
    TextView totalText;
    TextView cartItemMsg;

    public CartAdapter(Context context, int resource, List<CartItem> cartItems, SharedPreferences gobblePreferences, TextView totalText, TextView cartItemMsg) {
        super(context, resource, cartItems);
        this.cartItems = cartItems;
        this.gobblePreferences = gobblePreferences;
        this.totalText = totalText;
        this.cartItemMsg = cartItemMsg;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final CartItem cartItem = cartItems.get(position);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        final View row = inflater.inflate(R.layout.cart_list_row, null);

        cancelButton = (Button) row.findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItems.remove(cartItem);

                // Remove from shared Preferences
                Gson gson = new Gson();
                String json = gobblePreferences.getString("currentSession", "");
                UserSession userSession = gson.fromJson(json, UserSession.class);
                List<CartItem> items = userSession.getCartItems();
                for(CartItem item: items) {
                    if(item.getName().equals(cartItem.getName())) {
                        items.remove(item);
                        break;
                    }
                }



                double totalValue = userSession.getTotalValueInCart() - (cartItem.getPrice() * cartItem.getQuantity());
                System.out.println("Setting total in cart:" + totalValue);
                userSession.setTotalValueInCart(totalValue);

                totalText.setText("Total: $" + Double.toString(userSession.getTotalValueInCart()));

                userSession.setBadgeCount(userSession.getBadgeCount() - cartItem.getQuantity());

                SharedPreferences.Editor editor = gobblePreferences.edit();
                String writeJson = gson.toJson(userSession);
                editor.putString("currentSession", writeJson);
                editor.commit();

                if(cartItems.size() <= 0) {
                    cartItemMsg.setVisibility(View.VISIBLE);
                } else {
                    cartItemMsg.setVisibility(View.INVISIBLE);
                }


                notifyDataSetChanged();
            }
        });

        TextView nameTextView = (TextView) row.findViewById(R.id.cart_row_name);
        nameTextView.setText(cartItem.getName());

        TextView quantityTextView = (TextView) row.findViewById(R.id.cquantity);
        quantityTextView.setText("Quantity: " + cartItem.getQuantity());

        TextView priceTextView = (TextView) row.findViewById(R.id.cprice);
        priceTextView.setText("Price: " + cartItem.getPrice());



        return row;
    }
}





