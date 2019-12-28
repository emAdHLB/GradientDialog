package com.ehlb.gradient_dialog.effects

import android.animation.ObjectAnimator
import android.view.View

class SideFall : BaseEffects() {
    override fun setupAnimation(view: View?) {
        animatorSet?.playTogether(
            ObjectAnimator.ofFloat(view, "scaleX", 2f, 1.5f, 1f).setDuration(mDuration),
            ObjectAnimator.ofFloat(view, "scaleY", 2f, 1.5f, 1f).setDuration(mDuration),
            ObjectAnimator.ofFloat(view, "rotation", 25f, 0f).setDuration(mDuration),
            ObjectAnimator.ofFloat(view, "translationX", 80f, 0f).setDuration(mDuration),
            ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).setDuration(mDuration * 3 / 2)
        )
    }
}