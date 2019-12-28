package com.ehlb.gradientdialogexample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ehlb.gradient_dialog.EffectsType;
import com.ehlb.gradient_dialog.GDialog;
import com.ehlb.gradient_dialog.GDialogListeners;

import org.jetbrains.annotations.NotNull;

public class MainActivityJava extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void d1(View view) {
        GDialog gradientDialog = new GDialog(this);

        gradientDialog.withEffect(EffectsType.Fall)
                .setCanceledOnTouchOutside(true)

                .setBackgroundStartColor(R.color.g1_1)
                .setBackgroundEndColor(R.color.g1_2)
                .setCornerRadius(20f)
                .hideCloseButton(false)
                .setCloseIconColor(R.color.whiteColor)

                .setIcon(R.drawable.ic_info)
                .animateIcon(true)
                .setIconColor(R.color.whiteColor)
                .hideIcon(false)

                .setTitle("Title")
                .setTitleTextColor(R.color.whiteColor)
                .hideTitle(false)

                .setContent("Content text")
                .setContentTextColor(R.color.whiteColor)
                .hideContent(false)

                .setButton1Text("OK")
                .setButton1Color(R.color.button1Color)
                .setButton1TextColor(R.color.textColor)
                .setButton1Icon(R.drawable.ic_check)
                .setButton1IconColor(R.color.textColor)
                .hideButton1(false)

                .setButton2Text("Cancel")
                .setButton2Color(R.color.button2Color)
                .setButton2TextColor(R.color.textColor)
                .setButton2Icon(R.drawable.ic_close)
                .setButton2IconColor(R.color.textColor)
                .hideButton2(false)

                .setDialogActionClickListener(new GDialogListeners() {
                    @Override
                    public void onButton1Listener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onButton2Listener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Button 2 clicked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCloseButtonListener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Dialog closed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelListener(@NotNull DialogInterface dialog) {

                    }
                })
                .show();

        if (gradientDialog.getTitleTextView() != null)
            gradientDialog.getTitleTextView().setTextSize(20f);
        if (gradientDialog.getContentTextView() != null)
            gradientDialog.getContentTextView().setTextSize(16f);
    }

    public void d2(View view) {
        new GDialog(this).withEffect(EffectsType.SlideTop)
                .setCanceledOnTouchOutside(true)

                .setBackgroundStartColor(R.color.g2_1)
                .setBackgroundEndColor(R.color.g2_2)
                .setCornerRadius(10f)
                .hideCloseButton(true)
                .setCloseIconColor(R.color.whiteColor)

                .setIcon(R.drawable.ic_info)
                .animateIcon(true)
                .setIconColor(R.color.whiteColor)

                .setTitle("Title")
                .setTitleTextColor(R.color.whiteColor)
                .hideTitle(false)

                .setContent("Content text")
                .setContentTextColor(R.color.whiteColor)

                .setButton1Color(R.color.textColor)
                .setButton1Icon(R.drawable.ic_check)
                .setButton1IconColor(android.R.color.black)

                .hideButton2(true)
                .setDialogActionClickListener(new GDialogListeners() {
                    @Override
                    public void onButton1Listener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onButton2Listener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Button 2 clicked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCloseButtonListener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Dialog closed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelListener(@NotNull DialogInterface dialog) {

                    }
                })
                .show();
    }

    public void d3(View view) {
        new GDialog(this).withEffect(EffectsType.NewsPager)
                .setCanceledOnTouchOutside(true)

                .setBackgroundStartColor(R.color.g3_1)
                .setBackgroundEndColor(R.color.g3_2)
                .setCornerRadius(0f)
                .hideCloseButton(true)

                .setIcon(R.drawable.ic_info)
                .animateIcon(false)
                .setIconColor(android.R.color.black)

                .setTitle("Title")
                .setTitleTextColor(android.R.color.black)

                .hideContent(true)

                .hideButton1(true)

                .hideButton2(true)
                .setDialogActionClickListener(new GDialogListeners() {
                    @Override
                    public void onButton1Listener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onButton2Listener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Button 2 clicked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCloseButtonListener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Dialog closed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelListener(@NotNull DialogInterface dialog) {
                    }
                }).show();
    }

    public void d4(View view) {
        new GDialog(this).withEffect(EffectsType.Shake)
                .setDialogActionClickListener(new GDialogListeners() {
                    @Override
                    public void onButton1Listener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onButton2Listener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Button 2 clicked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCloseButtonListener(@NotNull GDialog dialog) {
                        Toast.makeText(MainActivityJava.this, "Dialog closed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelListener(@NotNull DialogInterface dialog) {

                    }
                })
                .show();
    }
}