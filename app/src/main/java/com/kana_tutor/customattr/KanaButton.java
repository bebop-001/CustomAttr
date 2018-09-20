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
