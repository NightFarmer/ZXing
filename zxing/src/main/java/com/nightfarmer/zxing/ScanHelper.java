package com.nightfarmer.zxing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;

import com.google.zxing.WriterException;
import com.nightfarmer.zxing.activity.CaptureActivity;
import com.nightfarmer.zxing.encoding.EncodingHandler;

/**
 * 二维码扫描工具
 * Created by zhangfan on 16-1-8.
 */
public class ScanHelper {
    public static final int RequestCode = 1;

    public static void capture(Activity activity) {
        Intent intent = new Intent(activity, CaptureActivity.class);
        activity.startActivityForResult(intent, RequestCode);
    }

    public static String handlerData(int requestCode, int resultCode, Intent data) {
        if (requestCode == ScanHelper.RequestCode) {
            if (resultCode == Activity.RESULT_OK) {
                return data.getStringExtra("result");
            }
        }
        return null;
    }

    public static Bitmap encodingMap(String data, int size){
        try {
            return EncodingHandler.createQRCode(data, size);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
