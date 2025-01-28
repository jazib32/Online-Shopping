package com.example.onlineshopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class product_detail extends AppCompatActivity {

    private LinearLayout imageGallery;
    private TextView productName, productPrice, productDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);

        // Initialize views
        imageGallery = findViewById(R.id.image_gallery);
        productName = findViewById(R.id.product_name);
        productPrice = findViewById(R.id.product_price);
        productDescription = findViewById(R.id.product_description);

        // Example: Product data
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://example.com/product_image1.jpg");
        imageUrls.add("https://example.com/product_image2.jpg");
        imageUrls.add("https://example.com/product_image3.jpg");

        // Populate the image gallery with ImageViews
        for (String imageUrl : imageUrls) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            // Load image using Glide (or any built-in image loader)
            Glide.with(this)
                    .load(imageUrl)
                    .into(imageView);

            // Add ImageView to the HorizontalScrollView's LinearLayout
            imageGallery.addView(imageView);
        }

        // Example product details
        String name = "Product Name";
        String price = "$99.99";
        String description = "This is an amazing product with great features. You'll love it!";

        // Set product details in views
        productName.setText(name);
        productPrice.setText(price);
        productDescription.setText(description);
    }
}
