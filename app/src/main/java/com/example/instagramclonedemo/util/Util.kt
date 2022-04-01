package com.example.instagramclonedemo.util

import android.annotation.SuppressLint
import android.content.Context
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.text.HtmlCompat
import androidx.core.text.bold

object Util {

//    fun getSpannableText(username: String, commentText: String): String {
//        return SpannableStringBuilder()
//            .bold { append(username) }
//            .append(" ")
//            .append(commentText)
//            .toString()
//    }

    fun getStr(s: String): Spanned = HtmlCompat.fromHtml(s, HtmlCompat.FROM_HTML_MODE_LEGACY)

    fun dpToPx(dp: Int, context: Context): Int {
        val r = context.resources
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            r.displayMetrics
        ).toInt()
    }
}