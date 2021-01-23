package com.tom.serial;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/25
 */
public class BeanDemo {

    public String key;
    public String title;
    public String[] values;
    public String defaultValue;

    public static BeanDemo fromJsonString(String json) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            BeanDemo bean = new BeanDemo();
            bean.key = jsonObject.getString("key");
            bean.title = jsonObject.getString("title");
            JSONArray jsonArray = jsonObject.getJSONArray("values");
            if (jsonArray != null && jsonArray.size() > 0) {
                int len = jsonArray.size();
                bean.values = new String[len];
                for (int i = 0; i < len; ++i) {
                    bean.values[i] = jsonArray.getString(i);
                }
            }
            bean.defaultValue = jsonObject.getString("defaultValue");

            return bean;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String toJsonString(BeanDemo bean) {
        if (bean == null) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("key", bean.key);
            jsonObject.put("title", bean.title);
            if (bean.values != null) {
                JSONArray array = new JSONArray();
                for (String str : bean.values) {
                    array.add(str);
                }
                jsonObject.put("values", array);
            }
            jsonObject.put("defaultValue", bean.defaultValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }
}
