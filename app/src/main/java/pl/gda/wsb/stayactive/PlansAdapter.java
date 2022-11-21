package pl.gda.wsb.stayactive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlansAdapter extends RecyclerView.Adapter<PlansAdapter.ViewHolder> {
    ArrayList<PlansModelClass> arrayList;
    Context context;

    public PlansAdapter(ArrayList<PlansModelClass> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.plansitem_desing,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlansModelClass plansModelClass = arrayList.get(position);
        holder.mscl.setText(plansModelClass.getMscl());
        holder.exc.setText(plansModelClass.getExc());
        holder.reps.setText(plansModelClass.getReps());
    }

    @Override
    public int getItemCount() { return arrayList.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mscl,exc,reps;
        RelativeLayout line,line2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mscl=itemView.findViewById(R.id.mscl);
            line=itemView.findViewById(R.id.line);
            line2=itemView.findViewById(R.id.line2);
            exc=itemView.findViewById(R.id.exc);
            reps=itemView.findViewById(R.id.reps);
        }
    }
}
