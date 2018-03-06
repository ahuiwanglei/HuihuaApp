package online.huihua.suzhou.com.huihuaapp.ui.maincont;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.zhy.adapter.abslistview.ViewHolder;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.common.MainContStatusEnum;
import online.huihua.suzhou.com.huihuaapp.model.MainContResultData;
import online.huihua.suzhou.com.huihuaapp.ui.BaseActivity;
import online.huihua.suzhou.com.huihuaapp.ui.BaseRefreshActivity;
import online.huihua.suzhou.com.huihuaapp.util.LogUtil;
import online.huihua.suzhou.com.huihuaapp.util.MD5;
import online.huihua.suzhou.com.huihuaapp.util.ObjectMapperFactory;
import online.huihua.suzhou.com.huihuaapp.util.SharedPreferenceUtils;
import online.huihua.suzhou.com.huihuaapp.util.Wethod;
import online.huihua.suzhou.com.huihuaapp.view.CommonSearchView;

/**
 * Created by wanglei on 2018/2/28.
 */

public class MainContListActivity extends BaseRefreshActivity<MainContResultData.ActionResultsListBean> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defultlist);
        ButterKnife.bind(this);

        initBackBtn();
        setTitle("主合同审核");

        initRefreshView();

        getData();
    }

    @Override
    public void getData() {
        showDialog("正在加载。。。");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Owner", commonSearchView.getSearchValue().getOwner());
            jsonObject.put("Status", commonSearchView.getSearchValue().getStatus());
            jsonObject.put("UserID", getUserId());
            jsonObject.put("CompanyNo", getCompanyNo());
            jsonObject.put("PageNo", currentPage);
            jsonObject.put("PageSize", pageLength);
            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, GET_Data_Tag, HuihuaConfig.Http.MainContSelect, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(int reqcode, Object result) {
        if (reqcode == GET_Data_Tag) {
            cancelDialog();
            onRefreshComplete();
            MainContResultData mainContResultData = ObjectMapperFactory.convertJsonToObject(result.toString(), MainContResultData.class);
            if (currentPage == PAGE_FROM) {
                setNewData(mainContResultData.getActionResultsList());
            } else {
                addData(mainContResultData.getActionResultsList());
            }
        }
    }

    @Override
    public void onFailed(int reqcode, Object result) {

    }

    @Override
    public int getItemLayoutId() {
        return R.layout.activity_main_cont_list_item;
    }

    @Override
    public void itemBindView(ViewHolder viewHolder, MainContResultData.ActionResultsListBean item, int position) {
        TextView tv_MAINCONT_NO = (TextView) viewHolder.getView(R.id.tv_MAINCONT_NO);
        TextView tv_OWNER_NAME = (TextView) viewHolder.getView(R.id.tv_OWNER_NAME);
        TextView tv_CREDITLINE = (TextView) viewHolder.getView(R.id.tv_CREDITLINE);
        TextView tv_STATUS = (TextView) viewHolder.getView(R.id.tv_STATUS);
        tv_MAINCONT_NO.setText(item.getMAINCONT_NO());
        tv_OWNER_NAME.setText(item.getOWNER_NAME());
        tv_CREDITLINE.setText(item.getCREDITLINE());
        tv_STATUS.setText(MainContStatusEnum.findKey(item.getSTATUS()).getName());
    }

    @Override
    public void onError(VolleyError volleyError) {

    }

    @Override
    public void onListViewItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i ==0)return;
        Intent intent = new Intent();
        intent.setClass(this, MainContReviewActivity.class);
        intent.putExtra("CONT_NO", getDatas().get(i -1).getMAINCONT_NO());
        startActivity(intent);
    }
}
