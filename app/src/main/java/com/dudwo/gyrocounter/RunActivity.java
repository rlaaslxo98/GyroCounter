package com.dudwo.gyrocounter;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;


public class RunActivity extends Fragment implements View.OnClickListener {


    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_run,container,false);

        rootView.findViewById(R.id.start).setOnClickListener(this);
        rootView.findViewById(R.id.popup).setOnClickListener(this);

        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(
                connectionUpdates , new IntentFilter("BLUETOOTH"));

        return rootView;
    }

    BroadcastReceiver connectionUpdates = new BroadcastReceiver() {
        @Override
        public void onReceive(Context arg0, Intent intent) {
            int action = intent.getIntExtra("value", 1);
            Log.d("RUN", String.valueOf(action));

                     //TODO here
        }
    };


    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.start) {
            Intent intent = new Intent(getActivity(), CountRunActivity.class);
            startActivity(intent);
            getActivity().finish();
        }

        if (i == R.id.popup){
            Intent intent = new Intent(getActivity(), SetRunActivity.class);
            startActivity(intent);
        }
    }

}