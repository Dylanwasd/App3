package sg.edu.rp.c346.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TopUp extends AppCompatActivity {
    Button confirm;
    EditText amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        confirm=findViewById(R.id.buttonTop);
        amount = findViewById(R.id.amount);

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
    }
}
