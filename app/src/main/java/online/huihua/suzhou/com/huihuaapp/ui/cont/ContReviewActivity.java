package online.huihua.suzhou.com.huihuaapp.ui.cont;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.common.ContStatusEnum;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.common.MainContStatusEnum;
import online.huihua.suzhou.com.huihuaapp.model.CommonResultData;
import online.huihua.suzhou.com.huihuaapp.model.ContDetailResultData;
import online.huihua.suzhou.com.huihuaapp.model.MainContDetailResultData;
import online.huihua.suzhou.com.huihuaapp.ui.BaseReviewActivity;
import online.huihua.suzhou.com.huihuaapp.util.LogUtil;
import online.huihua.suzhou.com.huihuaapp.util.ObjectMapperFactory;
import online.huihua.suzhou.com.huihuaapp.util.Wethod;
import online.huihua.suzhou.com.huihuaapp.view.ToastUtils;

/**
 * Created by wanglei on 2018/3/3.
 */

public class ContReviewActivity extends BaseReviewActivity {


    String CONT_NO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_show_info);
        ButterKnife.bind(this);

        CONT_NO = getIntent().getStringExtra("CONT_NO");

        initBackBtn();

        setTitle("子合同详情");

        getData();


    }

    @Override
    public void getData() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("CONT_NO", CONT_NO);
            jsonObject.put("CompanyNo", getCompanyNo());

            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, GET_Data_Tag, HuihuaConfig.Http.ContDetail, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onSuccess(int reqcode, Object result) {
        if (reqcode == GET_Data_Tag) {
            ContDetailResultData contDetailResultData = ObjectMapperFactory.convertJsonToObject(result.toString(), ContDetailResultData.class);
            if(contDetailResultData.getActionResults() ==HuihuaConfig.Http.HttpCommonCode){
                ToastUtils.show(this, contDetailResultData.getErrorDesc());
                return;
            }
            ContDetailResultData.ActionResultsListBean bean = contDetailResultData.getActionResultsList().get(0);
            itemList.add(new ItemDataInfo("客户", bean.getOWNER_NAME(), bean.getOWNER_NAME()));
            itemList.add(new ItemDataInfo("行业", bean.getINDUSTRY_NAME(), bean.getINDUSTRY_NAME()));
            itemList.add(new ItemDataInfo("子合同号", bean.getCONT_NO(), bean.getCONT_NO()));
//
//
            itemList.add(new ItemDataInfo("借款期数", bean.getBORROW_PERIOD(), bean.getBORROW_PERIOD()));
//            服务费比例 SERVICE_PROP
//            服务费 SERVICE_AMT
//            保证金比例 DEPOSIT_PROP
//            保证金 DEPOSIT_AMT

            itemList.add(new ItemDataInfo("借款金额", bean.getBORROW_AMT(), bean.getBORROW_AMT()));
            itemList.add(new ItemDataInfo("借款利率", bean.getBORROW_RATE(), bean.getBORROW_RATE()));
            itemList.add(new ItemDataInfo("服务费比例", bean.getSERVICE_PROP(), bean.getSERVICE_PROP()));
            itemList.add(new ItemDataInfo("保证金比例", bean.getOVERDUE_PROP(), bean.getOVERDUE_PROP()));

            //            逾期利息 OVERDUE_PROP
//            逾期违约比例 PENALTY_PROP
//            首期还款日期 BEGIN_DATE
//
            itemList.add(new ItemDataInfo("逾期利息", bean.getOVERDUE_PROP(), bean.getOVERDUE_PROP()));
            itemList.add(new ItemDataInfo("逾期违约比例", bean.getPENALTY_PROP(), bean.getPENALTY_PROP()));
            itemList.add(new ItemDataInfo("首期还款日期", bean.getBEGIN_DATE(), bean.getBEGIN_DATE()));

//            结束日期 END_DATE
////            我方签约人 SIGNATORY1
////            对方签约人 SIGNATORY2
////            合同审核人 CHECKUP_NAME
////            合同审核日期 CHECKUP_DATE
////            状态 STATUS"
            itemList.add(new ItemDataInfo("结束日期", bean.getEND_DATE(), bean.getEND_DATE()));
            itemList.add(new ItemDataInfo("我方签约人", bean.getSIGNATORY1(), bean.getSIGNATORY1()));
            itemList.add(new ItemDataInfo("对方签约人", bean.getSIGNATORY2(), bean.getSIGNATORY2()));
            itemList.add(new ItemDataInfo("合同审核人", bean.getCHECKUP_NAME(), bean.getCHECKUP_NAME()));
            itemList.add(new ItemDataInfo("合同审核日期", bean.getCHECKUP_DATE(), bean.getCHECKUP_DATE()));
            itemList.add(new ItemDataInfo("状态", ContStatusEnum.findKey(bean.getSTATUS()).getName(), bean.getSTATUS()));
//            itemList.add(new ItemDataInfo("审核意见", bean.getCHECK_MEMO(), bean.getCHECK_MEMO()));
            notifyDataSetChanged();
            if (ContStatusEnum.NewCreate.getValue().equals(bean.getSTATUS())) {
                initReviewBtn(View.VISIBLE, false);
                veto_commit_btn.setVisibility(View.GONE);
            }
        } else if (reqcode == Post_Review_Tag) {
            cancelDialog();
            CommonResultData commonResultData = ObjectMapperFactory.convertJsonToObject(result.toString(), CommonResultData.class);
            if (commonResultData.getActionResults() == HuihuaConfig.Http.HttpCommonCode) {
                ToastUtils.show(this, "审核成功");
                finish();
            } else {
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
            Wethod.jsonPost(Request.Method.POST, this, Post_Review_Tag, HuihuaConfig.Http.ContCheck, jsonObject.toString(), this);
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
