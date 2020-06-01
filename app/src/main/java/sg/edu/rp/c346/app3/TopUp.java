package sg.edu.rp.c346.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TopUp extends AppCompatActivity {
    Button confirm;
    EditText amount;
    EditText number;
    EditText pin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        confirm=findViewById(R.id.buttonTop);
        amount = findViewById(R.id.amount);
        number = findViewById(R.id.cardNumber);
        pin = findViewById(R.id.pin);

        confirm.setEnabled(false);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= amount.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("amount", value);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        number.addTextChangedListener(check);
        pin.addTextChangedListener(check);
        amount.addTextChangedListener(check);


    }
    private TextWatcher check = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String num = number.getText().toString().trim();
            String password = pin.getText().toString().trim();
            String money = amount.getText().toString().trim();

            confirm.setEnabled(!num.isEmpty() && !password.isEmpty() && !money.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
