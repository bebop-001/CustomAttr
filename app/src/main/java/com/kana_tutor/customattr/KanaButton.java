package com.kana_tutor.customattr;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

public class KanaButton extends android.support.v7.widget.AppCompatButton {
    private static final String TAG = KanaButton.class.getSimpleName();
    public KanaButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "here:" + attrs.toString());
    }
}
