package sg.edu.rp.c346.app3;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class PaymentHistory extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aaHistory;
    Spinner months;
    ArrayList<String> history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_payment_history);

        lv = findViewById(R.id.biggerList);
        months = findViewById(R.id.spinner);
        history = new ArrayList();

        final ArrayList<String> list = (ArrayList<String>) getIntent().getSerializableExtra("myList");

        months.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,list);

                        lv.setAdapter(aaHistory);

                        break;
                    case 1:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("01")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;
                    case 2:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("02")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;
                    case 3:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("03")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;
                    case 4:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("04")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;
                    case 5:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("05")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;
                    case 6:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("06")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;
                    case 7:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("07")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;
                    case 8:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("08")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;
                    case 9:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("09")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;
                    case 10:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("10")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;
                    case 11:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("11")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;
                    case 12:
                        history.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String[] separated = list.get(i).split("/");
                            if( separated[1].equals("12")){
                                history.add(list.get(i));

                            }
                        }

                        aaHistory=new ArrayAdapter(PaymentHistory.this, android.R.layout.simple_list_item_1,history);
                        lv.setAdapter(aaHistory);

                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
