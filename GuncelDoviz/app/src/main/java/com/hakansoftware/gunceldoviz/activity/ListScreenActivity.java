package com.hakansoftware.gunceldoviz.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;

import com.hakansoftware.gunceldoviz.R;
import com.hakansoftware.gunceldoviz.adapters.RecyclerViewAdapter;
import com.hakansoftware.gunceldoviz.base.BaseUtils;
import com.hakansoftware.gunceldoviz.callbacks.Yatirim24Callback;
import com.hakansoftware.gunceldoviz.controller.Yatirim24Controller;

import io.supernova.uitoolkit.drawable.LinearGradientDrawable;
import io.swagger.client.model.Yatirim24Model;

public class ListScreenActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {

        // Fill the created intent with the data you want to be passed to this Activity when it's opened.
        return new Intent(context, ListScreenActivity.class);
    }

    private ConstraintLayout constraintLayoutConstraintLayout;
    private ImageButton backArrowButton;

    private Yatirim24Controller yatirim24Controller = Yatirim24Controller.getInstance();

    private RecyclerView recyclerView;

    private SearchView searchView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen);
        this.init();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        yatirim24Controller.getYatirim24(new Yatirim24Callback() {
            @Override
            public void onSuccess(Yatirim24Model yatirim24Model) {
                //BaseUtils.showToast(getApplicationContext(), yatirim24Model.getDovizList().get(0).getDetailLink());
                yatirim24Model.getDovizList().remove(0);
                recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), yatirim24Model.getDovizList());
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onError() {
                BaseUtils.showToast(getApplicationContext(), "Bir sorun oldu, Lütfen tekrar deneyin");
            }
        });

        searchView = (SearchView) findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (recyclerViewAdapter != null) {
                    recyclerViewAdapter.getFilter().filter(newText);
                }
                return false;
            }
        });
    }

    @Override
    public void onStart() {

        super.onStart();

        this.startAnimationOne();
    }

    private void init() {

        // Configure  component
        constraintLayoutConstraintLayout = this.findViewById(R.id.constraint_layout_constraint_layout);
        constraintLayoutConstraintLayout.setBackground(new LinearGradientDrawable.Builder(this, new PointF(-0.3f, 0.36f), new PointF(1.3f, 0.64f)).addStop(0f, Color.argb(255, 51, 51, 153)).addStop(0.08f, Color.argb(255, 36, 77, 119)).addStop(1f, Color.argb(255, 51, 51, 153)).build());

        // Configure Back Arrow component
        backArrowButton = this.findViewById(R.id.back_arrow_button);
        backArrowButton.setOnClickListener((view) -> {
            this.onBackArrowPressed();
        });
    }

    public void onBackArrowPressed() {

        this.startLoginScreenActivity();
    }

    private void startLoginScreenActivity() {

        this.startActivity(LoginScreenActivity.newIntent(this));
    }

    public void startAnimationOne() {

        ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(backArrowButton, PropertyValuesHolder.ofKeyframe(View.SCALE_X, Keyframe.ofFloat(0f, 0.1f), Keyframe.ofFloat(0.6f, 0.48f), Keyframe.ofFloat(1f, 1f)), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, Keyframe.ofFloat(0f, 0.1f), Keyframe.ofFloat(0.6f, 0.48f), Keyframe.ofFloat(1f, 1f)));
        animator1.setDuration(1000);
        animator1.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(backArrowButton, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -1000f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.6f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(1f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0f, this.getResources().getDisplayMetrics()))));
        animator2.setDuration(1000);
        animator2.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(backArrowButton, PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0f, 0f), Keyframe.ofFloat(0.6f, 1f), Keyframe.ofFloat(1f, 1f)));
        animator3.setDuration(1000);
        animator3.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        AnimatorSet animatorSet1 = new AnimatorSet();
        animatorSet1.playTogether(animator1, animator2, animator3);
        animatorSet1.setTarget(backArrowButton);

        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animatorSet1);
        animatorSet2.start();
    }
}
