package com.spoon.havefunbuu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageBigActivity extends Activity {

    private ImageView imgBig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_big);
        imgBig= (ImageView) findViewById(R.id.imgBig);
        Intent intent=getIntent();
        int bg=intent.getIntExtra("imgBg",0);
        imgBig.setBackgroundResource(bg);
    }
	//ggqMake
}
