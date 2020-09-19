package com.hindu.hinduhelp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hindu.hinduhelp.apiinterface.get_set.help_get_set;

import java.util.List;

public class pendadapter extends RecyclerView.Adapter<pendadapter.ViewHolder> {


    Context mcontext;
    private List<help_get_set> data;
    public pendadapter(Context mcontext,List<help_get_set> data){
        this.data=data;
        this.mcontext=mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cmplayout, null);

        final ViewHolder viewHolder=new ViewHolder(itemview);


        viewHolder.hmob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mo=data.get(viewHolder.getAdapterPosition()).getHmob();
                Uri call = Uri.parse("tel:" + mo);
                Intent o = new Intent(Intent.ACTION_DIAL, call);
                mcontext.startActivity(o);
            }
        });
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        help_get_set d=data.get(position);

        viewHolder.id.setText(d.getId()+"");
        viewHolder.name.setText(d.getFullname());
        viewHolder.date.setText(d.getDatehelp());
        viewHolder.detail.setText(d.getHdisc());
        viewHolder.hname.setText(d.getHelper());
        viewHolder.hmob.setText(d.getHmob());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView id,name,date,detail,hname,hmob;;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=(TextView) itemView.findViewById(R.id.helpid);
            name=(TextView) itemView.findViewById(R.id.helpname);
            date=(TextView) itemView.findViewById(R.id.helpdate);
            detail=(TextView) itemView.findViewById(R.id.helptxt);
            hname=(TextView) itemView.findViewById(R.id.helpername);
            hmob=(TextView) itemView.findViewById(R.id.helpermob);


        }
    }
}
