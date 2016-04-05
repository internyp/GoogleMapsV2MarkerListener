package app.akexorcist.googlemapsv2markerlistener;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class Main extends FragmentActivity {
	GoogleMap mMap;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mMap = ((SupportMapFragment)getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();
		
		mMap.setOnMapClickListener(new OnMapClickListener() {
			public void onMapClick(LatLng arg0) {
				mMap.addMarker(new MarkerOptions().position(arg0)
						.title(String.valueOf(arg0.latitude)
						+ ", " + String.valueOf(arg0.longitude)));
			}
		});
		
		mMap.setOnMarkerClickListener(new OnMarkerClickListener() {
			public boolean onMarkerClick(Marker arg0) {
				arg0.remove();
				Toast.makeText(getApplicationContext()
						, "Remove Marker " + String.valueOf(arg0.getId())
						, Toast.LENGTH_SHORT).show();
				return true;
			}
		});
	}
}

