package com.example.android.justjava;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int calculatePrice(int quantity) {
        int unitPrice = 5;
        return unitPrice * quantity;
    }

    private String createOrderSummary(int price, Boolean hasWhippedCream) {
        return "Name: Ahmed Razic\nHas whipped cream: " + hasWhippedCream.toString() +
                "\nQuantity: " + quantity + "\nTotal: $" + price + "\nThank you";
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamTopping = findViewById(R.id.checkBox_whipped_cream);
        Boolean hasWhippedCream = whippedCreamTopping.isChecked();
        Log.i("MainActivity.java", "Has whipped cream: " + hasWhippedCream.toString());

        //String priceMessage = "Amount due: $" + (5 * quantity);
        //String priceMessage = "That would be $" + (5 * quantity) + " please.";
        //String priceMessage = "You owe ten bucks, dude!";
        //String priceMessage = (5 * quantity) +  " dollars for " + quantity + " cups of coffee. Pay Up.";
        displayMessage(createOrderSummary(calculatePrice(quantity), hasWhippedCream));
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
        //orderSummaryTextView.setTextSize(40);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void incrementQuantity(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrementQuantity(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

}