package pl.gda.wsb.stayactive;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Back extends AppCompatActivity {
    ArrayList<ModelClass> arrayList;
    RecyclerView recyclerView;

    ImageView imageView;
    ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        recyclerView=findViewById(R.id.recycle_view);
        arrayList= new ArrayList<>();
        Adapter adapter;
        imageView=findViewById(R.id.iv_img1);
        imageView2=findViewById(R.id.iv_img2);


        arrayList.add(new ModelClass("Podciaganie",
                "prac:\n-nig\n-aha",
                "s:\nloremuassdafsafafafafafafafafa",R.drawable.no,R.drawable.no,false));

        adapter= new Adapter(arrayList,Back.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}