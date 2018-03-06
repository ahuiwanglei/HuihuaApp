package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/3.
 */

public class MainContResultData {

    /**
     * ActionResults : 1
     * ErrorDesc :
     * ActionResultsList : [{"MAINCONT_NO":"SHGY-2017-04-009","OWNER_NAME":"北京荣丽国际贸易股份有限公司","CREDITLINE":"990000","STATUS":"合同审批通过"}]
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
         * MAINCONT_NO : SHGY-2017-04-009
         * OWNER_NAME : 北京荣丽国际贸易股份有限公司
         * CREDITLINE : 990000
         * STATUS : 合同审批通过
         */

        private String MAINCONT_NO;
        private String OWNER_NAME;
        private String CREDITLINE;
        private String STATUS;

        public String getMAINCONT_NO() {
            return MAINCONT_NO;
        }

        public void setMAINCONT_NO(String MAINCONT_NO) {
            this.MAINCONT_NO = MAINCONT_NO;
        }

        public String getOWNER_NAME() {
            return OWNER_NAME;
        }

        public void setOWNER_NAME(String OWNER_NAME) {
            this.OWNER_NAME = OWNER_NAME;
        }

        public String getCREDITLINE() {
            return CREDITLINE;
        }

        public void setCREDITLINE(String CREDITLINE) {
            this.CREDITLINE = CREDITLINE;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }
    }
}
