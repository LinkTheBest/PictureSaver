package com.vk.lincharageniy;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.UINT_PTR;
import com.sun.jna.win32.*;
import javafx.scene.control.Alert;

import java.util.HashMap;

public class WallpaperSetter {

    public interface SPI extends StdCallLibrary {

        //from MSDN article
        long SPI_SETDESKWALLPAPER = 20;
        long SPIF_UPDATEINIFILE = 0x01;
        long SPIF_SENDWININICHANGE = 0x02;

        //Here is the problem
        SPI INSTANCE = (SPI) Native.loadLibrary("user32", SPI.class, new HashMap<String, Object>() {
            {
                put(OPTION_TYPE_MAPPER, W32APITypeMapper.UNICODE);
                put(OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.UNICODE);
            }
        });

        boolean SystemParametersInfo(
                UINT_PTR uiAction,
                UINT_PTR uiParam,
                String pvParam,
                UINT_PTR fWinIni
        );
    }

    public static void setWallpaper(String image_path) {

        String path = image_path;

        System.out.println(path);

        if (path.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("WARNING!");
            alert.setContentText("You did not save image!");
            alert.showAndWait();

        } else {
            SPI.INSTANCE.SystemParametersInfo(
                    new UINT_PTR(SPI.SPI_SETDESKWALLPAPER),
                    new UINT_PTR(0),
                    path,
                    new UINT_PTR(SPI.SPIF_UPDATEINIFILE | SPI.SPIF_SENDWININICHANGE));

        }


    }


}
