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

import android.content.Context
import android.media.AudioManager
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.view.View
import android.view.View.OnLongClickListener
import java.lang.reflect.Method

class KanaButton(context: Context, attrs: AttributeSet?) : AppCompatButton(context, attrs), OnLongClickListener {
    val onLongClickCallback: Method?
    val cbClass: Class<*>
    val type: String
    val onLongClickName: String?
    companion object {
        private val TAG = KanaButton::class.java.simpleName
        private var audioManager: AudioManager? = null
    }

    init {
        val ta = getContext().obtainStyledAttributes(
                attrs, R.styleable.KanaButton
        )
        val s = ta.getString(R.styleable.KanaButton_style_name)
        type = s ?: "UNDEFINED"
        onLongClickName = ta.getString(R.styleable.KanaButton_on_long_click)
        onLongClickCallback = resolveMethod(context, onLongClickName)
        cbClass = context.javaClass
        if (onLongClickCallback != null) setOnLongClickListener(this)
        ta.recycle()
    }

    private fun resolveMethod(c: Context?, name: String?): Method? {
        var longClick: Method? = null
        if (c != null && name != null) {
            try {
                val m = c.javaClass.getMethod(name, View::class.java)
                if (m.returnType != java.lang.Boolean.TYPE) throw NoSuchMethodException(String.format(
                        "%s:resolveMethod:onLongClick %s must return boolean", TAG, name))
                longClick = m
            }
            catch (e: NoSuchMethodException) {
                e.printStackTrace()
            }
        }
        return longClick
    }

    override fun onLongClick(v: View): Boolean {
        var rv = false
        audioManager = context.getSystemService(
                Context.AUDIO_SERVICE) as AudioManager
        if (onLongClickCallback != null) {
            try {
                rv = onLongClickCallback.invoke(context, v) as Boolean
                audioManager!!.playSoundEffect(AudioManager.FX_KEY_CLICK)
            }
            catch (e: Exception) {
                throw RuntimeException(String.format(
                        "%s:exception on KanaButtonLongClick:%s:%s", TAG, onLongClickName, e.message))
            }
        }
        return rv
    }

}