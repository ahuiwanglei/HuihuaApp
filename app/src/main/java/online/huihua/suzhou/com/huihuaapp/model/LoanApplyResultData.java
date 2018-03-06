package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/4.
 */

public class LoanApplyResultData {

    private int ActionResults;
    private String ErrorDesc;
    private Object Signature;
    private List<LoginResultData.ActionResultsListBean> ActionResultsList;

    public int getActionResults() {
        return ActionResults;
    }

    public void setActionResults(int ActionResults) {
        this.ActionResults = ActionResults;
    }

    public String getErrorDesc() {
        return ErrorDesc;
    }

    public void setErrorDesc(String ErrorDesc) {
        this.ErrorDesc = ErrorDesc;
    }

    public Object getSignature() {
        return Signature;
    }

    public void setSignature(Object Signature) {
        this.Signature = Signature;
    }

    public List<LoginResultData.ActionResultsListBean> getActionResultsList() {
        return ActionResultsList;
    }

    public void setActionResultsList(List<LoginResultData.ActionResultsListBean> ActionResultsList) {
        this.ActionResultsList = ActionResultsList;
    }

    public static class ActionResultsListBean {
        /**
         * AccessToken : 2BFCC7AAADB968CFE181DD9C431317EAB3AA39A2
         * EncryptKey : FA2FD925F7F14E7DAB7EAD38DED733BA
         */

        private String AccessToken;
        private String EncryptKey;

        public String getAccessToken() {
            return AccessToken;
        }

        public void setAccessToken(String AccessToken) {
            this.AccessToken = AccessToken;
        }

        public String getEncryptKey() {
            return EncryptKey;
        }

        public void setEncryptKey(String EncryptKey) {
            this.EncryptKey = EncryptKey;
        }
    }
}
