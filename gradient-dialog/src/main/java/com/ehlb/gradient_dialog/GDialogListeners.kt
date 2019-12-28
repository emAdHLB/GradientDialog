package com.ehlb.gradient_dialog

import android.content.DialogInterface

interface GDialogListeners {
    fun onButton1Listener(dialog: GDialog)
    fun onButton2Listener(dialog: GDialog)
    fun onCloseButtonListener(dialog: GDialog)
    fun onCancelListener(dialog: DialogInterface)
}