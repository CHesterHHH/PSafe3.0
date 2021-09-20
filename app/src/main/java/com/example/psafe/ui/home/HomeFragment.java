package com.example.psafe.ui.home;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Typeface;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.psafe.R;
import com.example.psafe.data.model.ProximityAlertReceiver;
import com.example.psafe.data.model.Selfsaving;
import com.example.psafe.data.model.Tips;
import com.example.psafe.retrofit.SearchResponse;
import com.example.psafe.retrofit.Weather;
import com.example.psafe.ui.tips.TipRecyclerViewAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.Manifest;

import android.content.pm.PackageManager;
import android.location.Location;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button sos_button;
    private RecyclerView recyclerView;
    private ArrayList<Selfsaving> test;
    private RecyclerView.Adapter homeAdapter;
    private TextView scrollingText;

    private RecyclerView.LayoutManager homeLayoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View rootView = inflater.inflate(R.layout.homeone_layout, container, false);

        sos_button = rootView.findViewById(R.id.SOS_button);
        scrollingText = rootView.findViewById(R.id.home_text1);
        scrollingText.setSelected(true);


        sos_button.setOnLongClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:000"));
            startActivity(intent);
            return true;
        });

  





        /*
        recyclerView = rootView.findViewById(R.id.HomeRecyclerView);
        recyclerView.setHasFixedSize(true);

        test = new ArrayList<>();


        //layout manager
        homeLayoutManager = new LinearLayoutManager(getContext());
        //recyclerView.setLayoutManager(homeLayoutManager);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        homeAdapter = new HomeRecyclerViewAdapter(getContext(),test);
        //Log.d(TAG,galleryViewModel.getAllNews().get(0).getId());

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    test.add(child.getValue(Selfsaving.class));
                }
                homeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
               // Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        homeViewModel.getRepository().getmDatabase().child("selfSaving").orderByChild("id").addValueEventListener(postListener);

        recyclerView.setAdapter(homeAdapter);
        */

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        //((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onResume() {
        super.onResume();
       // ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
       // ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }
}
