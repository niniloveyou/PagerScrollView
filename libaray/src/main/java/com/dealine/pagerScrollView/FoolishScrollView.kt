package com.dealine.pagerScrollView

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView

/**
 * @author deadline
 * @time 2018/9/18
 */
class FoolishScrollView(context: Context, attrs: AttributeSet? = null) : ScrollView(context, attrs) {

    private var mCanScroll = true
    private var mDownY = 0f

    override fun onTouchEvent(ev: MotionEvent?): Boolean {

        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                mDownY = ev.y
            }

            MotionEvent.ACTION_MOVE -> {
                //滑到顶部或底部
                if ((scrollY == 0 && mDownY <= ev.y)
                        || (getChildAt(0).measuredHeight == (scrollY + height) && mDownY >= ev.y)) {
                    mCanScroll = false
                }
            }

            MotionEvent.ACTION_CANCEL,
            MotionEvent.ACTION_UP -> {
                mCanScroll = true
            }
        }

        if (mCanScroll) {
            parent.requestDisallowInterceptTouchEvent(true)
            return super.onTouchEvent(ev)
        } else {
            parent.requestDisallowInterceptTouchEvent(false)
            return false
        }
    }
}
