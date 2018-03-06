package online.huihua.suzhou.com.huihuaapp.ui.loan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.zhy.adapter.abslistview.ViewHolder;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.common.ApplyStatusEnum;
import online.huihua.suzhou.com.huihuaapp.common.ContStatusEnum;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.model.ContResultData;
import online.huihua.suzhou.com.huihuaapp.model.LoadApplyResultData;
import online.huihua.suzhou.com.huihuaapp.model.LoanApplyResultData;
import online.huihua.suzhou.com.huihuaapp.model.MainContResultData;
import online.huihua.suzhou.com.huihuaapp.ui.BaseActivity;
import online.huihua.suzhou.com.huihuaapp.ui.BaseRefreshActivity;
import online.huihua.suzhou.com.huihuaapp.ui.cont.ContReviewActivity;
import online.huihua.suzhou.com.huihuaapp.ui.maincont.MainContReviewActivity;
import online.huihua.suzhou.com.huihuaapp.util.LogUtil;
import online.huihua.suzhou.com.huihuaapp.util.ObjectMapperFactory;
import online.huihua.suzhou.com.huihuaapp.util.Wethod;

/**
 * Created by wanglei on 2018/2/28.
 * 借款申请
 */

public class LoanApplyListActivity extends BaseRefreshActivity<LoadApplyResultData.ActionResultsListBean> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defultlist);
        ButterKnife.bind(this);

        initBackBtn();
        setTitle("借款申请审批");

        initRefreshView();

        getData();
    }

    @Override
    public void onSuccess(int reqcode, Object result) {
        if (reqcode == GET_Data_Tag) {
            cancelDialog();
            onRefreshComplete();
            LoadApplyResultData contResultData = ObjectMapperFactory.convertJsonToObject(result.toString(), LoadApplyResultData.class);
            if (currentPage == PAGE_FROM) {
                setNewData(contResultData.getActionResultsList());
            } else {
                addData(contResultData.getActionResultsList());
            }
        }
    }

    @Override
    public void onFailed(int reqcode, Object result) {

    }

    @Override
    public void onError(VolleyError volleyError) {

    }

    @Override
    public void getData() {
        showDialog("正在加载...");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Owner", commonSearchView.getSearchValue().getOwner());
            jsonObject.put("Status", commonSearchView.getSearchValue().getStatus());
            jsonObject.put("UserID", getUserId());
            jsonObject.put("CompanyNo", getCompanyNo());
            jsonObject.put("PageNo", currentPage);
            jsonObject.put("PageSize", pageLength);
            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, GET_Data_Tag, HuihuaConfig.Http.ApplySelect, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.activity_apply_list_item;
    }

    @Override
    public void itemBindView(ViewHolder viewHolder, LoadApplyResultData.ActionResultsListBean item, int position) {
        TextView tv_MAINCONT_NO = (TextView) viewHolder.getView(R.id.tv_MAINCONT_NO);
        TextView tv_OWNER_NAME = (TextView) viewHolder.getView(R.id.tv_OWNER_NAME);
        TextView tv_CREDITLINE = (TextView) viewHolder.getView(R.id.tv_BORROW_AMT);
        TextView tv_STATUS = (TextView) viewHolder.getView(R.id.tv_STATUS);
        tv_MAINCONT_NO.setText(item.getSHEET_ID());
        tv_OWNER_NAME.setText(item.getOWNER_NAME());
        tv_CREDITLINE.setText(item.getBORROW_AMT());
        tv_STATUS.setText(ApplyStatusEnum.findKey(item.getSTATUS()).getName());
    }

    @Override
    public void onListViewItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i ==0)return;
        Intent intent = new Intent();
        intent.setClass(this, LoadApplyReviewActivity.class);
        intent.putExtra("CONT_NO", getDatas().get(i-1).getSHEET_ID());
        startActivity(intent);
    }
}
