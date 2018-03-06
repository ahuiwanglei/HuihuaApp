package online.huihua.suzhou.com.huihuaapp.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.model.OwnerResultData;
import online.huihua.suzhou.com.huihuaapp.model.SearchParamValue;
import online.huihua.suzhou.com.huihuaapp.util.LogUtil;
import online.huihua.suzhou.com.huihuaapp.util.MD5;
import online.huihua.suzhou.com.huihuaapp.util.ObjectMapperFactory;
import online.huihua.suzhou.com.huihuaapp.util.SharedPreferenceUtils;
import online.huihua.suzhou.com.huihuaapp.util.VolleyCallBack;
import online.huihua.suzhou.com.huihuaapp.util.Wethod;

/**
 * Created by wanglei on 2018/3/3.
 */

public class CommonSearchView extends LinearLayout implements VolleyCallBack {

    private TextView tv_select_owner;
    private RadioGroup radioGroup;
    private RadioButton rb_dsh;
    private RadioButton rb_qb;
    private Button btn_search;

    private String selectOwner ="";

    private static final int get_owner_info = 1;

    List<OwnerResultData.ActionResultsListBean> actionResultsListBeans;

    OnSearchActionListener onSearchActionListener;

    public CommonSearchView(Context context) {
        super(context);
        init(context, null);
    }

    public CommonSearchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CommonSearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CommonSearchView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.layout_search_view, this);
        tv_select_owner = (TextView) findViewById(R.id.tv_select_owner);
        radioGroup = (RadioGroup) findViewById(R.id.rg_status);
        rb_dsh = (RadioButton) findViewById(R.id.rb_dsh);
        rb_qb = (RadioButton) findViewById(R.id.rb_qb);
        btn_search = (Button)findViewById(R.id.btn_search);

        getData();

        tv_select_owner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                handlerOwner();
            }
        });

        btn_search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onSearchActionListener != null){
                    onSearchActionListener.onSearchAction();
                }
            }
        });
    }


    private void getData() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("CompanyNo", getCompanyNo());
            jsonObject.put("UserID", getUserId());
            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, getContext(), get_owner_info, HuihuaConfig.Http.GetOwnerInfo, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getUserId() {
        return SharedPreferenceUtils.getString(getContext(), HuihuaConfig.CONFIGNAME, HuihuaConfig.USERID);
    }

    public String getCompanyNo() {
        return SharedPreferenceUtils.getString(getContext(), HuihuaConfig.CONFIGNAME, HuihuaConfig.CompanyNo);
    }


    @Override
    public void onSuccess(int reqcode, Object result) {
        if (reqcode == get_owner_info) {
            OwnerResultData ownerResultData = ObjectMapperFactory.convertJsonToObject(result.toString(), OwnerResultData.class);
            if (ownerResultData.getActionResultsList() != null && ownerResultData.getActionResultsList().size() > 0) {
                actionResultsListBeans = ownerResultData.getActionResultsList();
            } else {
                ToastUtils.show(getContext(), ownerResultData.getErrorDesc());
            }
        }
    }

    private void handlerOwner() {
        String[] mItems = new String[actionResultsListBeans.size()];
        for (int i = 0; i < actionResultsListBeans.size(); i++) {
            mItems[i] = actionResultsListBeans.get(i).getOwnerName();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("请选择客户");
        builder.setItems(mItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectOwner = actionResultsListBeans.get(which).getOwnerNo();
                tv_select_owner.setText(actionResultsListBeans.get(which).getOwnerName());
            }
        });

        builder.create();
        builder.show();
    }

    public SearchParamValue getSearchValue() {
        SearchParamValue searchParamValue = new SearchParamValue();
        searchParamValue.setStatus(getSelectStatus());
        searchParamValue.setOwner(selectOwner);
        return searchParamValue;
    }

    private String getSelectStatus() {
        if (rb_dsh.isChecked()) {
            return "0";
        } else {
            return "1";
        }
    }

    @Override
    public void onFailed(int reqcode, Object result) {

    }

    @Override
    public void onError(VolleyError volleyError) {

    }

    public void setOnSearchActionListener(OnSearchActionListener onSearchActionListener) {
        this.onSearchActionListener = onSearchActionListener;
    }

    public interface  OnSearchActionListener{
        public void onSearchAction();
    }
}
