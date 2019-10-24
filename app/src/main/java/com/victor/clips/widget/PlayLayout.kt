package com.victor.clips.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.victor.clips.util.ViewAttributeUtil

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: PlayLayout.java
 * Author: Victor
 * Date: 2019/10/22 17:15
 * Description:
 * -----------------------------------------------------------------
 */
class PlayLayout: FrameLayout {
    private var mLastX: Int = 0
    private var mLastY: Int = 0

    constructor(context: Context) : this(context,null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs,0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var x = event?.getX()?.toInt()
        var y = event?.getY()?.toInt()

        when (event?.getAction()) {
            MotionEvent.ACTION_DOWN -> {
                mLastX = x!!
                mLastY = y!!
            }

            MotionEvent.ACTION_MOVE -> {
                var offsetX = x!! - mLastX
                var offsetY = y!! - mLastY

                layout(left + offsetX,
                        (top + offsetY),
                        (right + offsetX),
                        (bottom + offsetY))
            }

            else -> {
            }
        }
        return true
    }
}