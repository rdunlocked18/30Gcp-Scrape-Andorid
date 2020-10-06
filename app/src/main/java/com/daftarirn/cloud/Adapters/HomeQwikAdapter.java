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
        holder.nameFetch.setText(qwikModel.getName());


        //set dp
        String dpURl = qwikModel.getDpUrl();
        Glide.with(context).load(Uri.parse(dpURl))
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.loadin)
                .into(holder.displayP);

        //set Quest total numbers
        String questStatusCount = "Total Quests : "+qwikModel.getQuests_status();

        holder.questsNames.setText(questStatusCount);
        urltoProfile = qwikModel.getQwiklabs_id();




    }

    @Override
    public int getItemCount() {
        return qwikModelList.size();
    }

    public class QwikViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView nameFetch,questsNames;
        public CircleImageView displayP;
        Button viewProfile,shareStatus;


        public QwikViewHolder(@NonNull View itemView) {
            super(itemView);
             nameFetch = itemView.findViewById(R.id.nameFetch);
             questsNames = itemView.findViewById(R.id.questsNames);
             viewProfile = itemView.findViewById(R.id.btnViewProfile);
             shareStatus = itemView.findViewById(R.id.btnShareStat);
             displayP = itemView.findViewById(R.id.displayPicture);
             viewProfile.setOnClickListener(this);
             shareStatus.setOnClickListener(this);
             questsNames.setOnClickListener(this);




        }

        @Override
        public void onClick(View view) {


            switch (view.getId()){
                case  R.id.btnViewProfile :
                    Toast.makeText(itemView.getContext(), "hello", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnShareStat:
                    Toast.makeText(itemView.getContext(), "melllo", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.questsNames:
                    Toast.makeText(itemView.getContext(), "Quests", Toast.LENGTH_SHORT).show();
                    break;
            }



        }
    }
}
