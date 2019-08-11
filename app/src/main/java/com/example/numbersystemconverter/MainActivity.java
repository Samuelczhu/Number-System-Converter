package com.example.numbersystemconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find all the input views
        final EditText numberInput = (EditText) findViewById(R.id.number_input);
        final Spinner numberSpinner = (Spinner) findViewById(R.id.spinner);
        Button submitButton = (Button) findViewById(R.id.submit);

        //setup the spinner
        final String[] numberSystem = getResources().getStringArray(R.array.number_system);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, numberSystem);
        numberSpinner.setAdapter(adapter);

        //find all the display views
        final TextView binaryDisplay = (TextView) findViewById(R.id.binary_display);
        final TextView twosDisplay = (TextView) findViewById(R.id.twos_complement_display);
        final TextView hexDisplay = (TextView) findViewById(R.id.hexadecimal_display);
        final TextView decimalDisplay = (TextView) findViewById(R.id.decimal_display);

        //create a number system object
        final NumberSystem numSys = new NumberSystem();

        //implement the onclick
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //get the input
                    String input = numberInput.getText().toString();
                    //get the mode
                    int mode = findIndex(numberSystem, numberSpinner.getSelectedItem().toString());

                    //calculate the number
                    numSys.inputNumber(input, mode);

                    //display the number to systems
                    binaryDisplay.setText(numSys.toBinary());
                    twosDisplay.setText(numSys.toTwosComplement());
                    hexDisplay.setText(numSys.toHexadecimal());
                    decimalDisplay.setText(numSys.toDecimal());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,R.string.invalid_prompt,Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private int findIndex(String[] arr, String element) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i].equals(element))
                return i;
        }
        return -1;
    }
}
