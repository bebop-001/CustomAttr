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
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAttr
        extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = CustomAttr.class.getSimpleName();

    private static Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_attr);
        findViewById(R.id.button_1)
            .setOnClickListener(this);
        findViewById(R.id.button_2)
            .setOnClickListener(this);
        KanaButton b3 = findViewById(R.id.button_3);
            b3.setOnClickListener(this);
            b3.setOnLongClickListener(new OnLongClickListener(){
                @Override
                public boolean onLongClick(View v) {
                    int id = v.getId();
                    KanaButton b = (KanaButton) v;
                    String s = "long click:" +
                            ((id == R.id.button_1) ? "button 1:" : "button 2:") + b.type;
                    toast.cancel();
                    toast = Toast.makeText(v.getContext()
                            , s, Toast.LENGTH_LONG);
                    toast.show();
                    return true; // return true or onClick is also called.
                }
            });
        toast = new Toast(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        KanaButton b = (KanaButton) v;
        String s = "short click:" +
                ((id == R.id.button_1) ? "button 1:" : "button 2:") + b.type;
        toast.cancel();
        toast = Toast.makeText(v.getContext()
                , s, Toast.LENGTH_LONG);
        toast.show();
    }
    public boolean blueButtonLongClick(View v) {
        int id = v.getId();
        KanaButton b = (KanaButton) v;
        String s = "long click:" +
                ((id == R.id.button_1) ? "button 1:" : "button 2:") + b.type;
        toast.cancel();
        toast = Toast.makeText(v.getContext()
                , s, Toast.LENGTH_LONG);
        toast.show();
        return true; // return true or onClick is also called.
    }
    public boolean redOnLongClick(View v) {
        int id = v.getId();
        KanaButton b = (KanaButton) v;
        String s = "long click:" +
                ((id == R.id.button_1) ? "button 1:" : "button 2:") + b.type;
        toast.cancel();
        toast = Toast.makeText(v.getContext()
                , s, Toast.LENGTH_LONG);
        toast.show();
        return true; // return true or onClick is also called.
    }
}
