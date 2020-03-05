package com.hakansoftware.gunceldoviz.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hakansoftware.gunceldoviz.R;
import com.hakansoftware.gunceldoviz.controller.UserController;

import io.supernova.uitoolkit.drawable.LinearGradientDrawable;

public class LoginScreenActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {

        // Fill the created intent with the data you want to be passed to this Activity when it's opened.
        return new Intent(context, LoginScreenActivity.class);
    }

    private ConstraintLayout constraintLayoutConstraintLayout;
    private Button registerButton;
    private ImageView shapeImageView;
    private TextView guncelDovizTextView;
    private ConstraintLayout buttonConstraintLayout;
    private EditText userNameEditText;
    private Button loginButton;
    private ConstraintLayout buttonTwoConstraintLayout;
    private EditText passwordEditText;
    private ImageView icLauncherImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
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

        // Configure RegisterButton component
        registerButton = this.findViewById(R.id.register_button);
        registerButton.setOnClickListener((view) -> {
            this.onButtonPressed();
        });

        // Configure Shape component
        shapeImageView = this.findViewById(R.id.shape_image_view);

        // Configure Güncel Döviz component
        guncelDovizTextView = this.findViewById(R.id.guncel_doviz_text_view);

        // Configure Button component
        buttonConstraintLayout = this.findViewById(R.id.button_constraint_layout);

        // Configure UsernameEditText component
        userNameEditText = this.findViewById(R.id.user_name_edit_text);

        // Configure LoginButton component
        loginButton = this.findViewById(R.id.login_button);
        loginButton.setOnClickListener((view) -> {
            this.onLoginButtonPressed();
        });

        // Configure Button component
        buttonTwoConstraintLayout = this.findViewById(R.id.button_two_constraint_layout);

        // Configure PasswordEditText component
        passwordEditText = this.findViewById(R.id.password_edit_text);

        // Configure ic_launcher component
        icLauncherImageView = this.findViewById(R.id.ic_launcher_image_view);
    }

    public void onButtonPressed() {

        this.startRegisterScreenActivity();
    }

    public void onLoginButtonPressed() {
        UserController userController = UserController.getInstance();
        userController.login(getApplicationContext(), userNameEditText.getText().toString().trim(), passwordEditText.getText().toString().trim());
        //this.startListScreenActivity();
    }

    private void startRegisterScreenActivity() {

        this.startActivity(RegisterScreenActivity.newIntent(this));
    }

    private void startListScreenActivity() {

        this.startActivity(ListScreenActivity.newIntent(this));
    }

    public void startAnimationOne() {

        ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(registerButton, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3000f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.6f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -25f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.75f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.9f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -5f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(1f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0f, this.getResources().getDisplayMetrics()))));
        animator1.setDuration(1000);
        animator1.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(registerButton, PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0f, 0f), Keyframe.ofFloat(0.6f, 1f), Keyframe.ofFloat(1f, 1f)));
        animator2.setDuration(1000);
        animator2.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        AnimatorSet animatorSet1 = new AnimatorSet();
        animatorSet1.playTogether(animator1, animator2);
        animatorSet1.setTarget(registerButton);

        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(shapeImageView, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3000f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.6f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -25f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.75f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.9f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -5f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(1f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0f, this.getResources().getDisplayMetrics()))));
        animator3.setDuration(1000);
        animator3.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(shapeImageView, PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0f, 0f), Keyframe.ofFloat(0.6f, 1f), Keyframe.ofFloat(1f, 1f)));
        animator4.setDuration(1000);
        animator4.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animator3, animator4);
        animatorSet2.setTarget(shapeImageView);

        ObjectAnimator animator5 = ObjectAnimator.ofPropertyValuesHolder(guncelDovizTextView, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3000f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.6f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -25f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.75f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.9f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -5f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(1f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0f, this.getResources().getDisplayMetrics()))));
        animator5.setDuration(1000);
        animator5.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        ObjectAnimator animator6 = ObjectAnimator.ofPropertyValuesHolder(guncelDovizTextView, PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0f, 0f), Keyframe.ofFloat(0.6f, 1f), Keyframe.ofFloat(1f, 1f)));
        animator6.setDuration(1000);
        animator6.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(animator5, animator6);
        animatorSet3.setTarget(guncelDovizTextView);

        ObjectAnimator animator7 = ObjectAnimator.ofPropertyValuesHolder(buttonConstraintLayout, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3000f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.6f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -25f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.75f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.9f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -5f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(1f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0f, this.getResources().getDisplayMetrics()))));
        animator7.setDuration(1000);
        animator7.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        ObjectAnimator animator8 = ObjectAnimator.ofPropertyValuesHolder(buttonConstraintLayout, PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0f, 0f), Keyframe.ofFloat(0.6f, 1f), Keyframe.ofFloat(1f, 1f)));
        animator8.setDuration(1000);
        animator8.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.playTogether(animator7, animator8);
        animatorSet4.setTarget(buttonConstraintLayout);

        ObjectAnimator animator9 = ObjectAnimator.ofPropertyValuesHolder(loginButton, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3000f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.6f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -25f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.75f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.9f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -5f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(1f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0f, this.getResources().getDisplayMetrics()))));
        animator9.setDuration(1000);
        animator9.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        ObjectAnimator animator10 = ObjectAnimator.ofPropertyValuesHolder(loginButton, PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0f, 0f), Keyframe.ofFloat(0.6f, 1f), Keyframe.ofFloat(1f, 1f)));
        animator10.setDuration(1000);
        animator10.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        AnimatorSet animatorSet5 = new AnimatorSet();
        animatorSet5.playTogether(animator9, animator10);
        animatorSet5.setTarget(loginButton);

        ObjectAnimator animator11 = ObjectAnimator.ofPropertyValuesHolder(buttonTwoConstraintLayout, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3000f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.6f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -25f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.75f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.9f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -5f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(1f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0f, this.getResources().getDisplayMetrics()))));
        animator11.setDuration(1000);
        animator11.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        ObjectAnimator animator12 = ObjectAnimator.ofPropertyValuesHolder(buttonTwoConstraintLayout, PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0f, 0f), Keyframe.ofFloat(0.6f, 1f), Keyframe.ofFloat(1f, 1f)));
        animator12.setDuration(1000);
        animator12.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        AnimatorSet animatorSet6 = new AnimatorSet();
        animatorSet6.playTogether(animator11, animator12);
        animatorSet6.setTarget(buttonTwoConstraintLayout);

        ObjectAnimator animator13 = ObjectAnimator.ofPropertyValuesHolder(icLauncherImageView, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3000f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.6f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -25f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.75f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(0.9f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -5f, this.getResources().getDisplayMetrics())), Keyframe.ofFloat(1f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0f, this.getResources().getDisplayMetrics()))));
        animator13.setDuration(1000);
        animator13.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        ObjectAnimator animator14 = ObjectAnimator.ofPropertyValuesHolder(icLauncherImageView, PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0f, 0f), Keyframe.ofFloat(0.6f, 1f), Keyframe.ofFloat(1f, 1f)));
        animator14.setDuration(1000);
        animator14.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f));

        AnimatorSet animatorSet7 = new AnimatorSet();
        animatorSet7.playTogether(animator13, animator14);
        animatorSet7.setTarget(icLauncherImageView);

        AnimatorSet animatorSet8 = new AnimatorSet();
        animatorSet8.playTogether(animatorSet1, animatorSet2, animatorSet3, animatorSet4, animatorSet5, animatorSet6, animatorSet7);
        animatorSet8.start();
    }
}
