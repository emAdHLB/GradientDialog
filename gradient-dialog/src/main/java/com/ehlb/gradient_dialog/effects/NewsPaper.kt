package com.ehlb.gradient_dialog.effects

import android.animation.ObjectAnimator
import android.view.View

class NewsPaper : BaseEffects() {
    override fun setupAnimation(view: View?) {
        animatorSet?.playTogether(
            ObjectAnimator.ofFloat(view, "rotation", 1080f, 720f, 360f, 0f).setDuration(mDuration),
            ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).setDuration(mDuration * 3 / 2),
            ObjectAnimator.ofFloat(view, "scaleX", 0.1f, 0.5f, 1f).setDuration(mDuration),
            ObjectAnimator.ofFloat(view, "scaleY", 0.1f, 0.5f, 1f).setDuration(mDuration)
        )
    }
}