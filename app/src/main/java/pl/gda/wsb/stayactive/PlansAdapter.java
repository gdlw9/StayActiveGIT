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
    private final RecyclerViewInterface recyclerViewInterface;

    ArrayList<PlansModelClass> arrayList;
    Context context;

    public PlansAdapter(ArrayList<PlansModelClass> arrayList, Context context,RecyclerViewInterface recyclerViewInterface) {
        this.arrayList = arrayList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.plansitem_desing,null,false);
        return new ViewHolder(view,recyclerViewInterface);
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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mscl,exc,reps;
        RelativeLayout line,line2;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            mscl=itemView.findViewById(R.id.mscl);
            line=itemView.findViewById(R.id.line);
            line2=itemView.findViewById(R.id.line2);
            exc=itemView.findViewById(R.id.exc);
            reps=itemView.findViewById(R.id.reps);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface!=null){
                        int pos = getAdapterPosition();

                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.OnItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
