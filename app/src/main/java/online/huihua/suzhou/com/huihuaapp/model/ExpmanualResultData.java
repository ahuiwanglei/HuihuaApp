package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/6.
 */

public class ExpmanualResultData {

    /**
     * ActionResults : 1
     * ErrorDesc : 
     * ActionResultsList : [{"SHEET_ID":"0117120800001","LOCNO":"1000","OWNER_NAME":"测试业主1","SHEET_DATE":"2017-12-08","STATUS":"13"},{"SHEET_ID":"0117121100001","LOCNO":"1000","OWNER_NAME":"测试业主1","SHEET_DATE":"2017-12-11","STATUS":"13"},{"SHEET_ID":"0117121300010","LOCNO":"1000","OWNER_NAME":"测试业主1","SHEET_DATE":"2017-12-13","STATUS":"10"}]
     * Signature : null
     */

    private int ActionResults;
    private String ErrorDesc;
    private String Signature;
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

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String Signature) {
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
         * SHEET_ID : 0117120800001
         * LOCNO : 1000
         * OWNER_NAME : 测试业主1
         * SHEET_DATE : 2017-12-08
         * STATUS : 13
         */

        private String SHEET_ID;
        private String LOCNO;
        private String OWNER_NAME;
        private String SHEET_DATE;
        private String STATUS;

        public String getSHEET_ID() {
            return SHEET_ID;
        }

        public void setSHEET_ID(String SHEET_ID) {
            this.SHEET_ID = SHEET_ID;
        }

        public String getLOCNO() {
            return LOCNO;
        }

        public void setLOCNO(String LOCNO) {
            this.LOCNO = LOCNO;
        }

        public String getOWNER_NAME() {
            return OWNER_NAME;
        }

        public void setOWNER_NAME(String OWNER_NAME) {
            this.OWNER_NAME = OWNER_NAME;
        }

        public String getSHEET_DATE() {
            return SHEET_DATE;
        }

        public void setSHEET_DATE(String SHEET_DATE) {
            this.SHEET_DATE = SHEET_DATE;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }
    }
}
