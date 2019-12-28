package com.ehlb.gradient_dialog.effects

import android.animation.ObjectAnimator
import android.view.View

class FadeIn : BaseEffects() {
    override fun setupAnimation(view: View?) {
        animatorSet?.playTogether(
            ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).setDuration(mDuration)
        )
    }
}