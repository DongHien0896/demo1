package com.example.dong.democalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mButtonAc;
    private Button mButtonAddSub;
    private Button mButtonPercent;
    private Button mButtonDiv;
    private Button mButtonSeven;
    private Button mButtonEight;
    private Button mButtonNine;
    private Button mButtonMultiple;
    private Button mButtonFour;
    private Button mButtonFive;
    private Button mButtonSix;
    private Button mButtonSub;
    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;
    private Button mButtonAdd;
    private Button mButtonZero;
    private Button mButtonPoint;
    private Button mButtonResult;
    private TextView mTextResult;
    private String mData = Constants.EMPTY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setEvent();
    }

    private void initView() {
        mButtonAc = (Button) findViewById(R.id.button_ac);
        mButtonAddSub = (Button) findViewById(R.id.button_add_sub);
        mButtonPercent = (Button) findViewById(R.id.button_percent);
        mButtonDiv = (Button) findViewById(R.id.button_division);
        mButtonSeven = (Button) findViewById(R.id.button_seven);
        mButtonEight = (Button) findViewById(R.id.button_eight);
        mButtonNine = (Button) findViewById(R.id.button_nine);
        mButtonMultiple = (Button) findViewById(R.id.button_muliple);
        mButtonFour = (Button) findViewById(R.id.button_four);
        mButtonFive = (Button) findViewById(R.id.button_five);
        mButtonSix = (Button) findViewById(R.id.button_six);
        mButtonSub = (Button) findViewById(R.id.button_sub);
        mButtonOne = (Button) findViewById(R.id.button_one);
        mButtonTwo = (Button) findViewById(R.id.button_two);
        mButtonThree = (Button) findViewById(R.id.button_three);
        mButtonAdd = (Button) findViewById(R.id.button_add);
        mButtonZero = (Button) findViewById(R.id.button_zero);
        mButtonPoint = (Button) findViewById(R.id.button_point);
        mButtonResult = (Button) findViewById(R.id.button_result);
        mTextResult = (TextView) findViewById(R.id.text_result);
    }

    private void setEvent() {
        mButtonAc.setOnClickListener(this);
        mButtonAddSub.setOnClickListener(this);
        mButtonPercent.setOnClickListener(this);
        mButtonDiv.setOnClickListener(this);
        mButtonSeven.setOnClickListener(this);
        mButtonEight.setOnClickListener(this);
        mButtonNine.setOnClickListener(this);
        mButtonMultiple.setOnClickListener(this);
        mButtonFour.setOnClickListener(this);
        mButtonFive.setOnClickListener(this);
        mButtonSix.setOnClickListener(this);
        mButtonSub.setOnClickListener(this);
        mButtonOne.setOnClickListener(this);
        mButtonTwo.setOnClickListener(this);
        mButtonThree.setOnClickListener(this);
        mButtonAdd.setOnClickListener(this);
        mButtonZero.setOnClickListener(this);
        mButtonPoint.setOnClickListener(this);
        mButtonResult.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_clear:
                Toast.makeText(this, Constants.MESSAGE_CLREA, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_save:
                Toast.makeText(this, Constants.MESSAGE_SAVE, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void enterData(String data) {
        mData = mData + data;
        mTextResult.setText(mData);
    }

    private String returnResult() {
        String data = mTextResult.getText().toString();
        Calculate calculate = new Calculate();
        String elementMath[] = calculate.processString(data);
        String elemenMath2[] = calculate.converseToPostFix(elementMath);
        return calculate.valueMath(elemenMath2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_ac:
                mTextResult.setText(Constants.EMPTY);
                mData = Constants.EMPTY;
                break;
            case R.id.button_add_sub:
                break;
            case R.id.button_percent:
                break;
            case R.id.button_division:
                enterData(Constants.DIV);
                break;
            case R.id.button_seven:
                enterData(Constants.SEVEN);
                break;
            case R.id.button_eight:
                enterData(Constants.EIGHT);
                break;
            case R.id.button_nine:
                enterData(Constants.NINE);
                break;
            case R.id.button_muliple:
                enterData(Constants.MUL);
                break;
            case R.id.button_four:
                enterData(Constants.FOUR);
                break;
            case R.id.button_five:
                enterData(Constants.FIVE);
                break;
            case R.id.button_six:
                enterData(Constants.SIX);
                break;
            case R.id.button_sub:
                enterData(Constants.SUB);
                break;
            case R.id.button_one:
                enterData(Constants.ONE);
                break;
            case R.id.button_two:
                enterData(Constants.TWO);
                break;
            case R.id.button_three:
                enterData(Constants.THREE);
                break;
            case R.id.button_add:
                enterData(Constants.ADD);
                break;
            case R.id.button_zero:
                enterData(Constants.ZERO);
                break;
            case R.id.button_point:
                break;
            case R.id.button_result:
                String result = returnResult();
                mTextResult.setText(result);
                break;
            default:
                break;
        }
    }
}
