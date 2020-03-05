package com.hakansoftware.gunceldoviz.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hakansoftware.gunceldoviz.R;
import com.hakansoftware.gunceldoviz.controller.UserController;

import io.supernova.uitoolkit.drawable.LinearGradientDrawable;

public class RegisterScreenActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {

        // Fill the created intent with the data you want to be passed to this Activity when it's opened.
        return new Intent(context, RegisterScreenActivity.class);
    }

    private ConstraintLayout constraintLayoutConstraintLayout;
    private ImageView shapeImageView;
    private TextView guncelDovizTextView;
    private ConstraintLayout buttonConstraintLayout;
    private EditText usernameEditText;
    private Button registerButton;
    private ConstraintLayout buttonTwoConstraintLayout;
    private EditText passwordEditText;
    private ConstraintLayout buttonThreeConstraintLayout;
    private EditText confirmPasswordEditText;
    private ConstraintLayout buttonFourConstraintLayout;
    private EditText birthdayEditText;
    private ImageView icLauncherImageView;
    private ImageButton backArrowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        this.init();
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

        // Configure Shape component
        shapeImageView = this.findViewById(R.id.shape_image_view);

        // Configure Güncel Döviz component
        guncelDovizTextView = this.findViewById(R.id.guncel_doviz_text_view);

        // Configure Button component
        buttonConstraintLayout = this.findViewById(R.id.button_constraint_layout);

        // Configure UsernameEditText component
        usernameEditText = this.findViewById(R.id.username_edit_text);

        // Configure RegisterButton component
        registerButton = this.findViewById(R.id.register_button);
        registerButton.setOnClickListener((view) -> {
            this.onRegisterButtonPressed();
        });

        // Configure Button component
        buttonTwoConstraintLayout = this.findViewById(R.id.button_two_constraint_layout);

        // Configure PasswordEditText component
        passwordEditText = this.findViewById(R.id.password_edit_text);

        // Configure Button component
        buttonThreeConstraintLayout = this.findViewById(R.id.button_three_constraint_layout);

        // Configure ConfirmPasswordEditText component
        confirmPasswordEditText = this.findViewById(R.id.confirm_password_edit_text);

        // Configure Button component
        buttonFourConstraintLayout = this.findViewById(R.id.button_four_constraint_layout);

        // Configure Birthday component
        birthdayEditText = this.findViewById(R.id.birthday_edit_text);

        // Configure ic_launcher component
        icLauncherImageView = this.findViewById(R.id.ic_launcher_image_view);

        // Configure Back Arrow component
        backArrowButton = this.findViewById(R.id.back_arrow_button);
        backArrowButton.setOnClickListener((view) -> {
            this.onBackArrowPressed();
        });
    }

    public void onRegisterButtonPressed() {

        if (passwordEditText.getText().toString().trim().equals(confirmPasswordEditText.getText().toString().trim()))
        {
            UserController userController = UserController.getInstance();
            userController.register(usernameEditText.getText().toString().trim(), passwordEditText.getText().toString().trim());

            this.startListScreenActivity();
        }
    }

    public void onBackArrowPressed() {

        this.startLoginScreenActivity();
    }

    private void startListScreenActivity() {

        this.startActivity(ListScreenActivity.newIntent(this));
    }

    private void startLoginScreenActivity() {

        this.startActivity(LoginScreenActivity.newIntent(this));
    }

    public void startAnimationOne() {

        ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(shapeImageView, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -469f, 0f));
        animator1.setDuration(1000);
        animator1.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        AnimatorSet animatorSet1 = new AnimatorSet();
        animatorSet1.playTogether(animator1);
        animatorSet1.setTarget(shapeImageView);

        ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(guncelDovizTextView, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -177f, 0f));
        animator2.setDuration(1000);
        animator2.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animator2);
        animatorSet2.setTarget(guncelDovizTextView);

        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(buttonConstraintLayout, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -310f, 0f));
        animator3.setDuration(1000);
        animator3.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(animator3);
        animatorSet3.setTarget(buttonConstraintLayout);

        ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(registerButton, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -310f, 0f));
        animator4.setDuration(1000);
        animator4.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.playTogether(animator4);
        animatorSet4.setTarget(registerButton);

        ObjectAnimator animator5 = ObjectAnimator.ofPropertyValuesHolder(buttonTwoConstraintLayout, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -310f, 0f));
        animator5.setDuration(1000);
        animator5.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        AnimatorSet animatorSet5 = new AnimatorSet();
        animatorSet5.playTogether(animator5);
        animatorSet5.setTarget(buttonTwoConstraintLayout);

        ObjectAnimator animator6 = ObjectAnimator.ofPropertyValuesHolder(buttonThreeConstraintLayout, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -310f, 0f));
        animator6.setDuration(1000);
        animator6.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        AnimatorSet animatorSet6 = new AnimatorSet();
        animatorSet6.playTogether(animator6);
        animatorSet6.setTarget(buttonThreeConstraintLayout);

        ObjectAnimator animator7 = ObjectAnimator.ofPropertyValuesHolder(buttonFourConstraintLayout, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -310f, 0f));
        animator7.setDuration(1000);
        animator7.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        AnimatorSet animatorSet7 = new AnimatorSet();
        animatorSet7.playTogether(animator7);
        animatorSet7.setTarget(buttonFourConstraintLayout);

        ObjectAnimator animator8 = ObjectAnimator.ofPropertyValuesHolder(backArrowButton, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -27f, 0f));
        animator8.setDuration(1000);
        animator8.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        AnimatorSet animatorSet8 = new AnimatorSet();
        animatorSet8.playTogether(animator8);
        animatorSet8.setTarget(backArrowButton);

        ObjectAnimator animator9 = ObjectAnimator.ofPropertyValuesHolder(icLauncherImageView, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -129f, 0f));
        animator9.setDuration(1000);
        animator9.setInterpolator(PathInterpolatorCompat.create(0f, 0f, 1f, 1f));

        AnimatorSet animatorSet9 = new AnimatorSet();
        animatorSet9.playTogether(animator9);
        animatorSet9.setTarget(icLauncherImageView);

        AnimatorSet animatorSet10 = new AnimatorSet();
        animatorSet10.playTogether(animatorSet1, animatorSet2, animatorSet3, animatorSet4, animatorSet5, animatorSet6, animatorSet7, animatorSet8, animatorSet9);
        animatorSet10.start();
    }
}
