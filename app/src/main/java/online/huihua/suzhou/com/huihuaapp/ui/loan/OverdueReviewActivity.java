package online.huihua.suzhou.com.huihuaapp.ui.loan;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.common.ApplyStatusEnum;
import online.huihua.suzhou.com.huihuaapp.common.ContStatusEnum;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.model.CommonResultData;
import online.huihua.suzhou.com.huihuaapp.model.ContDetailResultData;
import online.huihua.suzhou.com.huihuaapp.model.LoanApplyDetailResultData;
import online.huihua.suzhou.com.huihuaapp.model.OverdueDetailResultData;
import online.huihua.suzhou.com.huihuaapp.ui.BaseReviewActivity;
import online.huihua.suzhou.com.huihuaapp.util.LogUtil;
import online.huihua.suzhou.com.huihuaapp.util.ObjectMapperFactory;
import online.huihua.suzhou.com.huihuaapp.util.Wethod;
import online.huihua.suzhou.com.huihuaapp.view.ToastUtils;

/**
 * Created by wanglei on 2018/3/3.
 */

public class OverdueReviewActivity extends BaseReviewActivity {


    String CONT_NO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_show_info);
        ButterKnife.bind(this);

        CONT_NO = getIntent().getStringExtra("CONT_NO");

        initBackBtn();

        setTitle("逾期调整审批详情");

        getData();


    }

    @Override
    public void getData() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Sheet_id", CONT_NO);
            jsonObject.put("CompanyNo", getCompanyNo());

            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, GET_Data_Tag, HuihuaConfig.Http.OverdueDetail, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onSuccess(int reqcode, Object result) {
        if (reqcode == GET_Data_Tag) {
            OverdueDetailResultData contDetailResultData = ObjectMapperFactory.convertJsonToObject(result.toString(), OverdueDetailResultData.class);
            if(contDetailResultData.getActionResults() ==HuihuaConfig.Http.HttpCommonCode){
                ToastUtils.show(this, contDetailResultData.getErrorDesc());
                return;
            }
            OverdueDetailResultData.ActionResultsListBean bean = contDetailResultData.getActionResultsList().get(0);

            itemList.add(new ItemDataInfo("单号", bean.getSHEET_ID(), bean.getSHEET_ID()));
            itemList.add(new ItemDataInfo("单据日期", bean.getSHEET_DATE(), bean.getSHEET_DATE()));
            itemList.add(new ItemDataInfo("客户", bean.getOWNER_NAME(), bean.getOWNER_NAME()));
            itemList.add(new ItemDataInfo("行业", bean.getINDUSTRY_NAME(), bean.getINDUSTRY_NAME()));
            itemList.add(new ItemDataInfo("合同号", bean.getCONT_NO(), bean.getCONT_NO()));
//
            itemList.add(new ItemDataInfo("逾期利息", bean.getOVERDUE_PROP(), bean.getOVERDUE_PROP()));
            itemList.add(new ItemDataInfo("审批状态", bean.getCHECK_STATUS(), bean.getCHECK_STATUS()));
            itemList.add(new ItemDataInfo("状态", ApplyStatusEnum.findKey(bean.getSTATUS()).getName(), bean.getSTATUS()));
            itemList.add(new ItemDataInfo("审核意见", bean.getCHECK_MEMO(), bean.getCHECK_MEMO()));

            List<String> header = new ArrayList<>();
            header.add("期数");
            header.add("未还金额");
            header.add("逾期天数");
            header.add("计算逾期利息");
            header.add("调整逾期利息");

            List<List<String>> datas = new ArrayList<>();
            for (int i=0;i< contDetailResultData.getActionResultsList().size();i++){
                OverdueDetailResultData.ActionResultsListBean bean11 = contDetailResultData.getActionResultsList().get(i);
                List<String> data = new ArrayList<>();
                data.add(bean11.getPERIOD());
                data.add(bean11.getUNPAY_AMT());
                data.add(bean11.getOVERDUE_DAY());
                data.add(bean11.getOVERDUE_CAL());
                data.add(bean11.getOVERDUE_ADJ());
                datas.add(data);
            }
            tableDataList = new TableData(header, datas);

            notifyDataSetChanged();
            if(ApplyStatusEnum.ReviewPass.getValue().equals(bean.getSTATUS())){
                initReviewBtn(View.VISIBLE, false);
            }else{
                initReviewBtn(View.GONE, false);
            }
        }else if(reqcode == Post_Review_Tag){
            cancelDialog();
            CommonResultData commonResultData = ObjectMapperFactory.convertJsonToObject(result.toString(), CommonResultData.class);
            if(commonResultData.getActionResults() == HuihuaConfig.Http.HttpCommonCode){
                ToastUtils.show(this, "处理成功");
                finish();
            }else{
                ToastUtils.show(this, commonResultData.getErrorDesc());
            }
        }
    }

    @Override
    public void postHttpReview() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Sheet_id", CONT_NO);
            jsonObject.put("UserID", getUserId());
            jsonObject.put("CompanyNo", getCompanyNo());
            jsonObject.put("Check_opinion", getCheckOpinion());
            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, Post_Review_Tag, HuihuaConfig.Http.OverdueCheck, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postHttpVeto() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Sheet_id", CONT_NO);
            jsonObject.put("UserID", getUserId());
            jsonObject.put("CompanyNo", getCompanyNo());
            jsonObject.put("Check_opinion", getCheckOpinion());
            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, Post_Review_Tag, HuihuaConfig.Http.OverdueVeto, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailed(int reqcode, Object result) {

    }

    @Override
    public void onError(VolleyError volleyError) {

    }

}
