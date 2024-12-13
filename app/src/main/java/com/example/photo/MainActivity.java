package com.example.photo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String imageUrl = "https://i.pinimg.com/736x/ef/7e/86/ef7e86a9cd5cb539a32641dfd40cd99f.jpg";
        ImageView imageView = findViewById(R.id.view);
        Bitmap bitmap = loadImageFromURL(imageUrl);
        imageView.setImageBitmap(bitmap);
    }
    private Bitmap loadImageFromURL(String urlString) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            URL url = new URL(urlString);
            InputStream inputStream = (InputStream) url.getContent();
            return BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
