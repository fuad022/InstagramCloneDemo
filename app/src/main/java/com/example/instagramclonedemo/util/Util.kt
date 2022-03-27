package com.example.instagramclonedemo.util

import android.content.Context
import android.text.SpannableStringBuilder
import android.util.TypedValue
import androidx.core.text.bold

object Util {

    fun getSpannableText(username: String, commentText: String): String {
        return SpannableStringBuilder()
            .bold { append(username) }
            .append(" ")
            .append(commentText)
            .toString()
    }

    fun dpToPx(dp: Int, context: Context): Int {
        val r = context.resources
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            r.displayMetrics
        ).toInt()
    }
}