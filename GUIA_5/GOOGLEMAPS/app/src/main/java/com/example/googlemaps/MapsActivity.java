package com.example.googlemaps;

import androidx.fragment.app.FragmentActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemaps.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<Place> places;
    private Spinner spinnerMapType;
    private SeekBar seekBarZoom;
    private LatLng defaultLatLng = new LatLng(13.714966, -89.155755);
    private FollowPosition followPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        seekBarZoom = (SeekBar) findViewById(R.id.seekBarZoom);


        seekBarZoom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                chooseMoveCamera(mMap, defaultLatLng, progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        spinnerMapType = (Spinner) findViewById(R.id.spinnerMapType);


        spinnerMapType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mapType = spinnerMapType.getSelectedItem().toString();
                if (mMap == null) return;
                if (mapType.equals("MAP_TYPE_NORMAL")) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                } else if (mapType.equals("MAP_TYPE_SATELLITE")) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                } else if (mapType.equals("MAP_TYPE_HYBRID")) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                places = (ArrayList<Place>) bundle.getSerializable(FetchPlacesService.RESULT);
                if (places != null && places.size() > 0) {
                    if (mMap != null) {
                        for (Place tmp : places) {
                            LatLng tmpLatLng = new LatLng(tmp.getLat(), tmp.getLon());
                            mMap.addMarker(new MarkerOptions(). position(tmpLatLng).title(tmp.getPlaceName())
                            );
                        }
                    }
                }
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter(FetchPlacesService.NOTIFICATION));
        /**/
        Intent intent = new Intent(this, FetchPlacesService.class);
        startService(intent);
        if (followPosition != null) {
            followPosition.register(MapsActivity.this);
        }
    }

    @Override
    protected void onPause() {
        unregisterReceiver(broadcastReceiver);
        if (followPosition != null)
            followPosition.unRegister(MapsActivity.this);
        super.onPause();
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
        followPosition = new FollowPosition(this.mMap, MapsActivity.this);
        followPosition.register(MapsActivity.this);

        Marker markerPerth;
        final LatLng PERTH = new LatLng(13.715578, -89.152609);


        mMap.moveCamera(CameraUpdateFactory.newLatLng(defaultLatLng));
        chooseMoveCamera(mMap, defaultLatLng, 30);
        markerPerth = mMap.addMarker(new MarkerOptions().position(PERTH).title("Facultad de estudios Tecnológicos"));
        drawShapes();
    }



    private void chooseMoveCamera(GoogleMap googleMap, LatLng tmpLatLng, int zoom){
        CameraPosition cameraPosition =  new CameraPosition.Builder().zoom(zoom).target(tmpLatLng).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }


    private void drawShapes() {
        ShapesMap shapesMap = new ShapesMap(this.mMap);

        ArrayList<LatLng> lines = new ArrayList<>();
        lines.add(new LatLng(13.9954059, -89.0193094));
        lines.add(new LatLng(13.669405, -89.04910118));
        lines.add(new LatLng(13.86021386, -89.54214478));
        lines.add(new LatLng(14.26185425, -89.50794982));
        lines.add(new LatLng(14.04640151, 89.04254159));


        shapesMap.drawLine(lines, 5, Color.RED);
        ArrayList<LatLng> linesD = new ArrayList<>();
        ArrayList<LatLng> poligon = new ArrayList<>();
        poligon.add(new LatLng(13.9954059, -89.0193094));
        poligon.add(new LatLng(13.669405, -89.04910118));
        poligon.add(new LatLng(13.86021386, -89.54214478));
        poligon.add(new LatLng(14.26185425, -89.50794982));
        poligon.add(new LatLng(14.04640151, 89.04254159));

        shapesMap.drawPoligon(poligon, 5, Color.GREEN, 0x2F00FF00);


        LatLng circlePoint = new LatLng(13.714966, -89.155755);
        shapesMap.drawCircle(circlePoint,50,Color.BLUE,2,Color.TRANSPARENT);
    }
}
