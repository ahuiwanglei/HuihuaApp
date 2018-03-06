package online.huihua.suzhou.com.huihuaapp.ui.loan;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.common.ApplyStatusEnum;
import online.huihua.suzhou.com.huihuaapp.common.ContStatusEnum;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.model.CommonResultData;
import online.huihua.suzhou.com.huihuaapp.model.ContDetailResultData;
import online.huihua.suzhou.com.huihuaapp.model.LoanApplyDetailResultData;
import online.huihua.suzhou.com.huihuaapp.ui.BaseReviewActivity;
import online.huihua.suzhou.com.huihuaapp.util.LogUtil;
import online.huihua.suzhou.com.huihuaapp.util.ObjectMapperFactory;
import online.huihua.suzhou.com.huihuaapp.util.Wethod;
import online.huihua.suzhou.com.huihuaapp.view.ToastUtils;

/**
 * Created by wanglei on 2018/3/3.
 */

public class LoadApplyReviewActivity extends BaseReviewActivity {


    String CONT_NO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_show_info);
        ButterKnife.bind(this);

        CONT_NO = getIntent().getStringExtra("CONT_NO");

        initBackBtn();

        setTitle("借款申请详情");

        getData();


    }

    @Override
    public void getData() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Sheet_id", CONT_NO);
            jsonObject.put("CompanyNo", getCompanyNo());

            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, GET_Data_Tag, HuihuaConfig.Http.ApplyDetail, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onSuccess(int reqcode, Object result) {
        if (reqcode == GET_Data_Tag) {
            LoanApplyDetailResultData loanApplyDetailResultData = ObjectMapperFactory.convertJsonToObject(result.toString(), LoanApplyDetailResultData.class);
            LoanApplyDetailResultData.ActionResultsListBean bean = loanApplyDetailResultData.getActionResultsList().get(0);
//            "单号   SHEET_ID
//            单据日期 SHEET_DATE
//            客户 OWNER_NAME
            itemList.add(new ItemDataInfo("单号", bean.getSHEET_ID(), bean.getSHEET_ID()));
            itemList.add(new ItemDataInfo("单据日期", bean.getSHEET_DATE(), bean.getSHEET_DATE()));
            itemList.add(new ItemDataInfo("客户", bean.getOWNER_NAME(), bean.getOWNER_NAME()));
//            行业 INDUSTRY_NAME
//            借款期数 BORROW_PERIOD
//            借款金额 BORROW_AMT
            itemList.add(new ItemDataInfo("行业", bean.getINDUSTRY_NAME(), bean.getINDUSTRY_NAME()));
            itemList.add(new ItemDataInfo("借款期数", bean.getBORROW_PERIOD(), bean.getBORROW_PERIOD()));
            itemList.add(new ItemDataInfo("借款金额", bean.getBORROW_AMT(), bean.getBORROW_AMT()));
//            借款利率 BORROW_RATE
//            服务费 SERVICE_AMT
//            保证金 DEPOSIT_AMT
            itemList.add(new ItemDataInfo("借款利率", bean.getBORROW_RATE(), bean.getBORROW_RATE()));
            itemList.add(new ItemDataInfo("服务费", bean.getSERVICE_AMT(), bean.getSERVICE_AMT()));
            itemList.add(new ItemDataInfo("保证金", bean.getDEPOSIT_AMT(), bean.getDEPOSIT_AMT()));
//            逾期利息 OVERDUE_PROP
//            逾期违约比例 PENALTY_PROP
//            授信额度 creditline
            itemList.add(new ItemDataInfo("逾期利息", bean.getOVERDUE_PROP(), bean.getOVERDUE_PROP()));
            itemList.add(new ItemDataInfo("逾期违约比例", bean.getPENALTY_PROP(), bean.getPENALTY_PROP()));
            itemList.add(new ItemDataInfo("授信额度", bean.getCREDITLINE(), bean.getCREDITLINE()));
//            剩余额度 creditline_able
//            审批状态 CHECK_STATUS
            itemList.add(new ItemDataInfo("剩余额度", bean.getCREDITLINE_ABLE(), bean.getCREDITLINE_ABLE()));
            itemList.add(new ItemDataInfo("审批状态", bean.getCHECK_STATUS(), bean.getCHECK_STATUS()));

            itemList.add(new ItemDataInfo("状态", ContStatusEnum.findKey(bean.getSTATUS()).getName(), bean.getSTATUS()));
            itemList.add(new ItemDataInfo("审核意见", bean.getCHECK_MEMO(), bean.getCHECK_MEMO()));
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
            jsonObject.put("CONT_NO", CONT_NO);
            jsonObject.put("UserID", getUserId());
            jsonObject.put("CompanyNo", getCompanyNo());
            jsonObject.put("Check_opinion", getCheckOpinion());
            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, Post_Review_Tag, HuihuaConfig.Http.ApplyCheck, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postHttpVeto() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("CONT_NO", CONT_NO);
            jsonObject.put("UserID", getUserId());
            jsonObject.put("CompanyNo", getCompanyNo());
            jsonObject.put("Check_opinion", getCheckOpinion());
            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, Post_Review_Tag, HuihuaConfig.Http.ApplyVeto, jsonObject.toString(), this);
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
