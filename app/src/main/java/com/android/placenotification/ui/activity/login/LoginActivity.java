package com.android.placenotification.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.placenotification.R;
import com.android.placenotification.ui.activity.base.BaseActivity;
import com.android.placenotification.ui.activity.dashboard.DashboardActivity;
import com.android.placenotification.utilities.CommonMethods;
import com.android.placenotification.utilities.PreferenceConnector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.android.placenotification.utilities.Constants.LOGIN_STATUS;

/**
 * Created by Gufran on 10/5/2017.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.userNameET)
    EditText userNameET;
    @BindView(R.id.passwordET)
    EditText passwordET;
    @BindView(R.id.loginBTN)
    Button loginBTN;
    @BindView(R.id.signUpTV)
    TextView signUpTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginBTN)
    public void loginClick(View view) {
        String userName = userNameET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();
        if (TextUtils.isEmpty(userName)) {
            CommonMethods.getAlertDialog(this, getResources().getString(R.string.please_enter_username), "");
            userNameET.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            CommonMethods.getAlertDialog(this, getResources().getString(R.string.please_enter_password), "");
            passwordET.requestFocus();
        } else {
            verifyLogin(userName, password);
        }
    }

    private void verifyLogin(String userName, String password) {
        PreferenceConnector.writeBoolean(this, LOGIN_STATUS, true);
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.signUpTV)
    public void signInClick(View view) {

    }

}
