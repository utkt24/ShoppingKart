package com.example.shoppingkart.Actvity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.shoppingkart.Adapter.PopularListAdapter;
import com.example.shoppingkart.Domain.PopularDomain;
import com.example.shoppingkart.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPupolar;
    private RecyclerView recyclerViewPupolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        bottom_navigation();

    }

    private void bottom_navigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
    }

    @SuppressLint("WrongViewCast")
    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("HP 15 Laptop",
                "Processor: Intel Core i3",
                "laptop",
                15, 4, 500));

        items.add(new PopularDomain("ps-5 Digital",
                "Online Gaming",
                "ps" , 10, (int) 4.5, 450 ));
        items.add(new PopularDomain("Iphone 15",
                "RAM : 16GB",
                "phone", 13, (int) 4.2, 800 ));

        recyclerViewPupolar = findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPupolar = new PopularListAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);
    }
}
