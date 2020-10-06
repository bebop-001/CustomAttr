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
package com.kana_tutor.customattr

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

class CustomAttr : AppCompatActivity(), View.OnClickListener {
    companion object {
        private val TAG = CustomAttr::class.java.simpleName
        private lateinit  var toast: Toast
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_attr)
        findViewById<View>(R.id.button_1)
                .setOnClickListener(this)
        findViewById<View>(R.id.button_2)
                .setOnClickListener(this)
        val b3 = findViewById<KanaButton>(R.id.button_3)
        b3.setOnClickListener(this)
        b3.setOnLongClickListener { v ->
            val id = v.id
            val b = v as KanaButton
            val s = "long click:" +
                    (if (id == R.id.button_1) "button 1:" else "button 2:") + b.type
            toast.cancel()
            toast = Toast.makeText(v.getContext(), s, Toast.LENGTH_LONG)
            toast.show()
            true // return true or onClick is also called.
        }
        toast = Toast(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        val b = v as KanaButton
        val s = "short click:" +
                (if (id == R.id.button_1) "button 1:" else "button 2:") + b.type
        toast.cancel()
        toast = Toast.makeText(v.getContext(), s, Toast.LENGTH_LONG)
        toast.show()
    }

    fun blueButtonLongClick(v: View): Boolean {
        val id = v.id
        val b = v as KanaButton
        val s = "long click:" +
                (if (id == R.id.button_1) "button 1:" else "button 2:") + b.type
        toast.cancel()
        toast = Toast.makeText(v.getContext(), s, Toast.LENGTH_LONG)
        toast.show()
        return true // return true or onClick is also called.
    }

    fun redOnLongClick(v: View): Boolean {
        val id = v.id
        val b = v as KanaButton
        val s = "long click:" +
                (if (id == R.id.button_1) "button 1:" else "button 2:") + b.type
        toast.cancel()
        toast = Toast.makeText(v.getContext(), s, Toast.LENGTH_LONG)
        toast.show()
        return true // return true or onClick is also called.
    }
}