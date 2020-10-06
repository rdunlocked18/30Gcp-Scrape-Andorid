package com.daftarirn.cloud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.daftarirn.cloud.Adapters.HomeQwikAdapter;
import com.daftarirn.cloud.Models.QwikModel;
import com.daftarirn.cloud.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String url = "https://dscvit30daysgcp.herokuapp.com/";

    private RecyclerView mHomeRV;
    private List<QwikModel> profileList;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private List<QwikModel> sortedPeopleList = new ArrayList<>();

    //viewB
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        profileList = new ArrayList<>();
        adapter = new HomeQwikAdapter(getApplicationContext(),profileList);
        linearLayoutManager   = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        activityMainBinding.homeRecycle.setHasFixedSize(true);
        activityMainBinding.homeRecycle.setLayoutManager(linearLayoutManager);
        activityMainBinding.homeRecycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        activityMainBinding.homeRecycle.scheduleLayoutAnimation();

        getData();


        activityMainBinding.refreshFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshData();
            }
        });



        activityMainBinding.searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sortList(profileList);
            }
        });

    }



    private void getData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        QwikModel qwikModel = new QwikModel();
                        qwikModel.setName(jsonObject.getString("name"));
                        qwikModel.setDpUrl(jsonObject.getString("dp"));
                        qwikModel.setQuests_status(jsonObject.getInt("quests_status"));
                        qwikModel.setQuestsNames(jsonObject.getJSONArray("quests"));


                        profileList.add(qwikModel);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }


    public void  refreshData(){
        getData();
    }


    private void sortList(List<QwikModel> list) {
        sortedPeopleList.clear();
        String searchName = activityMainBinding.searchBar.getText().toString();

        Log.d(TAG, "sortList: " + searchName);

        Log.d(TAG, "sortList: started");
        for (QwikModel item : list) {
            if (item.getName().contains(searchName) && !searchName.isEmpty()) {

                sortedPeopleList.add(item);

                Log.d(TAG, "sortList: "+item);
            }

        }
    }


    }
