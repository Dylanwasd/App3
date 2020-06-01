package sg.edu.rp.c346.app3;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PaymentHistory extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aaHistory;
    Spinner months;
    ArrayList<String> history;
    TextView cost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_payment_history);

        lv = findViewById(R.id.biggerList);
        months = findViewById(R.id.spinner);
        cost = findViewById(R.id.cost);
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
                        cost.setText("");
                        double total1 = 0.0;
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total1 = currentValue+total1;
                            String finalTotal = String.format("%.2f", total1);
                            cost.setText("$"+finalTotal);

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
                        double total2 = 0.0;
                        cost.setText("");
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total2 = currentValue+total2;
                            String finalTotal = String.format("%.2f", total2);
                            cost.setText("$"+finalTotal);

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
                        cost.setText("");
                        double total3 = 0.0;
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total3 = currentValue+total3;
                            String finalTotal = String.format("%.2f", total3);
                            cost.setText("$"+finalTotal);

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
                        cost.setText("");
                        double total4 = 0.0;
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total4 = currentValue+total4;
                            String finalTotal = String.format("%.2f", total4);
                            cost.setText("$"+finalTotal);

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
                        cost.setText("");
                        double total5 = 0.0;
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total5 = currentValue+total5;
                            String finalTotal = String.format("%.2f", total5);
                            cost.setText("$"+finalTotal);

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
                        cost.setText("");
                        double total6= 0.0;
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total6 = currentValue+total6;
                            String finalTotal = String.format("%.2f", total6);
                            cost.setText("$"+finalTotal);

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
                        cost.setText("");
                        double total7 = 0.0;
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total7 = currentValue+total7;
                            String finalTotal = String.format("%.2f", total7);
                            cost.setText("$"+finalTotal);

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
                        cost.setText("");
                        double total8 = 0.0;
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total8 = currentValue+total8;
                            String finalTotal = String.format("%.2f", total8);
                            cost.setText("$"+finalTotal);

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
                        cost.setText("");
                        double total9 = 0.0;
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total9 = currentValue+total9;
                            String finalTotal = String.format("%.2f", total9);
                            cost.setText("$"+finalTotal);

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
                        cost.setText("");

                        double total10 = 0.0;
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total10 = currentValue+total10;
                            String finalTotal = String.format("%.2f", total10);
                            cost.setText("$"+finalTotal);

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

                        cost.setText("");
                        double total11 = 0.0;
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total11 = currentValue+total11;
                            String finalTotal = String.format("%.2f", total11);
                            cost.setText("$"+finalTotal);

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

                        cost.setText("");
                        double total12 = 0.0;
                        for(int i = 0; i<history.size(); i++){
                            String[] a = history.get(i).split("(?!^)");
                            String  stringCost = a[2] + a[3] + a[4] + a[5];
                            double currentValue = Double.parseDouble(stringCost);
                            total12 = currentValue+total12;
                            String finalTotal = String.format("%.2f", total12);
                            cost.setText("$"+finalTotal);

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
