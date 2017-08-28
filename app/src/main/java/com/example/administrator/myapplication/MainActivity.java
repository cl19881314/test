package com.example.administrator.myapplication;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    LinearLayout rotationLL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        rotationLL = (LinearLayout) findViewById(R.id.rotationLL);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
      /*  LinearLayout callTitleLL = (LinearLayout) findViewById(R.id.callTitleMeLL);
        LinearLayout pingLunTitleLL = (LinearLayout) findViewById(R.id.pingLunTitleLL);
        LinearLayout xiaoXiTitleLL = (LinearLayout) findViewById(R.id.xiaoXiTitleLL);

        LinearLayout callMeContentLL = (LinearLayout) findViewById(R.id.callMeContentLL);
        LinearLayout pinLunContentLL = (LinearLayout) findViewById(R.id.pingLunContentLL);
        SwipeMenuListView xiaoXiContentLv = (SwipeMenuListView) findViewById(R.id.messageSMLv);

        MyScrollView scrollView = (MyScrollView) findViewById(R.id.MyScrollView);
        scrollView.setMyTitleView(callTitleLL, pingLunTitleLL, xiaoXiTitleLL);
        scrollView.setMyScrollSizeView(callMeContentLL, pinLunContentLL, xiaoXiContentLv);

        SwipeMenuListView smlv = (SwipeMenuListView) findViewById(R.id.messageSMLv);
        smlv.setAdapter(new MyAdapter());
        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(getApplicationContext());
                Drawable drawable = MainActivity.this.getResources().getDrawable(R.mipmap.delete_bg);
                deleteItem.setBackground(drawable);
                deleteItem.setWidth(320);
                deleteItem.setIcon(R.mipmap.delete_icon);
                menu.addMenuItem(deleteItem);
            }
        };
        // set creator
        smlv.setMenuCreator(creator);
        smlv.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                if (index == 0){
                    Toast.makeText(MainActivity.this, "删除操作。。。。", 0).show();
                }
                return false;
            }
        });*/

    }

    private void getDataFormNet(){
        try {
            URL url= new URL("http://www.bjtime.cn");//取得资源对象
            URLConnection uc= null;//生成连接对象
            uc = url.openConnection();
            uc.connect(); //发出连接
            long ld = uc.getDate(); //取得网站日期时间
            Date date = new Date(ld); //转换为标准时间对象
            //分别取得时间中的小时，分钟和秒，并输出
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Log.e("chen", "时间：" + sdf.format(date));
            Log.e("chen", "时间："+date.getHours()+"时"+date.getMinutes()+"分"+date.getSeconds()+"秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private class  MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
//            if (view == null){
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.message_item, viewGroup, false);
//            }
            return view;
        }
    }
}
