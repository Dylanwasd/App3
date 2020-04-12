package sg.edu.rp.c346.app3;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PaymentHistory extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aaHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_payment_history);

        lv = findViewById(R.id.biggerList);

        ArrayList<String> list = (ArrayList<String>) getIntent().getSerializableExtra("myList");
        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,list);

        lv.setAdapter(aaHistory);

    }
}
