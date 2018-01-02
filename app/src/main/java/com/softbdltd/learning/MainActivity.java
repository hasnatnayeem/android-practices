package com.softbdltd.learning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.addLogAdapter(new AndroidLogAdapter());
        test();


    }

    private void test() {
        String json = "{name: nayeem, age: 24}";
        String xml = "<user><name>Nayeem</name><age>24</age></user>";
        Logger.json(json);
        Logger.xml(xml);
    }
}
