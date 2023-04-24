package com.example.tps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //IMCL KARIM
    EditText editTextPoid=null;
    EditText editTextTaille=null;
    RadioGroup radioGroup=null;
    RadioButton selectedRadioButton=null;
    CheckBox checkBox=null;
    Button buttonCalculer=null;
    Button buttonRaz=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imclkarim);





        buttonCalculer = findViewById(R.id.button_calculer);
        buttonRaz = findViewById(R.id.button_ras);

        buttonCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mapValues();
                calculer();
            }
        });
    }
    private void calculer(){
        try {
            double poid = Double.parseDouble(this.editTextPoid.getText().toString());
            double taille = Double.parseDouble(this.editTextTaille.getText().toString());
            double choice=Double.parseDouble(this.selectedRadioButton.getTag().toString());

            double result = poid*taille*choice;// It's just example
            Toast.makeText(MainActivity.this,"result : "+result+"",Toast.LENGTH_SHORT).show();

        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            Toast.makeText(MainActivity.this,"Please Use . instead of ,",Toast.LENGTH_LONG).show();

        }
    }
    private void mapValues(){
        //GET INPUT VALUES
        editTextPoid=findViewById(R.id.text_poid);
        editTextTaille=findViewById(R.id.text_taille);
        //GET CHECK BOOK BUTTON
        checkBox=findViewById(R.id.checkbox_mega);
        //GET SELECT RADIO BUTTON
        radioGroup = findViewById(R.id.radioGroup);
        int selectedButtonId= radioGroup.getCheckedRadioButtonId();
        this.selectedRadioButton=findViewById(selectedButtonId);
    }
}