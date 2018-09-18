package com.deadline.pagerScrollView

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.dealine.pagerScrollView.ObservableScrollView
import info.hoang8f.android.segmented.SegmentedGroup

class ScrollLinkTabActivity : AppCompatActivity() {

    private var checkByScroll = false
    private lateinit var scrollView: ObservableScrollView
    private lateinit var segmentedGroup: SegmentedGroup
    private lateinit var firstLayout: LinearLayout
    private lateinit var secondLayout: LinearLayout
    private lateinit var thirdLayout: LinearLayout
    private lateinit var toolbarLayout: LinearLayout
    private lateinit var rootLayout : RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_tab)

        toolbarLayout = findViewById(R.id.toolbarContainer)
        rootLayout = findViewById(R.id.root_layout)
        scrollView = findViewById(R.id.scrollView)
        segmentedGroup = findViewById(R.id.segment)
        firstLayout = findViewById(R.id.firstContainer)
        secondLayout = findViewById(R.id.secondContainer)
        thirdLayout = findViewById(R.id.thirdContainer)

        createRadioButton(this, segmentedGroup, R.id.product_attribute, "section one")
        createRadioButton(this, segmentedGroup, R.id.product_sale, "section two")
        createRadioButton(this, segmentedGroup, R.id.product_other, "section three")

        segmentedGroup.weightSum = 3f
        segmentedGroup.updateBackground()
        segmentedGroup.check(R.id.product_attribute)

        val scrollListener = ObservableScrollView.ScrollViewListener { _, _, y, _, _ ->
            var index = R.id.product_attribute
            if (y <= firstLayout.measuredHeight) {
                index = R.id.product_attribute
            } else if (y <= firstLayout.measuredHeight + secondLayout.measuredHeight) {
                index = R.id.product_sale
            } else {
                index = R.id.product_other
            }

            if (segmentedGroup.checkedRadioButtonId != index) {
                checkByScroll = true
                segmentedGroup.check(index)
                segmentedGroup.updateBackground()
                checkByScroll = false
            }
        }

        scrollView.setScrollViewListener(scrollListener)


        segmentedGroup.setOnCheckedChangeListener { group, checkedId ->
            if (!checkByScroll) {
                scrollView.setNotifyEnable(false)
                if (checkedId == R.id.product_attribute) {
                    scrollView.smoothScrollTo(0, 0)
                } else if (checkedId == R.id.product_sale) {
                    scrollView.smoothScrollTo(0, firstLayout.measuredHeight)
                } else {
                    scrollView.smoothScrollTo(0, firstLayout.measuredHeight + secondLayout.measuredHeight)
                }

                scrollView.postDelayed({
                    scrollView.setNotifyEnable(true)
                }, 250)
            }
        }

        // 设置第三个页面的高度，使得撑满一屏
        val globalListener = object : ViewTreeObserver.OnGlobalLayoutListener {

            override fun onGlobalLayout() {
                val params = thirdLayout.layoutParams as LinearLayout.LayoutParams
                val lastH = rootLayout.measuredHeight - toolbarLayout.height
                if (thirdLayout.height < lastH) {
                    params.height = lastH
                    thirdLayout.layoutParams = params
                }

                if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
                    thirdLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
                } else {
                    thirdLayout.viewTreeObserver.removeGlobalOnLayoutListener(this)
                }
            }
        }
        thirdLayout.viewTreeObserver.addOnGlobalLayoutListener(globalListener)
    }
}
