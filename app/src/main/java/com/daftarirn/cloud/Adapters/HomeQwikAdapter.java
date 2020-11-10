package com.daftarirn.cloud.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daftarirn.cloud.Models.QwikModel;
import com.daftarirn.cloud.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeQwikAdapter  extends RecyclerView.Adapter<HomeQwikAdapter.QwikViewHolder> {

    public static Context context;
    List<QwikModel> qwikModelList;
    String urltoProfile;

    @NonNull
    @Override
    public HomeQwikAdapter.QwikViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.single_item_home, parent, false);
        return new QwikViewHolder(view);

    }

    public HomeQwikAdapter(Context context, List<QwikModel> qwikModelList ) {
        this.context = context;
        this.qwikModelList = qwikModelList;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeQwikAdapter.QwikViewHolder holder, int position) {

        //all setters and getters usage
        QwikModel qwikModel = qwikModelList.get(position);
        holder.nameFetch.setText("Login Time : "+qwikModel.getLoginTime());


       String questStatusCount = "MacID : "+qwikModel.getMacId();

        holder.questsNames.setText(questStatusCount);
        boolean isDeviceValid  = qwikModel.getDeviceValid();
        if(!isDeviceValid){
            holder.displayP.setColorFilter(context.getResources().getColor(R.color.redInvalid));
        }




    }

    @Override
    public int getItemCount() {
        return qwikModelList.size();
    }

    public class QwikViewHolder extends RecyclerView.ViewHolder{
        public TextView nameFetch,questsNames;
        public CircleImageView displayP;



        public QwikViewHolder(@NonNull View itemView) {
            super(itemView);
             nameFetch = itemView.findViewById(R.id.nameFetch);
             questsNames = itemView.findViewById(R.id.questsNames);
             displayP = itemView.findViewById(R.id.displayPicture);




        }


    }
}
