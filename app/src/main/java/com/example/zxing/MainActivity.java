package com.example.zxing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nightfarmer.zxing.ScanHelper;

public class MainActivity extends AppCompatActivity {

    TextView tv_result;
    private EditText et_data;
    private ImageView iv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScanHelper.capture(MainActivity.this);
            }
        });
        tv_result = (TextView) findViewById(R.id.tv_result);
        et_data = (EditText) findViewById(R.id.et_data);
        iv_result = (ImageView) findViewById(R.id.iv_result);
        findViewById(R.id.bt_encoding).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et_data.getText().toString();
                Bitmap bitmap = ScanHelper.encodingMap(s, 300);
                iv_result.setImageBitmap(bitmap);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String resultStr = ScanHelper.handlerData(requestCode, resultCode, data);
        tv_result.setText(resultStr);
    }
}
