package com.ehlb.gradient_dialog.effects

import android.animation.ObjectAnimator
import android.view.View

class Slit : BaseEffects() {
    override fun setupAnimation(view: View?) {
        animatorSet?.playTogether(
            ObjectAnimator.ofFloat(
                view,
                "rotationY",
                90f,
                88f,
                88f,
                45f,
                0f
            ).setDuration(mDuration),
            ObjectAnimator.ofFloat(
                view,
                "alpha",
                0f,
                0.4f,
                0.8f,
                1f
            ).setDuration(mDuration * 3 / 2),
            ObjectAnimator.ofFloat(view, "scaleX", 0f, 0.5f, 0.9f, 0.9f, 1f).setDuration(mDuration),
            ObjectAnimator.ofFloat(view, "scaleY", 0f, 0.5f, 0.9f, 0.9f, 1f).setDuration(mDuration)
        )
    }
}