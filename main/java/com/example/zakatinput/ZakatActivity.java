package com.example.zakatinput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ZakatActivity extends AppCompatActivity implements View.OnClickListener {

    private static final Object LENGTH_SHORT = null;
    private RadioGroup radioGroup;
    private EditText CurrentGoldValue;
    private EditText WeightGold;
    private Button calculate;
    public TextView TotalValue,ZakatPayable;
    RadioButton radioButton;
    private Object Toast;

    private String KEEP ="Keep";
    private String WEAR ="Wear";
    private int X_Keep= 85;
    private int X_Wear= 200;
    private TextView TotalZakat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String getWeight = sharedPref.getString("weight", "");
        String getPrice = sharedPref.getString("price", "");

        radioGroup = findViewById (R.id.rgtypeGOld);
        radioButton = findViewById (R.id.keep);
        radioButton = findViewById (R.id.wear);


        CurrentGoldValue = (EditText) findViewById (R.id.editValue);
        WeightGold=  (EditText) findViewById (R.id.editWeight);

        calculate = (Button) findViewById (R.id.btnSubmit);

        TotalValue = (TextView) findViewById (R.id.txtTotalValue);
        ZakatPayable= (TextView) findViewById(R.id.txtZakatPayable);
        TotalZakat = (TextView) findViewById (R.id.txttotalZakat);

        calculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        double value = Double.parseDouble(CurrentGoldValue.getText().toString());
        double weight = Double.parseDouble(WeightGold.getText().toString());

        int xValue = 0;
        int radiobutton = radioGroup.getId();
        if (radioButton.equals(KEEP)) {
            xValue = 85;

        }
        else  if (radioButton.equals(WEAR)) {
            xValue = 200;
        }
        double totalGold = weight*value;
        double uruf = weight-xValue;
        double zakatPayable = uruf*value;

        TotalValue.setText("RM" + totalGold);
        ZakatPayable.setText("RM" + uruf*value);
        TotalZakat.setText("RM" +(zakatPayable*0.025));

    }
}