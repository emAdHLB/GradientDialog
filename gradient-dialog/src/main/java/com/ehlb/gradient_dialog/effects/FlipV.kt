package com.ehlb.gradient_dialog.effects

import android.animation.ObjectAnimator
import android.view.View

class FlipV : BaseEffects() {
    override fun setupAnimation(view: View?) {
        animatorSet?.playTogether(
            ObjectAnimator.ofFloat(view, "rotationX", -90f, 0f).setDuration(mDuration)
        )
    }
}