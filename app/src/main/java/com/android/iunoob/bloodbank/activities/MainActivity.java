package com.android.iunoob.bloodbank.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.iunoob.bloodbank.FirstQuestion;
import com.android.iunoob.bloodbank.R;
import com.android.iunoob.bloodbank.VersionsAdaptor;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    BottomNavigationView bottomNavigationView;
    private FirebaseAuth mAuth;
    ImageSlider img;

    //
        RecyclerView recyclerView;
        List<FirstQuestion> firstQuestions;

    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.slide);
        //
            recyclerView = findViewById(R.id.recycleView);
                initData();
            setRecycleView();
        //

        ArrayList<SlideModel> images= new ArrayList<>();
        images.add(new SlideModel(R.drawable.h1,null));
        images.add(new SlideModel(R.drawable.h2,null));
        images.add(new SlideModel(R.drawable.h3,null));
        images.add(new SlideModel(R.drawable.h4,null));
        images.add(new SlideModel(R.drawable.h5,null));
        images.add(new SlideModel(R.drawable.h6,null));

        img.setImageList(images, ScaleTypes.CENTER_CROP);


        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home:
                        return true;

                    case R.id.doner:
                        startActivity(new Intent(getApplicationContext(),DonerActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    private void setRecycleView() {
        VersionsAdaptor versionsAdaptor = new VersionsAdaptor((firstQuestions));
        recyclerView.setAdapter(versionsAdaptor);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        firstQuestions = new ArrayList<>();
        firstQuestions.add(new FirstQuestion("Is it safe to give blood?","Yes. Donating blood is safe. The supplies used to collect blood are sterile and only used once."));
        firstQuestions.add(new FirstQuestion("Are there age limits for blood donors?","Each state sets the minimum blood donor age. You must be at least 16 or 17-years-old depending on your state. Some blood centers may have an upper age limit. Please call and check with your local blood center for more information."));
        firstQuestions.add(new FirstQuestion("What are red cells, platelets and plasma?","Red Cells - these give your blood its red color and carry oxygen to your organs and tissues.\n" +
                "\n" +
                "Platelets - the very small colorless cell fragments in your blood whose main function is to stop bleeding.\n" +
                "\n" +
                "Plasma - the liquid portion of your blood that transports water and nutrients to your body's tissues."));
        firstQuestions.add(new FirstQuestion("How long does it take?","Donating whole blood takes about 30 minutes total, and the actual donation takes 8-10 minutes. Platelet donation can take up to two hours, from start to finish. The donation itself usually takes 45-60 minutes."));
        firstQuestions.add(new FirstQuestion("How often can I donate Blood ?","After every three –four months you can donate blood."));
        firstQuestions.add(new FirstQuestion("Are their any side effects of Blood donations ?","There are no side effects of blood donation. The Blood bank staff ensures that your blood donation is a good experience as far as possible to enable you to become a repeat and a regular blood donor. There are a number of people who have donated   more tha25-100 times in their life time"));

    }

}