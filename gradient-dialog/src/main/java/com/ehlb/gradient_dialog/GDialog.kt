package com.ehlb.gradient_dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.ehlb.gradient_dialog.effects.BaseEffects
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.view_dialog.*

class GDialog(private val mContext: Context) {
    private val mDialog: Dialog?
    private var gDialogListener: GDialogListeners? = null
    private var dialogMainLayout: ConstraintLayout? = null
    private var dialogLayout: RelativeLayout? = null
    private var imageViewCloseButton: ImageView? = null
    private var imageViewIcon: ImageView? = null
    private var textViewTitle: TextView? = null
    private var textViewContent: TextView? = null
    private var button1: MaterialButton? = null
    private var button2: MaterialButton? = null

    private var backgroundStartColor: Int = R.color.dialog_bg_start_color
    private var backgroundEndColor: Int = R.color.dialog_bg_end_color
    private var closeIconColor: Int = R.color.colorWhite
    private var iconTintColor: Int = R.color.colorWhite
    private var titleTextColor: Int = R.color.colorWhite
    private var contentTextColor: Int = R.color.colorWhite
    private var button1Color: Int = R.color.color_success
    private var button2Color: Int = R.color.colorError
    private var button1TextColor: Int = R.color.colorWhite
    private var button2TextColor: Int = R.color.colorWhite
    private var button1IconColor: Int = R.color.colorWhite
    private var button2IconColor: Int = R.color.colorWhite

    private var cornerRadius: Float = 50f
    private var hideCloseButton: Boolean = false
    private var iconResource = R.drawable.ic_success
    private var animateIcon: Boolean = true
    private var hideIcon: Boolean = false
    private var hideTitle: Boolean = false
    private var hideContent: Boolean = false
    private var titleText: String = ""
    private var contentText: String = ""
    private var button1Icon: Int = R.drawable.ic_check
    private var button2Icon: Int = R.drawable.ic_close
    private var hideButton1 = false
    private var hideButton2 = false
    private var button1Text: String? = ""
    private var button2Text: String? = ""
    private var type: EffectsType? = null
    private var cancelledOnTouchOutside: Boolean = false

    init {
        mDialog = Dialog(mContext, R.style.eDialogTheme)
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog.setContentView(R.layout.view_dialog)
    }

    fun show(): GDialog {
        if (mDialog != null) {
            initiateAllViews()
            initiateListeners()

            val gd = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                    ContextCompat.getColor(mContext, backgroundStartColor),
                    ContextCompat.getColor(mContext, backgroundEndColor)
                )
            )
            gd.cornerRadius = cornerRadius
            dialogMainLayout?.background = gd

