package com.example.administrator.myapplication.getcitys;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.myapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ChenHong on 2017/5/16.
 */

public class GetOrderCitysActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_layout);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String cityJson = getCity();
                try {
                    JSONArray cityArray = new JSONArray(cityJson);
                    StringBuilder sb = new StringBuilder();
                    sb.append("[");
                    ArrayList<String> letters = new ArrayList<String>();
//                    "A","B","C","D","E","F","G","H","I","J","K","L","M","N","P","Q","R","S","T","U","W","X","Y","Z"
                    letters.add("A");
                    letters.add("B");
                    letters.add("C");
                    letters.add("D");
                    letters.add("E");
                    letters.add("F");
                    letters.add("G");
                    letters.add("H");
                    letters.add("I");
                    letters.add("J");
                    letters.add("K");
                    letters.add("L");
                    letters.add("M");
                    letters.add("N");
                    //letters.add("O");
                    letters.add("P");
                    letters.add("Q");
                    letters.add("R");
                    letters.add("S");
                    letters.add("T");
                    letters.add("U");
                    //letters.add("V");
                    letters.add("W");
                    letters.add("X");
                    letters.add("Y");
                    letters.add("Z");
                    JSONArray newArray = new JSONArray();
                    for (int j = 0; j < letters.size(); j++){
                        JSONObject newObj = new JSONObject();
                        JSONArray newCity = new JSONArray();
                        for (int i = 0; i < cityArray.length(); i++) {
                            JSONObject item = (JSONObject) cityArray.get(i);
                            String name = (String) item.opt("name");
                            String code = (String) item.opt("code");
                            String name_en = (String) item.opt("name_en");
                            if (letters.get(j).equals(name_en.substring(0, 1))) {
//                                Log.e("gnt", "-gnt>" + name);
                                JSONObject o = new JSONObject();
                                o.put("name", name);
                                newCity.put(o);
                            }
                        }
                        newObj.put("letter", letters.get(j));
                        newObj.put("citys", newCity);
                        newArray.put(j, newObj);
                        Log.e("gnt","-gnt:"+ newCity.toString());
                    }
                    String res = newArray.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private String getCity(){
        try {
            InputStream inputStream = getAssets().open("city.xml");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String readline = null;
            while ((readline = br.readLine()) != null) {
                sb.append(readline);
            }
            inputStream.close();
            br.close();
           // Log.e("gnt","-gnt->:"+sb.toString());
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
