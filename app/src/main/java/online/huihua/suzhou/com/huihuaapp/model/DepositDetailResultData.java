package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/6.
 */

public class DepositDetailResultData {

    /**
     * ActionResults : 1
     * ErrorDesc : 
     * ActionResultsList : [{"SHEET_ID":"BZ18030600001","SHEET_DATE":"2018-03-06","OWNER_NAME":"app测试3","INDUSTRY_NAME":"酒水","CONT_NO":"TEST2018-03-003-001","BORROW_PERIOD":"6","BORROW_AMT":"20000","DEPOSIT_AMT":"1000","ENDPAY_DATE":"2018-03-06","CHECK_STATUS":"1审批中,admin审批中,","CHECK_MEMO":null,"STATUS":"21","PLAN_AMT":"1000","RETURN_AMT":"1000","DEDUCT_AMT":"0"}]
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
         * SHEET_ID : BZ18030600001
         * SHEET_DATE : 2018-03-06
         * OWNER_NAME : app测试3
         * INDUSTRY_NAME : 酒水
         * CONT_NO : TEST2018-03-003-001
         * BORROW_PERIOD : 6
         * BORROW_AMT : 20000
         * DEPOSIT_AMT : 1000
         * ENDPAY_DATE : 2018-03-06
         * CHECK_STATUS : 1审批中,admin审批中,
         * CHECK_MEMO : null
         * STATUS : 21
         * PLAN_AMT : 1000
         * RETURN_AMT : 1000
         * DEDUCT_AMT : 0
         */

        private String SHEET_ID;
        private String SHEET_DATE;
        private String OWNER_NAME;
        private String INDUSTRY_NAME;
        private String CONT_NO;
        private String BORROW_PERIOD;
        private String BORROW_AMT;
        private String DEPOSIT_AMT;
        private String ENDPAY_DATE;
        private String CHECK_STATUS;
        private String CHECK_MEMO;
        private String STATUS;
        private String PLAN_AMT;
        private String RETURN_AMT;
        private String DEDUCT_AMT;

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

        public String getBORROW_AMT() {
            return BORROW_AMT;
        }

        public void setBORROW_AMT(String BORROW_AMT) {
            this.BORROW_AMT = BORROW_AMT;
        }

        public String getDEPOSIT_AMT() {
            return DEPOSIT_AMT;
        }

        public void setDEPOSIT_AMT(String DEPOSIT_AMT) {
            this.DEPOSIT_AMT = DEPOSIT_AMT;
        }

        public String getENDPAY_DATE() {
            return ENDPAY_DATE;
        }

        public void setENDPAY_DATE(String ENDPAY_DATE) {
            this.ENDPAY_DATE = ENDPAY_DATE;
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

        public String getPLAN_AMT() {
            return PLAN_AMT;
        }

        public void setPLAN_AMT(String PLAN_AMT) {
            this.PLAN_AMT = PLAN_AMT;
        }

        public String getRETURN_AMT() {
            return RETURN_AMT;
        }

        public void setRETURN_AMT(String RETURN_AMT) {
            this.RETURN_AMT = RETURN_AMT;
        }

        public String getDEDUCT_AMT() {
            return DEDUCT_AMT;
        }

        public void setDEDUCT_AMT(String DEDUCT_AMT) {
            this.DEDUCT_AMT = DEDUCT_AMT;
        }
    }
}
