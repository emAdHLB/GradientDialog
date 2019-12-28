package com.ehlb.gradient_dialog.effects

import android.animation.ObjectAnimator
import android.view.View

class SlideBottom : BaseEffects() {
    override fun setupAnimation(view: View?) {
        animatorSet?.playTogether(
            ObjectAnimator.ofFloat(view, "translationY", 300f, 0f).setDuration(mDuration),
            ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).setDuration(mDuration * 3 / 2)
        )
    }
}