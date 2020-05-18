package org.jitsi.meet.sdk;


import android.content.Context;
import android.content.Intent;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import org.jitsi.meet.sdk.log.JitsiMeetLogger;

public class VideoApiCall extends ReactContextBaseJavaModule {

    public static final String NAME = "VideoApiCall";
    public Context mContext;

    /**
     * The {@code Log} tag {@code WiFiStatsModule} is to log messages with.
     */
    static final String TAG = NAME;
    public VideoApiCall(ReactApplicationContext reactContext) {
        super(reactContext); //required by React Native
        mContext = reactContext;
    }

    @Override
    //getName is required to define the name of the module represented in JavaScript
    public String getName() {
        return "VideoApiCall";
    }


    @ReactMethod
    public void muteVideo() {
        JitsiMeetLogger.i("Video Muted: " );
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("callVideoApi");
        mContext.sendBroadcast(broadcastIntent.putExtra("callVideoApi", false));
    }

    @ReactMethod
    public void unMuteVideo() {
        JitsiMeetLogger.i("Video UnMuted: ");
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("callVideoApi");
        mContext.sendBroadcast(broadcastIntent.putExtra("callVideoApi", true));
    }

}