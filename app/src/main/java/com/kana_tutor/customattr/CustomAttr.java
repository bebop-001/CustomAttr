/*
 *  Copyright 2018 Steven Smith kana-tutor.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *  either express or implied.
 *
 *  See the License for the specific language governing permissions
 *  and limitations under the License.
 */
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
