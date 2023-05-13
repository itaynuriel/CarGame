package com.example.hw1;

import android.app.Application;
import com.example.hw1.Utilities.signalGenerator;

public class App extends Application {
    public void onCreate(){
        super.onCreate();
        signalGenerator.init(this);
    }
}
