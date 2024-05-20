package com.nativemodulesexample;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;
import android.util.Log;

public class MyExampleModule extends ReactContextBaseJavaModule {
    MyExampleModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "MyExampleModule";
    }

    @ReactMethod
    public void exampleMethod() {
        //This is where you call the native method or code for your native android library
        Log.d("MyExampleModule", "ExampleMethod called");
    }
}