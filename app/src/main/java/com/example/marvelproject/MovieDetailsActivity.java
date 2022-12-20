package com.example.marvelproject;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

public class MovieDetailsActivity extends AppCompatActivity {
    TextView realName,heroName,heroBio;
    ImageView heroImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        realName = findViewById(R.id.realName);
        heroName = findViewById(R.id.heroName);
        heroBio = findViewById(R.id.heroBio);
        heroImg = findViewById(R.id.heroImg);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        realName.setText(bundle.getString("realName"));
        heroName.setText(bundle.getString("heroName"));
        heroBio.setText(bundle.getString("heroBio"));

        Glide.with(this)
                .load(bundle.getString("heroImg"))
                .transition(withCrossFade(new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()))
                .into(heroImg);

    }
}