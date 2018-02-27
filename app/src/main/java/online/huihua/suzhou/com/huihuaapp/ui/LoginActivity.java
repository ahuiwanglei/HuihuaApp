package online.huihua.suzhou.com.huihuaapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.util.Des;
import online.huihua.suzhou.com.huihuaapp.util.MD5;
import online.huihua.suzhou.com.huihuaapp.util.SharedPreferenceUtils;
import online.huihua.suzhou.com.huihuaapp.util.StringUtil;
import online.huihua.suzhou.com.huihuaapp.util.Wethod;
import online.huihua.suzhou.com.huihuaapp.util.update.UpdateManager;
import online.huihua.suzhou.com.huihuaapp.view.ClearEditText;
import online.huihua.suzhou.com.huihuaapp.view.ToastUtils;

/**
 * Created by wanglei on 2018/2/25.
 */

public class LoginActivity extends BaseActivity {
    private static final int LOGIN_TAG = 1;

    UpdateManager upManager = null;
    @BindView(R.id.login_name_et)
    ClearEditText loginNameEt;
    @BindView(R.id.login_pwd_et)
    ClearEditText loginPwdEt;
    @BindView(R.id.login_commit_btn)
    Button loginCommitBtn;
    @BindView(R.id.login_company_et)
    ClearEditText loginCompanyEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        upManager = UpdateManager.getUpdateManager();
        upManager.checkAppUpdate(LoginActivity.this, false);

        if (StringUtil.isNotEmpty(SharedPreferenceUtils.getString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.USERID))) {
            goMain();
        } else {
            SharedPreferenceUtils.clear(this, HuihuaConfig.CONFIGNAME);
        }
    }

    @OnClick(R.id.login_commit_btn)
    public void postLogin(View view) {
//        SharedPreferenceUtils.clear(this, HuihuaConfig.CONFIGNAME);
//        if (check()) {
//            showDialog("正在登录...");
//            JSONObject jsonObject = new JSONObject();
//            try {
//                jsonObject.put("UserID", loginNameEt.getText().toString());
//                jsonObject.put("UserPwd", MD5.getMd5(loginPwdEt.getText().toString()));
//                jsonObject.put("CompanyNo", loginCompanyEt.getText().toString());
//                SharedPreferenceUtils.putString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.Pwd,  MD5.getMd5(loginPwdEt.getText().toString()));
//                Wethod.jsonPost(Request.Method.POST, this, LOGIN_TAG, HuihuaConfig.Http.login, Des.encrypt(jsonObject.toString()), this);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            }
//        }
        goMain();
    }

    private boolean check() {
        if (StringUtil.isEmpty(loginNameEt.getText().toString())) {
            ToastUtils.show(this, "请输入用户名！");
            return false;
        }
        if (StringUtil.isEmpty(loginPwdEt.getText().toString())) {
            ToastUtils.show(this, "请输入密码！");
        }
        if (StringUtil.isEmpty(loginCompanyEt.getText().toString())) {
            ToastUtils.show(this, "请输入企业！");
        }

        return true;

    }

    private void goMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSuccess(int reqcode, Object result) {

    }

    @Override
    public void onFailed(int reqcode, Object result) {

    }

    @Override
    public void onError(VolleyError volleyError) {

    }
}
