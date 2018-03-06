package online.huihua.suzhou.com.huihuaapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.ui.cont.ContListActivity;
import online.huihua.suzhou.com.huihuaapp.ui.cont.ExtContListActivity;
import online.huihua.suzhou.com.huihuaapp.ui.loan.DepositListActivity;
import online.huihua.suzhou.com.huihuaapp.ui.loan.ExpmanualListActivity;
import online.huihua.suzhou.com.huihuaapp.ui.loan.LoanApplyListActivity;
import online.huihua.suzhou.com.huihuaapp.ui.loan.OverdueListActivity;
import online.huihua.suzhou.com.huihuaapp.ui.loan.PrePayListActivity;
import online.huihua.suzhou.com.huihuaapp.ui.maincont.MainContListActivity;
import online.huihua.suzhou.com.huihuaapp.util.SharedPreferenceUtils;

public class MainActivity extends BaseActivity {

    @BindView(R.id.layout_menu1)
    LinearLayout layoutMenu1;
    @BindView(R.id.layout_menu2)
    LinearLayout layoutMenu2;
    @BindView(R.id.layout_menu3)
    LinearLayout layoutMenu3;
    @BindView(R.id.layout_menu4)
    LinearLayout layoutMenu4;
    @BindView(R.id.layout_menu5)
    LinearLayout layoutMenu5;
    @BindView(R.id.layout_menu6)
    LinearLayout layoutMenu6;
    @BindView(R.id.layout_menu7)
    LinearLayout layoutMenu7;
    @BindView(R.id.layout_menu8)
    LinearLayout layoutMenu8;
    @BindView(R.id.layout_menu9)
    LinearLayout layoutMenu9;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.imageViewBtn)
    ImageView imageViewBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setTitle("穗华供应链金额管理系统");

        displayBackBtn(View.GONE);

        String username = SharedPreferenceUtils.getString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.UserName);
        tvUsername.setText(username +"，欢迎你");
        String ReportAuth = SharedPreferenceUtils.getString(this, HuihuaConfig.CONFIGNAME, HuihuaConfig.ReportAuth);
        if("1".equals(ReportAuth)){
            layoutMenu9.setVisibility(View.VISIBLE);
        }else{
            layoutMenu9.setVisibility(View.GONE);
        }
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


    @OnClick({R.id.layout_menu1, R.id.layout_menu2, R.id.layout_menu3,
            R.id.layout_menu4, R.id.layout_menu5, R.id.layout_menu6,
            R.id.layout_menu7, R.id.layout_menu8, R.id.layout_menu9,
            R.id.imageViewBtn})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.layout_menu1:
                intent.setClass(this, MainContListActivity.class);
                break;
            case R.id.layout_menu2:
                intent.setClass(this, ContListActivity.class);
                break;
            case R.id.layout_menu3:
                intent.setClass(this, ExtContListActivity.class);
                break;
            case R.id.layout_menu4:
                intent.setClass(this, LoanApplyListActivity.class);
                break;
            case R.id.layout_menu5:
                intent.setClass(this, PrePayListActivity.class);
                break;
            case R.id.layout_menu6:
                intent.setClass(this, ExpmanualListActivity.class);
                break;
            case R.id.layout_menu7:
                intent.setClass(this, OverdueListActivity.class);
                break;
            case R.id.layout_menu8:
                intent.setClass(this, DepositListActivity.class);
                break;
            case R.id.layout_menu9:
                intent.setClass(this, StatisticsActivity.class);
                break;
            case R.id.imageViewBtn:
                SharedPreferenceUtils.clear(this, HuihuaConfig.CONFIGNAME);
                intent.setClass(this, LoginActivity.class);
                finish();
                break;
        }
        startActivity(intent);
    }
}
