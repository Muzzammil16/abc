package com.abbi.practics1.Recycler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.abbi.practics1.R;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerActivity extends AppCompatActivity {

    ArrayList<DataItem> dt =new ArrayList<>();
    RecyclerView rcv;
    MyFirstAdapter adp = new MyFirstAdapter(dt);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        rcv =findViewById(R.id.recyclerView);
        setListInItem();
        rcv.setAdapter(adp);
        rcv.setLayoutManager(new LinearLayoutManager(this) );
    }

    private void setListInItem() {
        for (int i =0;i<10;i++)
        {
            dt.add(new DataItem("Name"+ i, "123456"+ i));
        }
    }
}
