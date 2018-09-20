package com.kana_tutor.customattr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
            findViewById(R.id.button_3)
                .setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            KanaButton b = (KanaButton) v;
            Log.d(TAG, String.format("%s:%s"
                    , (id == R.id.button_1) ? "button 1:" : "button 2:", b.type));
        }
    }
