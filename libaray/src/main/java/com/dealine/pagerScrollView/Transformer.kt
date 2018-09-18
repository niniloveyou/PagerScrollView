package com.dealine.pagerScrollView

/**
 * @author deadline
 * @time 2018/9/18
 */
import android.support.v4.view.ViewPager
import android.view.View

class DefaultTransformer : ViewPager.PageTransformer {

    override fun transformPage(view: View, position: Float) {
    /*    var alpha = 0f
        if (position in 0.0..1.0) {
            alpha = 1 - position
        } else if (-1 < position && position < 0) {
            alpha = position + 1
        }
        view.alpha = alpha*/
        view.translationX = view.width * -position
        val yPosition = position * view.height
        view.translationY = yPosition
    }
}

class StackTransformer : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.translationX = page.width * -position
        page.translationY = if (position < 0) position * page.height else 0f
    }
}


class ZoomOutTransformer : ViewPager.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        val pageWidth = view.width
        val pageHeight = view.height
        var alpha = 0f
        if (position in 0.0..1.0) {
            alpha = 1 - position
        } else if (-1 < position && position < 0) {
            val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
            val verticalMargin = pageHeight * (1 - scaleFactor) / 2
            val horizontalMargin = pageWidth * (1 - scaleFactor) / 2
            if (position < 0) {
                view.translationX = horizontalMargin - verticalMargin / 2
            } else {
                view.translationX = -horizontalMargin + verticalMargin / 2
            }

            view.scaleX = scaleFactor
            view.scaleY = scaleFactor

            alpha = position + 1
        }

        view.alpha = alpha
        view.translationX = view.width * -position
        val yPosition = position * view.height
        view.translationY = yPosition
    }

    companion object {
        private val MIN_SCALE = 0.90f
    }

}