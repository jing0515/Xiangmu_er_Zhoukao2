package com.bawei.lvwenjing.xiangmu_er_zhoukao2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThreeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView tv = (TextView) findViewById(R.id.ti);
        tv.setText(name);

    }
}
