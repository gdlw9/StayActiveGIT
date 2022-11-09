package pl.gda.wsb.stayactive;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<ModelClass> arrayList;
    Context context;

    public Adapter(ArrayList<ModelClass> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_desing,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass modelClass = arrayList.get(position);
        holder.tv_title.setText(modelClass.getExercise());
        holder.iv_img1.setImageResource(modelClass.getImageView1());
        holder.iv_img2.setImageResource(modelClass.getImageView2());
        holder.tv_working_muscles.setText(modelClass.getWorking_muscles());
        holder.tv_desc.setText(modelClass.getDescription());

        boolean isVisible = arrayList.get(position).isVisible();
        holder.iv_img1.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        holder.iv_img2.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        holder.tv_working_muscles.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        holder.tv_desc.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        holder.rl_desc.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        holder.rl_title_line.setVisibility(isVisible ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title,tv_working_muscles,tv_desc;
        RelativeLayout rl_title_line,rl_desc;
        LinearLayout linearLayout;
        ImageView iv_img1,iv_img2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_title);
            rl_title_line=itemView.findViewById(R.id.rl_title_line);
            iv_img1=itemView.findViewById(R.id.iv_img1);
            iv_img2=itemView.findViewById(R.id.iv_img2);
            tv_working_muscles=itemView.findViewById(R.id.tv_w_mscl);
            tv_desc=itemView.findViewById(R.id.tv_desc);
            rl_desc=itemView.findViewById(R.id.rl_desc_line);

            linearLayout=itemView.findViewById(R.id.linear_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ModelClass modelClass = arrayList.get(getAdapterPosition());
                    modelClass.setVisible(!modelClass.isVisible());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
