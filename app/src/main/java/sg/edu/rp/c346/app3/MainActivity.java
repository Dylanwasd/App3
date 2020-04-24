package sg.edu.rp.c346.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    TextView data;
    TextView data2;
    ImageView cardImage;
    ListView lv;
    ArrayList<String> history;
    ArrayAdapter aaHistory;
    Button seeMore;
    Button topUp;
    public static String getRandomValue(final Random random,
                                        final int lowerBound,
                                        final int upperBound,
                                        final int decimalPlaces){

        if(lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0){
            throw new IllegalArgumentException("Put error message here");
        }

        final double dbl =
                ((random == null ? new Random() : random).nextDouble() //
                        * (upperBound - lowerBound))
                        + lowerBound;
        return String.format("%." + decimalPlaces + "f", dbl);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                data2 = findViewById(R.id.value);
                String amount = data.getStringExtra("amount");
                double currentValue = Double.parseDouble(data2.getText().toString());
                double value= Double.parseDouble(amount);
                double total = currentValue+value;
                String finalTotal = String.format("%.2f", total);
                data2.setText(finalTotal);


            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = findViewById(R.id.value);
        cardImage = findViewById(R.id.card);
        lv = findViewById(R.id.listOfHistory);
        seeMore = findViewById(R.id.showMore);
        topUp = findViewById(R.id.top);
        history = new ArrayList();


        final Random number = new Random();

        cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cost = (getRandomValue(number, 0, 3, 2));
                double currentValue = Double.parseDouble(data.getText().toString());
                Double totalCost = Double.parseDouble(cost);
                if(currentValue > totalCost) {
                    Double finalValue = currentValue - totalCost;
                    String roundFinalValue = String.format("%.2f", finalValue);
                    String stringCost = String.format("%.2f" , totalCost);
                    Date c = Calendar.getInstance().getTime();
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = df.format(c);
                    history.add(0, "$" +stringCost + "\n" + formattedDate);

                    aaHistory=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,history);
                    lv.setAdapter(aaHistory);

                    data.setText(roundFinalValue);
                }



            }
        });
        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PaymentHistory.class);
                intent.putExtra("myList", history);
                startActivity(intent);
            }
        });
        topUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), TopUp.class);
                startActivityForResult(intent,1);
            }
        });

    }

}