            imageViewIcon?.setImageResource(iconResource)
            imageViewCloseButton?.visibility = if (hideCloseButton) View.GONE else View.VISIBLE
            imageViewIcon?.visibility = if (hideIcon) View.GONE else View.VISIBLE
            imageViewIcon?.setColorFilter(
                ContextCompat.getColor(mContext, iconTintColor),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            imageViewCloseButton?.setColorFilter(
                ContextCompat.getColor(mContext, closeIconColor),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            if (animateIcon) {
                val pulse: Animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_pulse)
                imageViewIcon?.animation = pulse
            }

            textViewTitle.let {
                it?.text = titleText
                it?.visibility = if (hideTitle) View.GONE else View.VISIBLE
                it?.setTextColor(ContextCompat.getColor(mContext, titleTextColor))
            }
            textViewContent.let {
                it?.text = contentText
                it?.visibility = if (hideContent) View.GONE else View.VISIBLE
                it?.setTextColor(ContextCompat.getColor(mContext, contentTextColor))
            }

            button1?.let {
                it.setBackgroundColor(ContextCompat.getColor(mContext, button1Color))
                it.text = button1Text ?: mContext.getString(android.R.string.ok)
                it.setTextColor(ContextCompat.getColor(mContext, button1TextColor))
                it.setIconResource(button1Icon)
                it.setIconTintResource(button1IconColor)
                it.visibility = if (hideButton1) View.GONE else View.VISIBLE
                if (button1Text?.length ?: 1 < 0) button1?.iconPadding = 0
            }
            button2?.let {
                it.setBackgroundColor(ContextCompat.getColor(mContext, button2Color))
                it.text = button2Text ?: mContext.getString(android.R.string.cancel)
                it.setTextColor(ContextCompat.getColor(mContext, button2TextColor))
                it.setIconResource(button2Icon)
                it.setIconTintResource(button2IconColor)
                it.visibility = if (hideButton2) View.GONE else View.VISIBLE
                if (button2Text == "") button2?.iconPadding = 0
            }

            mDialog.setCanceledOnTouchOutside(cancelledOnTouchOutside)
            mDialog.setOnShowListener {
                if (type == null) {
                    type = EffectsType.SlideTop
                }
                start(type)
            }
            mDialog.show()

            val layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(mDialog.window?.attributes)
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
            mDialog.window?.attributes = layoutParams
        }
        return this
    }

    fun setBackgroundStartColor(startColor: Int): GDialog {
        this.backgroundStartColor = startColor
        return this
    }

    fun setBackgroundEndColor(endColor: Int): GDialog {
        this.backgroundEndColor = endColor
        return this
    }

    fun setTitle(title: String): GDialog {
        this.titleText = title
        return this
    }

    fun hideTitle(hideTitle: Boolean): GDialog {
        this.hideTitle = hideTitle
        return this
    }

    fun setContent(title: String): GDialog {
        this.contentText = title
        return this
    }

    fun hideContent(hideContent: Boolean): GDialog {
        this.hideContent = hideContent
        return this
    }

    fun setCloseIconColor(color: Int): GDialog {
        this.closeIconColor = color
        return this
    }

    fun setIconColor(iconColor: Int): GDialog {
        this.iconTintColor = iconColor
        return this
    }

    fun setTitleTextColor(color: Int): GDialog {
        this.titleTextColor = color
        return this
    }

    fun setContentTextColor(color: Int): GDialog {
        this.contentTextColor = color
        return this
    }

    fun setIcon(iconResource: Int): GDialog {
        this.iconResource = iconResource
        return this
    }

    fun animateIcon(animate: Boolean): GDialog {
        this.animateIcon = animate
        return this
    }

    fun hideCloseButton(hideCloseButton: Boolean): GDialog {
        this.hideCloseButton = hideCloseButton
        return this
    }

    fun hideIcon(hideIcon: Boolean): GDialog {
        this.hideIcon = hideIcon
        return this
    }

    fun hideButton1(hide: Boolean): GDialog {
        this.hideButton1 = hide
        return this
    }

    fun setButton1Text(text: String): GDialog {
        this.button1Text = text
        return this
    }

    fun setButton1TextColor(color: Int): GDialog {
        this.button1TextColor = color
        return this
    }

    fun setButton1Icon(iconRes: Int): GDialog {
        this.button1Icon = iconRes
        return this
    }

    fun setButton1IconColor(b1IconColor: Int): GDialog {
        this.button1IconColor = b1IconColor
        return this
    }

    fun setButton1Color(color: Int): GDialog {
        this.button1Color = color
        return this
    }

    fun hideButton2(hide: Boolean): GDialog {
        this.hideButton2 = hide
        return this
    }

    fun setButton2Text(text: String): GDialog {
        this.button2Text = text
        return this
    }

    fun setButton2TextColor(color: Int): GDialog {
        this.button2TextColor = color
        return this
    }

    fun setButton2Icon(iconRes: Int): GDialog {
        this.button2Icon = iconRes
        return this
    }

    fun setButton2IconColor(b1IconColor: Int): GDialog {
        this.button2IconColor = b1IconColor
        return this
    }

    fun setButton2Color(color: Int): GDialog {
        this.button2Color = color
        return this
    }

    fun getTitleTextView(): TextView? {
        return textViewTitle
    }

    fun getContentTextView(): TextView? {
        return textViewContent
    }

    fun setDialogActionClickListener(gDialogListener: GDialogListeners): GDialog {
        this.gDialogListener = gDialogListener
        return this
    }

    fun setCanceledOnTouchOutside(cancelledOnTouchOutside: Boolean): GDialog {
        this.cancelledOnTouchOutside = cancelledOnTouchOutside
        return this
    }

    fun setCornerRadius(cornerRadius: Float): GDialog {
        this.cornerRadius = cornerRadius
        return this
    }

    fun withEffect(type: EffectsType?): GDialog {
        this.type = type
        return this
    }

    private fun initiateAllViews() {
        dialogMainLayout = mDialog?.dialogLayout
        dialogLayout = mDialog?.dialog_main
        imageViewCloseButton = mDialog?.dialogCloseButton
        imageViewIcon = mDialog?.dialogIcon
        textViewTitle = mDialog?.dialogTitle
        textViewContent = mDialog?.textViewContent
        button1 = mDialog?.dialogButton1
        button2 = mDialog?.dialogButton2
    }

    private fun initiateListeners() {
        imageViewCloseButton?.setOnClickListener { this.onCloseButtonListener(it) }

        dialogLayout?.setOnClickListener {
            if (cancelledOnTouchOutside) this.onCloseButtonListener(
                it
            )
        }

        button1?.setOnClickListener { this.onButton1ClickedListener(it) }

        button2?.setOnClickListener { this.onButton2ClickedListener(it) }

        mDialog?.setOnCancelListener { this.onCancelListener(it) }
    }

    private fun dismiss() {
        mDialog?.dismiss()
    }

    private fun onButton1ClickedListener(view: View) {
        if (gDialogListener != null) {
            gDialogListener?.onButton1Listener(this)
        }
    }

    private fun onButton2ClickedListener(view: View) {
        if (gDialogListener != null) {
            gDialogListener?.onButton2Listener(this)
        }
    }

    private fun onCancelListener(dialog: DialogInterface) {
        if (gDialogListener != null) {
            gDialogListener?.onCancelListener(dialog)
        }
    }

    private fun onCloseButtonListener(view: View) {
        if (gDialogListener != null) {
            gDialogListener?.onCloseButtonListener(this)
            dismiss()
        }
    }

    private fun start(type: EffectsType?) {
        val animator: BaseEffects? = type?.animator
        dialogMainLayout?.let { animator?.start(it) }
    }
}