package com.ehlb.gradient_dialog.effects

import android.animation.ObjectAnimator
import android.view.View

class Fall : BaseEffects() {
    override fun setupAnimation(view: View?) {
        animatorSet?.playTogether(
            ObjectAnimator.ofFloat(view, "scaleX", 2f, 1.5f, 1f).setDuration(mDuration),
            ObjectAnimator.ofFloat(view, "scaleY", 2f, 1.5f, 1f).setDuration(mDuration),
            ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).setDuration(mDuration * 3 / 2)
        )
    }
}