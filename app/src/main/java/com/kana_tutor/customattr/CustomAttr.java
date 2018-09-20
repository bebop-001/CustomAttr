package com.kana_tutor.customattr;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

    public class CustomAttr
            extends AppCompatActivity implements View.OnClickListener{
        private static final String TAG = CustomAttr.class.getSimpleName();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.custom_attr);
            findViewById(R.id.button_1)
                .setOnClickListener(this);
            findViewById(R.id.button_2)
                .setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            int [] attrs = {R.attr.style_name};
            TypedArray ta = v.getContext().obtainStyledAttributes(
                    R.style.red_button, attrs);
            Log.d(TAG, "ta:" + ta.toString());
            // boolean isRed = ta.getBoolean(R.styleable.red_button_is_red, false);
            String s = ta.getString(R.styleable.red_button_style_name);
            Log.d(TAG, String.format("%s:%s"
                , (id == R.id.button_1) ? "button 1:" : "button 2:"
                , s )
            );
        }
    }
