package com.example.newspaperdistribution;

import androidx.fragment.app.FragmentActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.newspaperdistribution.databinding.ActivityDeliveryMapBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DeliveryMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityDeliveryMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDeliveryMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
     //   new ReadJSONFeedTask().execute("http://192.168.43.195/mApp/deliveryplan.json");


        LatLng [] deliveryPoints= new LatLng[4];
        deliveryPoints[0] = new LatLng(6.916073, 79.971359);
        deliveryPoints[1] = new LatLng(6.917003, 79.971201);
        deliveryPoints[2] = new LatLng(6.915813, 79.972131);
        deliveryPoints[3] = new LatLng(6.916910, 79.970243);

        // Add a marker in Sydney and move the camera

        mMap.addMarker(new MarkerOptions().position(deliveryPoints[0]).title("no1"));
        mMap.addMarker(new MarkerOptions().position(deliveryPoints[1]).title("no34"));
        mMap.addMarker(new MarkerOptions().position(deliveryPoints[2]).title("no67"));
        mMap.addMarker(new MarkerOptions().position(deliveryPoints[3]).title("no55"));
        mMap.setMaxZoomPreference(20);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(deliveryPoints[0],17f));
    }




    /**  public String readJSONFeed(String address) {
          URL url = null;

          try {
              url = new URL(address);
          } catch (MalformedURLException e) {
              e.printStackTrace();
              Log.d("error","populateListviewFromDB: "+ e.getMessage());
          };
          StringBuilder stringBuilder = new StringBuilder();
          HttpURLConnection urlConnection = null;
          try {
              urlConnection = (HttpURLConnection) url.openConnection();
          } catch (IOException e) {
              e.printStackTrace();
              Log.d("error","populateListviewFromDB: "+ e.getMessage());
          }
          try {
              InputStream content = new BufferedInputStream(urlConnection.getInputStream());
              BufferedReader reader = new BufferedReader(new InputStreamReader(content));
              String line;
              while ((line = reader.readLine()) != null) {
                  stringBuilder.append(line);
              }
          } catch (IOException e) {
              e.printStackTrace();
              Log.d("error","populateListviewFromDB: "+ e.getMessage());
          } finally {
              urlConnection.disconnect();
          }

          return stringBuilder.toString();
      }

      private class ReadJSONFeedTask extends AsyncTask<String, Void, String> {
          protected String doInBackground(String... urls)
          {
              return readJSONFeed(urls[0]);
          }

          protected void onPostExecute(String result) {
              LatLng [] deliveryPoints;
              try {
                  JSONArray jsonArray = new JSONArray(result);
                  deliveryPoints = new LatLng[jsonArray.length()];
                  Log.i("JSON", "Number of surveys in feed: " + jsonArray.length());
  //---print out the content of the json feed---
                  for (int i = 0; i < jsonArray.length(); i++) {
                      JSONObject jsonObject = jsonArray.getJSONObject(i);
                      double lat = Double.valueOf(jsonObject.getString("latitude"));
                      double lng = Double.valueOf(jsonObject.getString("longitude"));
                      deliveryPoints[i] = new LatLng(lat, lng);
                      mMap.addMarker(new MarkerOptions().position(deliveryPoints[i]));
                  }

                  // Add a marker in Sydney and move the camera
                  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(deliveryPoints[0],16f));

              } catch (Exception e) {
                  e.printStackTrace();
                  Log.d("error","populateListviewFromDB: "+ e.getMessage());
              }


          }
      }*/
}