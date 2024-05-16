package com.example.shoppingkart.Actvity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shoppingkart.Domain.PopularDomain;
import com.example.shoppingkart.Helper.ManagementCart;
import com.example.shoppingkart.R;

public class DetailActivity extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView titleTxt,feeTxt,descriptionTxt,reviewTxt,scoreTxt;
    private ImageView picItem, backBtn;
    private PopularDomain object;
    private int numberOrder = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managementCart = new ManagementCart(this);


        initview();
        getBundle();
    }

    private void getBundle() {
        object = (PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(picItem);

        // Assuming these TextView objects are declared in your class
        TextView titleTxt = findViewById(R.id.titleTxt);
        TextView feeTxt = findViewById(R.id.feeTxt1);
        TextView descriptionTxt = findViewById(R.id.desciptionTxt);
        TextView reviewTxt = findViewById(R.id.reviewTxt);
        TextView scoreTxt = findViewById(R.id.scoreTxt);

// Check for null before setting text
        if (titleTxt != null) {
            titleTxt.setText(object.getTitle());
        }

        if (feeTxt != null) {
            feeTxt.setText("$" + object.getPrice());
        }

        if (descriptionTxt != null) {
            descriptionTxt.setText(object.getDescription());
        }

        if (reviewTxt != null) {
            reviewTxt.setText(String.valueOf(object.getReview()));
        }

        if (scoreTxt != null) {
            scoreTxt.setText(String.valueOf(object.getScore()));
        }


        addToCartBtn.setOnClickListener(v -> {
            object.setNumberinCart(numberOrder);
            managementCart.insertFood(object);
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this,MainActivity.class));
            }
        });
    }

    private void initview() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        feeTxt = findViewById(R.id.priceTxt);
        titleTxt = findViewById(R.id.titleTxt);
        descriptionTxt = findViewById(R.id.desciptionTxt);
        picItem = findViewById(R.id.itemPic);
        reviewTxt = findViewById(R.id.reviewTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        backBtn = findViewById(R.id.backBtn);
    }
}
