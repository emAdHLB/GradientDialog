package com.ehlb.gradient_dialog.effects

import android.animation.ObjectAnimator
import android.view.View

class FlipH : BaseEffects() {
    override fun setupAnimation(view: View?) {
        animatorSet?.playTogether(
            ObjectAnimator.ofFloat(view, "rotationY", -90f, 0f).setDuration(mDuration)
        )
    }
}