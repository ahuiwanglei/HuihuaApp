package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/2/27.
 */

public class OwnerResultData {


    /**
     * ActionResults : 1
     * ErrorDesc :
     * ActionResultsList : [{"AccessToken":"2BFCC7AAADB968CFE181DD9C431317EAB3AA39A2","EncryptKey":"FA2FD925F7F14E7DAB7EAD38DED733BA"}]
     * Signature : null
     */

    private int ActionResults;
    private String ErrorDesc;
    private Object Signature;
    private List<ActionResultsListBean> ActionResultsList;

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

    public List<ActionResultsListBean> getActionResultsList() {
        return ActionResultsList;
    }

    public void setActionResultsList(List<ActionResultsListBean> ActionResultsList) {
        this.ActionResultsList = ActionResultsList;
    }

    public static class ActionResultsListBean {
        /**
         * AccessToken : 2BFCC7AAADB968CFE181DD9C431317EAB3AA39A2
         * EncryptKey : FA2FD925F7F14E7DAB7EAD38DED733BA
         */

        private String OwnerNo;
        private String OwnerName;

        public String getOwnerNo() {
            return OwnerNo;
        }

        public void setOwnerNo(String ownerNo) {
            OwnerNo = ownerNo;
        }

        public String getOwnerName() {
            return OwnerName;
        }

        public void setOwnerName(String ownerName) {
            OwnerName = ownerName;
        }
    }
}
