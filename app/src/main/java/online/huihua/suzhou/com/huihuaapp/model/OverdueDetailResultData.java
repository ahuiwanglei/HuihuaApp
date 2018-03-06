package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/6.
 */

public class OverdueDetailResultData {

    /**
     * ActionResults : 1
     * ErrorDesc : 
     * ActionResultsList : [{"SHEET_ID":"YQ18011800001","SHEET_DATE":"2018-01-18","OWNER_NAME":"测试业主1","INDUSTRY_NAME":"酒水","CONT_NO":"sh002-004","BORROW_PERIOD":"6","OVERDUE_PROP":"0.05","CHECK_STATUS":"1于2018-03-06 12:23:58审批通过,admin于2018-03-06 12:24:06审批通过,","CHECK_MEMO":null,"STATUS":"13","PERIOD":"1","UNPAY_AMT":"4000","OVERDUE_DAY":"10","OVERDUE_CAL":"200","OVERDUE_ADJ":"180"}]
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
         * SHEET_ID : YQ18011800001
         * SHEET_DATE : 2018-01-18
         * OWNER_NAME : 测试业主1
         * INDUSTRY_NAME : 酒水
         * CONT_NO : sh002-004
         * BORROW_PERIOD : 6
         * OVERDUE_PROP : 0.05
         * CHECK_STATUS : 1于2018-03-06 12:23:58审批通过,admin于2018-03-06 12:24:06审批通过,
         * CHECK_MEMO : null
         * STATUS : 13
         * PERIOD : 1
         * UNPAY_AMT : 4000
         * OVERDUE_DAY : 10
         * OVERDUE_CAL : 200
         * OVERDUE_ADJ : 180
         */

        private String SHEET_ID;
        private String SHEET_DATE;
        private String OWNER_NAME;
        private String INDUSTRY_NAME;
        private String CONT_NO;
        private String BORROW_PERIOD;
        private String OVERDUE_PROP;
        private String CHECK_STATUS;
        private String CHECK_MEMO;
        private String STATUS;
        private String PERIOD;
        private String UNPAY_AMT;
        private String OVERDUE_DAY;
        private String OVERDUE_CAL;
        private String OVERDUE_ADJ;

        public String getSHEET_ID() {
            return SHEET_ID;
        }

        public void setSHEET_ID(String SHEET_ID) {
            this.SHEET_ID = SHEET_ID;
        }

        public String getSHEET_DATE() {
            return SHEET_DATE;
        }

        public void setSHEET_DATE(String SHEET_DATE) {
            this.SHEET_DATE = SHEET_DATE;
        }

        public String getOWNER_NAME() {
            return OWNER_NAME;
        }

        public void setOWNER_NAME(String OWNER_NAME) {
            this.OWNER_NAME = OWNER_NAME;
        }

        public String getINDUSTRY_NAME() {
            return INDUSTRY_NAME;
        }

        public void setINDUSTRY_NAME(String INDUSTRY_NAME) {
            this.INDUSTRY_NAME = INDUSTRY_NAME;
        }

        public String getCONT_NO() {
            return CONT_NO;
        }

        public void setCONT_NO(String CONT_NO) {
            this.CONT_NO = CONT_NO;
        }

        public String getBORROW_PERIOD() {
            return BORROW_PERIOD;
        }

        public void setBORROW_PERIOD(String BORROW_PERIOD) {
            this.BORROW_PERIOD = BORROW_PERIOD;
        }

        public String getOVERDUE_PROP() {
            return OVERDUE_PROP;
        }

        public void setOVERDUE_PROP(String OVERDUE_PROP) {
            this.OVERDUE_PROP = OVERDUE_PROP;
        }

        public String getCHECK_STATUS() {
            return CHECK_STATUS;
        }

        public void setCHECK_STATUS(String CHECK_STATUS) {
            this.CHECK_STATUS = CHECK_STATUS;
        }

        public String getCHECK_MEMO() {
            return CHECK_MEMO;
        }

        public void setCHECK_MEMO(String CHECK_MEMO) {
            this.CHECK_MEMO = CHECK_MEMO;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getPERIOD() {
            return PERIOD;
        }

        public void setPERIOD(String PERIOD) {
            this.PERIOD = PERIOD;
        }

        public String getUNPAY_AMT() {
            return UNPAY_AMT;
        }

        public void setUNPAY_AMT(String UNPAY_AMT) {
            this.UNPAY_AMT = UNPAY_AMT;
        }

        public String getOVERDUE_DAY() {
            return OVERDUE_DAY;
        }

        public void setOVERDUE_DAY(String OVERDUE_DAY) {
            this.OVERDUE_DAY = OVERDUE_DAY;
        }

        public String getOVERDUE_CAL() {
            return OVERDUE_CAL;
        }

        public void setOVERDUE_CAL(String OVERDUE_CAL) {
            this.OVERDUE_CAL = OVERDUE_CAL;
        }

        public String getOVERDUE_ADJ() {
            return OVERDUE_ADJ;
        }

        public void setOVERDUE_ADJ(String OVERDUE_ADJ) {
            this.OVERDUE_ADJ = OVERDUE_ADJ;
        }
    }
}
