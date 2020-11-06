package com.example.just_test;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

//集合类，专门对所有活动进行管理
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for(Activity activity : activities) {
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
