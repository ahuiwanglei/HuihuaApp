package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/4.
 */

public class LoanApplyDetailResultData {

    /**
     * ActionResults : 1
     * ErrorDesc : 
     * ActionResultsList : [{"SHEET_ID":"SH-2017-12-001-001","SHEET_DATE":"2017-12-28","OWNER_NAME":"测试业主1","MAINCONT_NO":"SH-2017-12-001","INDUSTRY_NAME":"酒水","BORROW_PERIOD":"6","BORROW_AMT":"2100","BORROW_RATE":"0.03","SERVICE_AMT":"105","DEPOSIT_AMT":"126","OVERDUE_PROP":"0.01","PENALTY_PROP":"0.02","PREPAY_PROP":"0.02","CREDITLINE":"100000","CREDITLINE_ABLE":"0","CHECK_STATUS":null,"CHECK_MEMO":null,"STATUS":"10","ARTICLE_NAME":"001","PACKING_QTY":"10","BOX_QTY":"10","RET_QTY":"5","BOXIMPAWN_PRICE":"200","IMPAWN_AMT":"2100"}]
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
         * SHEET_ID : SH-2017-12-001-001
         * SHEET_DATE : 2017-12-28
         * OWNER_NAME : 测试业主1
         * MAINCONT_NO : SH-2017-12-001
         * INDUSTRY_NAME : 酒水
         * BORROW_PERIOD : 6
         * BORROW_AMT : 2100
         * BORROW_RATE : 0.03
         * SERVICE_AMT : 105
         * DEPOSIT_AMT : 126
         * OVERDUE_PROP : 0.01
         * PENALTY_PROP : 0.02
         * PREPAY_PROP : 0.02
         * CREDITLINE : 100000
         * CREDITLINE_ABLE : 0
         * CHECK_STATUS : null
         * CHECK_MEMO : null
         * STATUS : 10
         * ARTICLE_NAME : 001
         * PACKING_QTY : 10
         * BOX_QTY : 10
         * RET_QTY : 5
         * BOXIMPAWN_PRICE : 200
         * IMPAWN_AMT : 2100
         */

        private String SHEET_ID;
        private String SHEET_DATE;
        private String OWNER_NAME;
        private String MAINCONT_NO;
        private String INDUSTRY_NAME;
        private String BORROW_PERIOD;
        private String BORROW_AMT;
        private String BORROW_RATE;
        private String SERVICE_AMT;
        private String DEPOSIT_AMT;
        private String OVERDUE_PROP;
        private String PENALTY_PROP;
        private String PREPAY_PROP;
        private String CREDITLINE;
        private String CREDITLINE_ABLE;
        private String CHECK_STATUS;
        private String CHECK_MEMO;
        private String STATUS;
        private String ARTICLE_NAME;
        private String PACKING_QTY;
        private String BOX_QTY;
        private String RET_QTY;
        private String BOXIMPAWN_PRICE;
        private String IMPAWN_AMT;

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

        public String getMAINCONT_NO() {
            return MAINCONT_NO;
        }

        public void setMAINCONT_NO(String MAINCONT_NO) {
            this.MAINCONT_NO = MAINCONT_NO;
        }

        public String getINDUSTRY_NAME() {
            return INDUSTRY_NAME;
        }

        public void setINDUSTRY_NAME(String INDUSTRY_NAME) {
            this.INDUSTRY_NAME = INDUSTRY_NAME;
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

        public String getBORROW_RATE() {
            return BORROW_RATE;
        }

        public void setBORROW_RATE(String BORROW_RATE) {
            this.BORROW_RATE = BORROW_RATE;
        }

        public String getSERVICE_AMT() {
            return SERVICE_AMT;
        }

        public void setSERVICE_AMT(String SERVICE_AMT) {
            this.SERVICE_AMT = SERVICE_AMT;
        }

        public String getDEPOSIT_AMT() {
            return DEPOSIT_AMT;
        }

        public void setDEPOSIT_AMT(String DEPOSIT_AMT) {
            this.DEPOSIT_AMT = DEPOSIT_AMT;
        }

        public String getOVERDUE_PROP() {
            return OVERDUE_PROP;
        }

        public void setOVERDUE_PROP(String OVERDUE_PROP) {
            this.OVERDUE_PROP = OVERDUE_PROP;
        }

        public String getPENALTY_PROP() {
            return PENALTY_PROP;
        }

        public void setPENALTY_PROP(String PENALTY_PROP) {
            this.PENALTY_PROP = PENALTY_PROP;
        }

        public String getPREPAY_PROP() {
            return PREPAY_PROP;
        }

        public void setPREPAY_PROP(String PREPAY_PROP) {
            this.PREPAY_PROP = PREPAY_PROP;
        }

        public String getCREDITLINE() {
            return CREDITLINE;
        }

        public void setCREDITLINE(String CREDITLINE) {
            this.CREDITLINE = CREDITLINE;
        }

        public String getCREDITLINE_ABLE() {
            return CREDITLINE_ABLE;
        }

        public void setCREDITLINE_ABLE(String CREDITLINE_ABLE) {
            this.CREDITLINE_ABLE = CREDITLINE_ABLE;
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

        public String getARTICLE_NAME() {
            return ARTICLE_NAME;
        }

        public void setARTICLE_NAME(String ARTICLE_NAME) {
            this.ARTICLE_NAME = ARTICLE_NAME;
        }

        public String getPACKING_QTY() {
            return PACKING_QTY;
        }

        public void setPACKING_QTY(String PACKING_QTY) {
            this.PACKING_QTY = PACKING_QTY;
        }

        public String getBOX_QTY() {
            return BOX_QTY;
        }

        public void setBOX_QTY(String BOX_QTY) {
            this.BOX_QTY = BOX_QTY;
        }

        public String getRET_QTY() {
            return RET_QTY;
        }

        public void setRET_QTY(String RET_QTY) {
            this.RET_QTY = RET_QTY;
        }

        public String getBOXIMPAWN_PRICE() {
            return BOXIMPAWN_PRICE;
        }

        public void setBOXIMPAWN_PRICE(String BOXIMPAWN_PRICE) {
            this.BOXIMPAWN_PRICE = BOXIMPAWN_PRICE;
        }

        public String getIMPAWN_AMT() {
            return IMPAWN_AMT;
        }

        public void setIMPAWN_AMT(String IMPAWN_AMT) {
            this.IMPAWN_AMT = IMPAWN_AMT;
        }
    }
}
