package demo.ht.com.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner = findViewById(R.id.spinner);


        //android:spinnerMode="dropdown"   向右偏移10dp
        mSpinner.setDropDownHorizontalOffset(10);
        //android:spinnerMode="dropdown"向左偏移100dp
        mSpinner.setDropDownVerticalOffset(100);

        //android:spinnerMode="dialog" 情况下  显示提示语句
        mSpinner.setPrompt("请选择:");

        //android:spinnerMode="dropdown"  默认显示第三项
        mSpinner.setSelection(3);
        //android:spinnerMode="dropdown"  设置背景
        mSpinner.setPopupBackgroundResource(R.color.colorAccent);

//        initView();

        //自定义布局
        initCustom();

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] stringArray = getResources().getStringArray(R.array.spinnerList);
                Toast.makeText(MainActivity.this, ""+stringArray[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initCustom() {
        ArrayList<SpinnerBean> spinnerBeans = new ArrayList<>();
        spinnerBeans.add(new SpinnerBean("中国",R.drawable.ic_launcher_foreground));
        spinnerBeans.add(new SpinnerBean("尼泊尔",R.drawable.ic_launcher_foreground));
        spinnerBeans.add(new SpinnerBean("巴西",R.drawable.ic_launcher_foreground));
        spinnerBeans.add(new SpinnerBean("印度",R.drawable.ic_launcher_foreground));
        spinnerBeans.add(new SpinnerBean("澳大利亚",R.drawable.ic_launcher_foreground));
        MySpinnerAdapter mySpinnerAdapter = new MySpinnerAdapter(spinnerBeans, this);

        mSpinner.setAdapter(mySpinnerAdapter);
    }

    private void initView() {
        ArrayList<String> list = new ArrayList<>();
        list.add("中国");
        list.add("尼泊尔");
        list.add("巴西");
        list.add("印度");
        list.add("澳大利亚");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setAdapter(adapter);
    }
}
