package com.vk.lincharageniy;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;

public class WallpaperSetter {

    public static interface User32 extends Library {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

        boolean SystemParametersInfo(int one, int two, String s, int three);
    }

    public static void setWallpaper(String image_url) {
        User32.INSTANCE.SystemParametersInfo(0x0014, 0, image_url, 1);

    }


}
