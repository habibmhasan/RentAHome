package com.example.rentahome;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PostDetailsActivity extends AppCompatActivity {

    TextView mTitletv, mDetailtv;
    ImageView mImgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Post details");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        mTitletv = findViewById(R.id.titletv);
        mDetailtv = findViewById(R.id.descriptiontv);
        mImgview = findViewById(R.id.imgView);

        byte[] bytes = getIntent().getByteArrayExtra("image");
        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("description");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        mTitletv.setText(title);
        mDetailtv.setText(desc);
        mImgview.setImageBitmap(bmp);
    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
