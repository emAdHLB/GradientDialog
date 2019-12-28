package com.ehlb.gradient_dialog.effects

import android.animation.AnimatorSet
import android.view.View

abstract class BaseEffects {
    protected var mDuration = DURATION.toLong()
    var animatorSet: AnimatorSet? = null
    protected abstract fun setupAnimation(view: View?)

    fun start(view: View) {
        reset(view)
        setupAnimation(view)
        animatorSet!!.start()
    }

    private fun reset(view: View) {
        view.pivotX = view.measuredWidth / 2.0f
        view.pivotY = view.measuredHeight / 2.0f
    }

    fun setDuration(duration: Long) {
        mDuration = duration
    }

    companion object {
        private const val DURATION = 700
    }

    init {
        animatorSet = AnimatorSet()
    }
}