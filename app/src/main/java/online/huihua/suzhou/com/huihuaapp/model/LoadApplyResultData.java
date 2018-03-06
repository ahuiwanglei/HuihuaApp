package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/6.
 */

public class LoadApplyResultData {

    /**
     * ActionResults : 1
     * ErrorDesc :
     * ActionResultsList : [{"SHEET_ID":"SH-2017-12-001-001","OWNER_NAME":"测试业主1","BORROW_AMT":"2100","STATUS":"10"},{"SHEET_ID":"SH-2017-12-001-002","OWNER_NAME":"测试业主1","BORROW_AMT":"5000","STATUS":"10"},{"SHEET_ID":"SHGY-2017-04-001-001","OWNER_NAME":"测试业主1","BORROW_AMT":"40400","STATUS":"10"},{"SHEET_ID":"TEST2018-03-002-001","OWNER_NAME":"app测试2","BORROW_AMT":"30000","STATUS":"21"},{"SHEET_ID":"TEST2018-03-003-001","OWNER_NAME":"app测试3","BORROW_AMT":"20000","STATUS":"13"},{"SHEET_ID":"sh002-001","OWNER_NAME":"测试业主1","BORROW_AMT":"10000","STATUS":"10"},{"SHEET_ID":"sh002-002","OWNER_NAME":"测试业主1","BORROW_AMT":"10000","STATUS":"10"},{"SHEET_ID":"sh002-003","OWNER_NAME":"测试业主1","BORROW_AMT":"10000","STATUS":"10"},{"SHEET_ID":"sh002-004","OWNER_NAME":"测试业主1","BORROW_AMT":"10000","STATUS":"13"},{"SHEET_ID":"sh002-005","OWNER_NAME":"测试业主1","BORROW_AMT":"2100","STATUS":"10"}]
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
         * SHEET_ID : SH-2017-12-001-001
         * OWNER_NAME : 测试业主1
         * BORROW_AMT : 2100
         * STATUS : 10
         */

        private String SHEET_ID;
        private String OWNER_NAME;
        private String BORROW_AMT;
        private String STATUS;

        public String getSHEET_ID() {
            return SHEET_ID;
        }

        public void setSHEET_ID(String SHEET_ID) {
            this.SHEET_ID = SHEET_ID;
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
