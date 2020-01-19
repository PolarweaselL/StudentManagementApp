package com.example.adrian.practicaltest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.adrian.myapplication2.R;

public class MainActivity extends Activity {
    private EditText text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.inputValue);

    }

    // this method is called at button click because we assigned the name to the
    // "OnClick" property of the button
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                RadioButton feetButton = (RadioButton) findViewById(R.id.radio0);
                RadioButton metersButton = (RadioButton) findViewById(R.id.radio1);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if (feetButton.isChecked()) {
                    text.setText(String
                            .valueOf(ConverterUtil.convertMeterToFeet(inputValue)));
                    feetButton.setChecked(false);
                    metersButton.setChecked(true);
                } else {
                    text.setText(String
                            .valueOf(ConverterUtil.convertFeetToMeter(inputValue)));
                    metersButton.setChecked(false);
                    feetButton.setChecked(true);
                }
                break;
        }
    }

}
