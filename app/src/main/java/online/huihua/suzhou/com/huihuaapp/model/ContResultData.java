package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/3.
 */

public class ContResultData {


    /**
     * ActionResults : 1
     * ErrorDesc :
     * ActionResultsList : [{"CONT_NO":"SHGY-2017-04-003-001","OWNER_NAME":"山西星昶贸易有限责任公司","BORROW_AMT":"532766.3","STATUS":"7"},{"CONT_NO":"SHGY-2017-07-004-001","OWNER_NAME":"太原市永旺盛食品配货有限公司","BORROW_AMT":"225000","STATUS":"0"}]
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
         * CONT_NO : SHGY-2017-04-003-001
         * OWNER_NAME : 山西星昶贸易有限责任公司
         * BORROW_AMT : 532766.3
         * STATUS : 7
         */

        private String CONT_NO;
        private String OWNER_NAME;
        private String BORROW_AMT;
        private String STATUS;

        public String getCONT_NO() {
            return CONT_NO;
        }

        public void setCONT_NO(String CONT_NO) {
            this.CONT_NO = CONT_NO;
        }

        public String getOWNER_NAME() {
            return OWNER_NAME;
        }

        public void setOWNER_NAME(String OWNER_NAME) {
            this.OWNER_NAME = OWNER_NAME;
        }

        public String getBORROW_AMT() {
            return BORROW_AMT;
        }

        public void setBORROW_AMT(String BORROW_AMT) {
            this.BORROW_AMT = BORROW_AMT;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }
    }
}
