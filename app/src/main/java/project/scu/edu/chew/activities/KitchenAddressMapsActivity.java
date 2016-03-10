
package project.scu.edu.chew.activities;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.HomeCook;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 */
public class KitchenAddressMapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    HomeCook homeCook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_address_maps);

        Intent i = getIntent();
        homeCook = (HomeCook)i.getSerializableExtra("homecook");

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we
     * just add a marker near Africa.
     */
    @Override
    public void onMapReady(GoogleMap map) {
//        map.addMarker(new MarkerOptions().position(new LatLng(37.3492, -121.9381)).title(homeCook.getName())).showInfoWindow();
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.3492, -121.9381), 10));

//        getAddressFromLocation(homeCook.getAddress(),
//                getApplicationContext(), new GeocoderHandler());

        LatLng myLatLng = getAddressFromLocation1(homeCook.getAddress(), getApplicationContext());

        Marker marker = map.addMarker(new MarkerOptions().position(myLatLng).title(homeCook.getName()));
        marker.showInfoWindow();
        marker.setTitle(homeCook.getAddress());
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(myLatLng, 10));
    }

    public static void getAddressFromLocation(final String locationAddress,
                                              final Context context, final Handler handler) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result = null;
                try {
                    List<Address> addressList = geocoder.getFromLocationName(locationAddress, 1);
                    if (addressList != null && addressList.size() > 0) {
                        Address address = addressList.get(0);
                        StringBuilder sb = new StringBuilder();
                        sb.append(address.getLatitude()).append("\n");
                        sb.append(address.getLongitude()).append("\n");
                        result = sb.toString();
                    }
                } catch (IOException e) {
                   System.out.println("Unable to connect to Geocoder" + e.getMessage());
                } finally {
                    Message message = Message.obtain();
                    message.setTarget(handler);
                    if (result != null) {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Address: " + locationAddress +
                                "\n\nLatitude and Longitude :\n" + result;
                        System.out.println("Lat Long:" + result);
                        bundle.putString("address", result);
                        message.setData(bundle);
                    } else {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Address: " + locationAddress +
                                "\n Unable to get Latitude and Longitude for this address location.";
                        System.out.println("Could not get lat long");
                                bundle.putString("address", result);
                        message.setData(bundle);
                    }
                    message.sendToTarget();
                }
            }
        };
        thread.start();
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }

        }
    }


    public  LatLng getAddressFromLocation1(final String locationAddress,
                                              final Context context) {

                LatLng myLatLng = null;
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result = null;
                try {
                    List<Address> addressList = geocoder.getFromLocationName(locationAddress, 1);
                    if (addressList != null && addressList.size() > 0) {
                        Address address = addressList.get(0);
                        StringBuilder sb = new StringBuilder();
                        sb.append(address.getLatitude()).append("\n");
                        sb.append(address.getLongitude()).append("\n");
                        result = sb.toString();
                        myLatLng = new LatLng(address.getLatitude(), address.getLongitude());
                    }
                } catch (IOException e) {
                    System.out.println("Unable to connect to Geocoder" + e.getMessage());
                } finally {
                    if (result != null) {

                        result = "Address: " + locationAddress +
                                "\n\nLatitude and Longitude :\n" + result;
                        System.out.println("Lat Long:" + result);

                    } else {

                        result = "Address: " + locationAddress +
                                "\n Unable to get Latitude and Longitude for this address location.";
                        System.out.println("Could not get lat long");

                    }
                }


        return myLatLng;

    }
}

