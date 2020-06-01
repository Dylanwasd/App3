package sg.edu.rp.c346.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    EditText txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = findViewById(R.id.buttonConfirm);
        txt = findViewById(R.id.cardEditText);
        btn.setEnabled(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        txt.addTextChangedListener(cardNumber);


    }
    private TextWatcher cardNumber = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String card = txt.getText().toString().trim();
            btn.setEnabled(!card.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}
