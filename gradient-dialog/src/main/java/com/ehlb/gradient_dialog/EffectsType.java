package com.ehlb.gradient_dialog;

import com.ehlb.gradient_dialog.effects.BaseEffects;
import com.ehlb.gradient_dialog.effects.FadeIn;
import com.ehlb.gradient_dialog.effects.Fall;
import com.ehlb.gradient_dialog.effects.FlipH;
import com.ehlb.gradient_dialog.effects.FlipV;
import com.ehlb.gradient_dialog.effects.NewsPaper;
import com.ehlb.gradient_dialog.effects.RotateBottom;
import com.ehlb.gradient_dialog.effects.RotateLeft;
import com.ehlb.gradient_dialog.effects.Shake;
import com.ehlb.gradient_dialog.effects.SideFall;
import com.ehlb.gradient_dialog.effects.SlideBottom;
import com.ehlb.gradient_dialog.effects.SlideLeft;
import com.ehlb.gradient_dialog.effects.SlideRight;
import com.ehlb.gradient_dialog.effects.SlideTop;
import com.ehlb.gradient_dialog.effects.Slit;

public enum EffectsType {
    FadeIn(FadeIn.class),
    SlideLeft(SlideLeft.class),
    SlideTop(SlideTop.class),
    SlideBottom(SlideBottom.class),
    SlideRight(SlideRight.class),
    Fall(Fall.class),
    NewsPager(NewsPaper.class),
    FlipH(FlipH.class),
    FlipV(FlipV.class),
    RotateBottom(RotateBottom.class),
    RotateLeft(RotateLeft.class),
    Slit(Slit.class),
    Shake(Shake.class),
    SideFill(SideFall.class);
    private Class<? extends BaseEffects> effectsClazz;

    EffectsType(Class<? extends BaseEffects> mClass) {
        effectsClazz = mClass;
    }

    public BaseEffects getAnimator() {
        BaseEffects bEffects;
        try {
            bEffects = effectsClazz.newInstance();
        } catch (ClassCastException e) {
            throw new Error("Can not init animatorClazz instance");
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            throw new Error("Can not init animatorClazz instance");
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            throw new Error("Can not init animatorClazz instance");
        }
        return bEffects;
    }
}