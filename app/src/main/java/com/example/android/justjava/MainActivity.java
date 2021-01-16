package com.example.android.justjava;


        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        //import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.TextView;

        import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //String priceMessage = "Amount due: $" + (5 * quantity);
        //String priceMessage = "That would be $" + (5 * quantity) + " please.";
        //String priceMessage = "You owe ten bucks, dude!";
        //String priceMessage = (5 * quantity) +  " dollars for " + quantity + " cups of coffee. Pay Up.";
        String priceMessage = "Total: $" + (5 * quantity);
        priceMessage = priceMessage + "\nThank you";
        displayMessage(priceMessage);
    }

    private void displayMessage(String message) {
        TextView priceTextVIew = (TextView) findViewById(R.id.price_text_view);
        priceTextVIew.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
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