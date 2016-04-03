package project.scu.edu.chew.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import project.scu.edu.chew.R;
import project.scu.edu.chew.helpers.LoadData;
import project.scu.edu.chew.models.HomeCook;

public class NearestKitchenActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;

    private static final int LOCATION_PERMISSION = 1;
    private GoogleApiClient mGoogleApiClient;
    LatLng currentUserLatLng = null;
    HashMap<String, LatLng> homeCooksLatLngs = new HashMap<String, LatLng>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearest_kitchen);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getHomeCooksLatLng();

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .enableAutoManage(this, this)
                    .build();
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void getHomeCooksLatLng(){
        ArrayList<HomeCook> homeCooks = new ArrayList<>();
        LoadData.populateData(homeCooks);


        for(HomeCook homeCook: homeCooks) {
            String addr = homeCook.getAddress();
            if(addr != null) {
                LatLng latlng = (KitchenAddressMapsActivity.getAddressFromLocation1(addr, getApplicationContext()));
                homeCooksLatLngs.put(homeCook.getName(), latlng);
            }

        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        startLocationTracking();
    }

    private void startLocationTracking() {
        if (Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION);
            return;
        }

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] result){
        super.onRequestPermissionsResult(requestCode, permissions, result);
        if (requestCode == LOCATION_PERMISSION){
            startLocationTracking();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        System.out.println("MainKitchen: Curr" + "Location: " + location.getLatitude() + "," + location.getLongitude());
        LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
        currentUserLatLng = loc;

         mMap.addMarker(new MarkerOptions()
                .position(currentUserLatLng).draggable(true)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pegman)));

        for(Map.Entry<String, LatLng> entry : homeCooksLatLngs.entrySet()) {
            LatLng homeCookLatLng = entry.getValue();
            String homeCookName = entry.getKey();

            double distance = SphericalUtil.computeDistanceBetween(homeCookLatLng, currentUserLatLng);
            double distanceInMiles = Math.round(0.000621371192 * distance);

            if(distanceInMiles < 10){
                mMap.addMarker(new MarkerOptions()
                        .position(homeCookLatLng).draggable(true).title(homeCookName)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.chef_marker)));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentUserLatLng, 10));

        }

//        System.out.println("HomeCook LatLng:" + homeCookLatLng);
//        System.out.println("User LatLng:" + currentUserLatLng);
//        double distance = SphericalUtil.computeDistanceBetween(homeCookLatLng, currentUserLatLng);
//        double distanceInMiles = Math.round(0.000621371192 * distance);
//        System.out.println("Distance Calculated:" + distanceInMiles + " miles");
//
//        TextView dTextView = (TextView) findViewById(R.id.distanceMiles);
//        dTextView.setText(distanceInMiles + "mi");



    }

    @Override
    public void onConnectionSuspended(int i) {}

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {}
}
