package com.kana_tutor.customattr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class KanaButton extends android.support.v7.widget.AppCompatButton {
    private static final String TAG = KanaButton.class.getSimpleName();

    final String type;
    public KanaButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = getContext().obtainStyledAttributes(
                attrs, R.styleable.KanaButton
        );
        String s = ta.getString(R.styleable.KanaButton_style_name);
        type = (s != null) ? s : "UNDEFINED";
        ta.recycle();
    }
}
