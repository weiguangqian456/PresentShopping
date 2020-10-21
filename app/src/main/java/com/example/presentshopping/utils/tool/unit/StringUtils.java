package com.example.presentshopping.utils.tool.unit;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ZhaoXH on 2017/9/13.
 */

public class StringUtils {
    /**
     * 读取assets下的文件
     * @param context
     * @param fileName
     * @return
     */
    public static String readAssetsTxt(Context context, String fileName){
        try {
            //Return an AssetManager instance for your application's package
            InputStream is = context.getAssets().open(fileName+".txt");
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            String text = new String(buffer, "utf-8");
            // Finally stick the string into the text view.
            return text;
        } catch (IOException e) {
            // Should never happen!
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return "读取错误，请检查文件名";
    }
}
