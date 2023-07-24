package com.example.step03customadapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    //필드
    List<CountryDto> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adapter에 연결할 모델 객체를 생성
        countries = new ArrayList<>();

        //셈플데이터
        countries.add(new CountryDto(R.drawable.austria,
                "오스트리아", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.belgium,
                "벨기에", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.brazil,
                "브라질", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.france,
                "프랑스", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.germany,
                "독일", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.greece,
                "그리스", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.israel,
                "이스라엘", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.italy,
                "이탈리아", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.japan,
                "일본", "그지 같은 나라~"));
        countries.add(new CountryDto(R.drawable.korea,
                "대한민국", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.poland,
                "폴란드", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.spain,
                "스페인", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.usa,
                "미국", "어쩌구.. 저쩌구.."));
        //ListView에 연결할 adapter 객체 생성
        CountryAdapter adapter = new CountryAdapter(this, R.layout.listview_cell, countries);

        //ListView의 참조값을 얻어와서
        ListView listView = findViewById(R.id.listView);
        //adapter 연결
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }
    // 1. Activity(UI를 제어하는 역할 : 여러개의 역할에서 특정 액티비티만 활성화시킴
    // -> 활성화 시키기 위해서는 intent객체가 필요함 (intent에 어떠한 정보를 담아서 전송 할 수 도 있다)
    //ex) 전화를 거는 동작을 만든다면 ?  전화를 거는intent를 만들어서 전화번호를 전송 ~
    // 2.Service
    // 3. BroadcastReceiver(방송수신자) : 안드로이드 운영체제 안에서 일어나는 이벤트들
    // (ex.와이파이가 켜지고 꺼지고, 배터리가 부족 , 부팅완료 등)
    // -> (1~3) intent
    // 4.ContentProvider
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        //DetailActivity 로 이동

        //DetailActivitiy로 이동할 intent객체 생성하기
        Intent intent= new Intent(this, DetailActivity.class);

        //클릭한 셀에 있는 나라의 정보
        CountryDto dto=countries.get(i);

        //Intent객체에 "dto"라는 키값으로 Serializable type인 CountryDto 객체의 참조값 전달하기
        intent.putExtra("dto", dto);
        //
        //startActivity() 메소드 호출하면서 Intent객체를 전달해서 액티비티 시작시키기
        startActivity(intent);

    }
}