package com.gac.calendarviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.gac.calendarviewdemo.CalendarView.CalendarDay;
import com.gac.calendarviewdemo.CalendarView.EventDecorator;
import com.gac.calendarviewdemo.CalendarView.MaterialCalendarView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MaterialCalendarView.OnDateSelectedListener,MaterialCalendarView.OnMonthChangedListener{

    private MaterialCalendarView calendar;
    public Map<String,String> map;
    public EventDecorator decorator;
    private Map<String,String> getMap(){
        Map<String,String> map = new HashMap<>();
        map.put("2016-04-13",1+"");
        map.put("2016-04-14",1+"");
        map.put("2016-04-15",0+"");
        map.put("2016-04-19",0+"");
        return map;
    }
    private Map<String,String> getMap1(String month){
        Map<String,String> map = new HashMap<>();
        map.put("2016-0"+month+"-13", 1+"");
        map.put("2016-0"+month+"-14", 0+"");
        map.put("2016-0"+month+"-12", 1+"");
        map.put("2016-0"+month+"-18", 0+"");
        map.put("2016-0"+month+"-23", 1+"");
        map.put("2016-0"+month+"-21", 0+"");
        map.put("2016-0"+month+"-20", 1+"");
        return map;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ListView lv;
        ArrayAdapter adapter;
        calendar = (MaterialCalendarView)findViewById(R.id.calendar);
        calendar.setOnMonthChangedListener(this);
        calendar.setOnDateChangedListener(this);
        decorator = new EventDecorator(getMap());
        calendar.addDecoratorGAC(decorator);
    }

    @Override
    public void onDateSelected(MaterialCalendarView widget, CalendarDay date, boolean selected) {

    }

    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
        String str = (date.getMonth()+1)+"";
        print(str);
        decorator.setMap(getMap1(str));

    }
    private void print(String content){
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }


}
