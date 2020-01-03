# GradientDialog - Android

[![Developer](https://img.shields.io/badge/Developer-eHLB-%23117243?style=for-the-badge)](https://github.com/Nightonke)
[![Platform](https://img.shields.io/badge/Platform-Android-%117243?style=for-the-badge)](https://www.android.com)
[![SDK](https://img.shields.io/badge/SKD-17+-%231771F1?style=for-the-badge)](https://www.android.com)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

A fully customizable Android dialog

## Preview

<img src="https://github.com/emAdHLB/GradientDialog-Android/blob/master/images/3.gif" width="300">

## Download
[![](https://jitpack.io/v/emAdHLB/GradientDialog.svg)](https://jitpack.io/#emAdHLB/GradientDialog)

-  Gradle

Step 1. Add the JitPack repository to your build file
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency

```gradle

dependencies {
	        implementation 'com.github.emAdHLB:GradientDialog:0.1.0'
	}
```

#### or

- Maven

 Step 1. Add the JitPack repository to your build file 
 
 ```maven
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
Step 2. Add the dependency

  ```maven
	<dependency>
	    <groupId>com.github.emAdHLB</groupId>
	    <artifactId>GradientDialog</artifactId>
	    <version>0.1.0</version>
	</dependency>
```
## Usage

[![Hits-of-Code](https://hitsofcode.com/github/emAdHLB/GradientDialog)](https://hitsofcode.com/view/github/emAdHLB/GradientDialog)

- Kotlin

```kotlin
        val gradientDialog = GDialog(this)

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

            .setDialogActionClickListener(object : GDialogListeners {
                override fun onButton1Listener(dialog: GDialog) {
                    Toast.makeText(this@MainActivityKotlin, "Button 1 clicked", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onButton2Listener(dialog: GDialog) {
                    Toast.makeText(this@MainActivityKotlin, "Button 2 clicked", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onCloseButtonListener(dialog: GDialog) {
                    Toast.makeText(this@MainActivityKotlin, "Dialog closed", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onCancelListener(dialog: DialogInterface) {
                }
            })
            .show()
//More customize options
        gradientDialog.getTitleTextView()?.textSize = 20f
        gradientDialog.getContentTextView()?.textSize = 16f
```

- Java

```java
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

//More customize options
        if (gradientDialog.getTitleTextView() != null)
            gradientDialog.getTitleTextView().setTextSize(20f);
        if (gradientDialog.getContentTextView() != null)
            gradientDialog.getContentTextView().setTextSize(16f);
```

Effects 

`FadeIn` | `SlideLeft` | `SlideTop` | `SlideBottom` | `SlideRight` | `Fall` | `NewsPager` | `FlipH` | `FlipV` | `RotateBottom` | `RotateLeft` | `Slit` | `Shake` | `SideFill`

## Author

Emad Alhalabi: [@emAd_HLB](https://twitter.com/emAd_HLB)

Let me know what you think: [ehlb.dev@gmail.com](mailto:ehlb.dev@gmail.com)

Contributions are welcome!

## License

<pre>
Copyright (c) 2019 Emad Alhalabi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
</pre>
