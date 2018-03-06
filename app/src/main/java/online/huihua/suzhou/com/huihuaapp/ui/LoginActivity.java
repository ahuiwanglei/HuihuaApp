package online.huihua.suzhou.com.huihuaapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.model.GetUserBaseInfoResultData;
import online.huihua.suzhou.com.huihuaapp.model.LoginResultData;
import online.huihua.suzhou.com.huihuaapp.util.Des;
import online.huihua.suzhou.com.huihuaapp.util.LogUtil;
import online.huihua.suzhou.com.huihuaapp.util.MD5;
import online.huihua.suzhou.com.huihuaapp.util.ObjectMapperFactory;
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
    private static final int GetUserBaseInfo = 2;

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

        if (StringUtil.isNotEmpty(SharedPreferenceUtils.getString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.UserName))) {
            goMain();
        } else {
            SharedPreferenceUtils.clear(this, HuihuaConfig.CONFIGNAME);
        }
        String secret = SharedPreferenceUtils.getString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.EncryptKey);
        if (StringUtil.isEmpty(secret)) {
            SharedPreferenceUtils.putString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.EncryptKey, HuihuaConfig.DefultSecret);
        }
    }

    @OnClick(R.id.login_commit_btn)
    public void postLogin(View view) {
        if (check()) {
            showDialog("正在登录...");
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("UserID", loginNameEt.getText().toString());
                jsonObject.put("UserPwd", MD5.getMd5(loginPwdEt.getText().toString()));
                jsonObject.put("CompanyNo", loginCompanyEt.getText().toString());
                SharedPreferenceUtils.putString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.USERID, loginNameEt.getText().toString());
                SharedPreferenceUtils.putString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.CompanyNo, loginCompanyEt.getText().toString());
                SharedPreferenceUtils.putString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.Pwd, MD5.getMd5(loginPwdEt.getText().toString()));
                LogUtil.print(jsonObject.toString());
                Wethod.jsonPost(Request.Method.POST, this, LOGIN_TAG, HuihuaConfig.Http.login, jsonObject.toString(), this);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    private void getUserBaseInfo() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("UserID", loginNameEt.getText().toString());
            jsonObject.put("CompanyNo", loginCompanyEt.getText().toString());
            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, GetUserBaseInfo, HuihuaConfig.Http.GetUserBaseInfo, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
        if (reqcode == LOGIN_TAG) {
            LoginResultData memberCountInfoBean = ObjectMapperFactory.convertJsonToObject(result.toString(), LoginResultData.class);
            if (memberCountInfoBean.getActionResultsList() != null && memberCountInfoBean.getActionResultsList().size() > 0) {
                SharedPreferenceUtils.putString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.TOKENKEY, memberCountInfoBean.getActionResultsList().get(0).getAccessToken());
                SharedPreferenceUtils.putString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.EncryptKey, memberCountInfoBean.getActionResultsList().get(0).getEncryptKey());
//                    goMain();
                getUserBaseInfo();
            } else {
                ToastUtils.show(this, memberCountInfoBean.getErrorDesc());
            }
        } else if (reqcode == GetUserBaseInfo) {
            cancelDialog();
            GetUserBaseInfoResultData getUserBaseInfoResultData = ObjectMapperFactory.convertJsonToObject(result.toString(), GetUserBaseInfoResultData.class);
            if (getUserBaseInfoResultData.getActionResultsList() != null && getUserBaseInfoResultData.getActionResultsList().size() > 0) {
                SharedPreferenceUtils.putString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.UserName, getUserBaseInfoResultData.getActionResultsList().get(0).getUserName());
                SharedPreferenceUtils.putString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.ReportAuth, getUserBaseInfoResultData.getActionResultsList().get(0).getReportAuth());
                goMain();

            }
        }
    }

    @Override
    public void onFailed(int reqcode, Object result) {

    }

    @Override
    public void onError(VolleyError volleyError) {

    }
}
