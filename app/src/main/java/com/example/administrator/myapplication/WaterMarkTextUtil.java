package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;

public class WaterMarkTextUtil {
    //设置背景
    public static void setWaterMarkTextBg(View view, Context gContext, String gText) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawTextToBitmap(gContext.getApplicationContext(), gText));
        } else {
            view.setBackgroundDrawable(drawTextToBitmap(gContext.getApplicationContext(), gText));
        }
    }
    //设置背景
    public static void setWaterMarkTextBg(View view, Context gContext, String gText, Bitmap srcBitmap) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawTextToBitmap(gContext.getApplicationContext(), gText, srcBitmap));
        } else {
            view.setBackgroundDrawable(drawTextToBitmap(gContext.getApplicationContext(), gText,srcBitmap));
        }
    }
    public static BitmapDrawable drawTextToBitmap(Context gContext, String gText) {
        Bitmap bitmap = Bitmap.createBitmap(420, 240, Bitmap.Config.ARGB_4444);
        return  drawTextToBitmap(gContext, gText,bitmap);
    }
    /**
     * 生成水印文字图片
     */
    public static BitmapDrawable drawTextToBitmap(Context gContext, String gText, Bitmap srcBitmap) {
      /*  if (ACache.get(gContext).getAsBitmap(gText) != null) {
            BitmapDrawable drawable = new BitmapDrawable(ACache.get(gContext).getAsBitmap(gText));
            drawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            drawable.setDither(true);
            return drawable;
        }*/
        try {
            Bitmap bitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            //canvas.drawColor(Color.WHITE);
            canvas.drawBitmap(srcBitmap,0,0, null);

            Paint paint = new Paint();
            paint.setColor(0x0f888888);
            paint.setAlpha(80);
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(30);

            Path path = new Path();
            path.moveTo(30, 150);
            path.lineTo(160 * 2, 0);
            canvas.drawTextOnPath(gText, path, 0, 20, paint);
            canvas.save(Canvas.ALL_SAVE_FLAG);
            canvas.restore();
            ACache.get(gContext).put(gText, bitmap);
            //srcBitmap.recycle();
            BitmapDrawable drawable = new BitmapDrawable(ACache.get(gContext).getAsBitmap(gText));
            /*drawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            drawable.setDither(true);*/
            return drawable;
        } catch (Exception e) {
//            Log.e("WaterMarkTextUtil","-gnt->drawTextToBitmap error msg:" + CrashHandler.getInstance().getCrashReport(e));
        }
        return null;
    }
}