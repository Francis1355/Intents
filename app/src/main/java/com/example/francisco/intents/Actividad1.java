package com.example.francisco.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad1 extends AppCompatActivity {
    EditText txtValue1, txtValue2;
    TextView txtResult;
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1);
        txtValue1 = (EditText) findViewById(R.id.EditText01);
        txtValue2 = (EditText) findViewById(R.id.EditText02);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double v1 = Double.parseDouble(txtValue1.getText().toString());
                Double v2 = Double.parseDouble(txtValue2.getText().toString());

                Intent myIntentA1A2 = new Intent(Actividad1.this,
                        Actividad2.class);

                Bundle myDataBundle = new Bundle();

                myDataBundle.putDouble("val1", v1);
                myDataBundle.putDouble("val2", v2);

                myIntentA1A2.putExtras(myDataBundle);

                startActivityForResult(myIntentA1A2, 101);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if ((requestCode == 101) && (resultCode == Activity.RESULT_OK)) {
                Bundle myResultBundle = data.getExtras();
                Double myResult = myResultBundle.getDouble("vresult");
                txtResult.setText("Suma es " + myResult);
            }
        } catch (Exception e) {
            txtResult.setText("Problems - " + requestCode + " " + resultCode);
        }

    }
}
