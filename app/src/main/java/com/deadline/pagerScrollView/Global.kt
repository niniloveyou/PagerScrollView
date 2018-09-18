package com.deadline.pagerScrollView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import info.hoang8f.android.segmented.SegmentedGroup

/**
 * @author deadline
 * @time 2018/9/18
 */
fun createRadioButton(context: Context, segmentedGroup: SegmentedGroup, id: Int, text: String) {
    val radioButton = LayoutInflater.from(context).inflate(R.layout.widget_segment_radiobutton, null) as RadioButton
    radioButton.id = id
    radioButton.text = text
    val params = RadioGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    params.weight = 1f
    segmentedGroup.addView(radioButton, params)
}