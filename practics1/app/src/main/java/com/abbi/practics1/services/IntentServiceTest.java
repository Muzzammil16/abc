package com.abbi.practics1.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;


public class IntentServiceTest extends IntentService {

    public IntentServiceTest(){
        super("Intent Service");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int maxCount = intent.getIntExtra("maxCountValue", -1);

        for (int i = 0; i < maxCount; i++) {
            Log.d(TAG, "onHandleWork: The number is: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
