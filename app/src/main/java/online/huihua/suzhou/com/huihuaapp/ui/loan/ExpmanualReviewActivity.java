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
import online.huihua.suzhou.com.huihuaapp.model.ExpmanualDetailResultData;
import online.huihua.suzhou.com.huihuaapp.ui.BaseReviewActivity;
import online.huihua.suzhou.com.huihuaapp.util.LogUtil;
import online.huihua.suzhou.com.huihuaapp.util.ObjectMapperFactory;
import online.huihua.suzhou.com.huihuaapp.util.Wethod;
import online.huihua.suzhou.com.huihuaapp.view.ToastUtils;

/**
 * Created by wanglei on 2018/3/3.
 */

public class ExpmanualReviewActivity extends BaseReviewActivity {


    String CONT_NO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_show_info);
        ButterKnife.bind(this);

        CONT_NO = getIntent().getStringExtra("CONT_NO");

        initBackBtn();

        setTitle("出货审批详情");

        getData();


    }

    @Override
    public void getData() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Sheet_id", CONT_NO);
            jsonObject.put("CompanyNo", getCompanyNo());

            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, GET_Data_Tag, HuihuaConfig.Http.ExpmanualDetail, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onSuccess(int reqcode, Object result) {
        if (reqcode == GET_Data_Tag) {
            ExpmanualDetailResultData contDetailResultData = ObjectMapperFactory.convertJsonToObject(result.toString(), ExpmanualDetailResultData.class);
            ExpmanualDetailResultData.ActionResultsListBean bean = contDetailResultData.getActionResultsList().get(0);
//            "单号 SHEET_ID
//            仓别 LOCNO
//            单据日期 SHEET_DATE
            itemList.add(new ItemDataInfo("单号", bean.getSHEET_ID(), bean.getSHEET_ID()));
            itemList.add(new ItemDataInfo("仓别", bean.getLOCNO(), bean.getLOCNO()));
            itemList.add(new ItemDataInfo("单据日期", bean.getSHEET_DATE(), bean.getSHEET_DATE()));
//            客户   OWNER_NAME
//            主合同号 MAINCONT_NO
//            计划出货日期 REQUEST_DATE
//            itemList.add(new ItemDataInfo("客户", bean.getOWNER_NAME(), bean.getOWNER_NAME()));
//            itemList.add(new ItemDataInfo("主合同号", bean.getMAINCONTNO(), bean.getMAINCONT_NO()));
//            itemList.add(new ItemDataInfo("计划出货日期", bean.getREQUEST_DATE(), bean.getREQUEST_DATE()));
//            门店 CUSTOMER_NAME
//            允许出货金额 ALLOW_AMT
//            出货金额 OM_AMT
//             审批状态 CHECK_STATUS
//            状态 STATUS"
//            itemList.add(new ItemDataInfo("门店", bean.getCUSTOMER_NAME(), bean.getCUSTOMER_NAME()));
//            itemList.add(new ItemDataInfo("允许出货金额", bean.getALLOW_AMT(), bean.getALLOW_AMT()));
//            itemList.add(new ItemDataInfo("出货金额", bean.getOM_AMT(), bean.getOM_AMT()));
//            itemList.add(new ItemDataInfo("审批状态", bean.getCHECK_STATUS(), bean.getCHECK_STATUS()));
            itemList.add(new ItemDataInfo("状态", ContStatusEnum.findKey(bean.getSTATUS()).getName(), bean.getSTATUS()));
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
            Wethod.jsonPost(Request.Method.POST, this, Post_Review_Tag, HuihuaConfig.Http.ExpmanualCheck, jsonObject.toString(), this);
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
            Wethod.jsonPost(Request.Method.POST, this, Post_Review_Tag, HuihuaConfig.Http.ExpmanualVeto, jsonObject.toString(), this);
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
