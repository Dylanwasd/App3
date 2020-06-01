package sg.edu.rp.c346.app3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import sg.edu.rp.c346.app3.DataBaseHelper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    TextView totalValue;
    CardView cardImage;
    ArrayList<String> historyTrans;
    View signOut;
    Button seeMore;
    View topUp;
    double topUpValue;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataBaseHelper(this);
        totalValue = findViewById(R.id.value);
        cardImage = findViewById(R.id.cardView);
        seeMore = findViewById(R.id.showMore);
        topUp = findViewById(R.id.topUpView);
        signOut = findViewById(R.id.signOutView);
        historyTrans = new ArrayList();
        signOut = findViewById(R.id.signOutImg);
        topUpValue = 0;

        AddData();
        viewAll();

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Login.class);
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
    public void AddData(){
        final Random number = new Random();
        cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cost = (getRandomValue(number, 0, 3, 2));
                double currentValue = Double.parseDouble(totalValue.getText().toString());
                Double totalCost = Double.parseDouble(cost);
                if(currentValue > totalCost) {
                    Double finalValue = currentValue - totalCost;
                    String roundFinalValue = String.format("%.2f", finalValue);
                    String stringCost = String.format("%.2f" , totalCost);
                    Date c = Calendar.getInstance().getTime();
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = df.format(c);


                    totalValue.setText(roundFinalValue);
                    myDb.insertData(stringCost, formattedDate);
                }



            }
        });
    }

    public void viewAll(){
        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if(res.getCount() == 0){
                    showMessage("Error", "Nothing found");
                    return;
                }
                while (res.moveToNext()){
                    historyTrans.add(0, "\n" +"$" +res.getString(1)  + "\n"  + res.getString(2) + "\n");
                }
                Intent intent = new Intent(getBaseContext(), PaymentHistory.class);
                intent.putExtra("myList", historyTrans);
                startActivity(intent);
            }
        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String amount = data.getStringExtra("amount");
                double currentValue = Double.parseDouble(totalValue.getText().toString());
                double value= Double.parseDouble(amount);
                double total = currentValue+value;
                String finalTotal = String.format("%.2f", total);
                totalValue.setText(finalTotal);

                //To add in the onresume() for topping up
                topUpValue = value;

            }
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("value", totalValue.getText().toString());
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String msg=prefs.getString("value", "");
        double resumeCurrentValue = Double.parseDouble(msg);
        double resumeCurrentTotal = topUpValue + resumeCurrentValue;
        String stringCurrentTotal = String.format("%.2f", resumeCurrentTotal);
        totalValue.setText(stringCurrentTotal);
        topUpValue=0;


    }


}
