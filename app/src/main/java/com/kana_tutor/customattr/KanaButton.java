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

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Method;

public class KanaButton extends android.support.v7.widget.AppCompatButton
        implements View.OnLongClickListener {
    private static final String TAG = KanaButton.class.getSimpleName();

    private Method resolveMethod(Context c, String name) {
        Method longClick = null;
        if (c != null && name != null) {
            try {
                Method m = c.getClass().getMethod(name, View.class);
                if (!m.getReturnType().equals(Boolean.TYPE))
                    throw new NoSuchMethodException(String.format(
                        "%s:resolveMethod:onLongClick %s must return boolean"
                            , TAG, name)
                    );
                longClick = m;
            }
            catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return longClick;
    }

    final Method onLongClickCallback;
    final Class cbClass;
    final String type, onLongClickName;
    public KanaButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = getContext().obtainStyledAttributes(
                attrs, R.styleable.KanaButton
        );
        String s = ta.getString(R.styleable.KanaButton_style_name);
        type = (s != null) ? s : "UNDEFINED";
        onLongClickName = ta.getString(R.styleable.KanaButton_on_long_click);
        onLongClickCallback = resolveMethod(context, onLongClickName);
        cbClass = context.getClass();
        if (onLongClickCallback != null)
            setOnLongClickListener(this);
        ta.recycle();
    }

    @Override
    public boolean onLongClick(View v) {
        boolean rv = false;
        if (onLongClickCallback != null) {
            try {
                rv = (boolean)onLongClickCallback.invoke(getContext(), v);
            }
            catch (Exception e) {
                throw new RuntimeException(String.format(
                        "%s:exception on KanaButtonLongClick:%s:%s"
                    , TAG, onLongClickName, e.getMessage())
                );
            }
        }
        return rv;
    }
}
