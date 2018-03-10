package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/4.
 */

public class ContDetailResultData {


    /**
     * ActionResults : 1
     * ErrorDesc :
     * ActionResultsList : [{"OWNER_NAME":"测试业主1","INDUSTRY_NAME":null,"CONT_NO":"sh002-004","BORROW_PERIOD":"6","BORROW_AMT":"10000","BORROW_RATE":"0.05%","SERVICE_PROP":"0.05%","SERVICE_AMT":null,"DEPOSIT_PROP":"0.05%","DEPOSIT_AMT":null,"OVERDUE_PROP":"0.05%/天","PENALTY_PROP":"0.05%","BEGIN_DATE":"2017-12-28","END_DATE":"2017-12-28","SIGNATORY1":"zhangsan","SIGNATORY2":"XXXX","CHECKUP_NAME":"admin","CHECKUP_DATE":"2017/12/28 9:58:42","STATUS":"7"}]
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
         * OWNER_NAME : 测试业主1
         * INDUSTRY_NAME : null
         * CONT_NO : sh002-004
         * BORROW_PERIOD : 6
         * BORROW_AMT : 10000
         * BORROW_RATE : 0.05%
         * SERVICE_PROP : 0.05%
         * SERVICE_AMT : null
         * DEPOSIT_PROP : 0.05%
         * DEPOSIT_AMT : null
         * OVERDUE_PROP : 0.05%/天
         * PENALTY_PROP : 0.05%
         * BEGIN_DATE : 2017-12-28
         * END_DATE : 2017-12-28
         * SIGNATORY1 : zhangsan
         * SIGNATORY2 : XXXX
         * CHECKUP_NAME : admin
         * CHECKUP_DATE : 2017/12/28 9:58:42
         * STATUS : 7
         */

        private String OWNER_NAME;
        private String INDUSTRY_NAME;
        private String CONT_NO;
        private String BORROW_PERIOD;
        private String BORROW_AMT;
        private String BORROW_RATE;
        private String SERVICE_PROP;
        private String SERVICE_AMT;
        private String DEPOSIT_PROP;
        private String DEPOSIT_AMT;
        private String OVERDUE_PROP;
        private String PENALTY_PROP;
        private String BEGIN_DATE;
        private String END_DATE;
        private String SIGNATORY1;
        private String SIGNATORY2;
        private String CHECKUP_NAME;
        private String CHECKUP_DATE;
        private String STATUS;
        private String CHECK_MEMO;
        private String PERIOD;
        private String REPAY_DATE;
        private String PRINCIPAL;
        private String REALPAY_DATE;
        private String REALPAY_AMT;
        private String REALPREPAY_CPS;

        public String getPERIOD() {
            return PERIOD;
        }

        public void setPERIOD(String PERIOD) {
            this.PERIOD = PERIOD;
        }

        public String getREPAY_DATE() {
            return REPAY_DATE;
        }

        public void setREPAY_DATE(String REPAY_DATE) {
            this.REPAY_DATE = REPAY_DATE;
        }

        public String getPRINCIPAL() {
            return PRINCIPAL;
        }

        public void setPRINCIPAL(String PRINCIPAL) {
            this.PRINCIPAL = PRINCIPAL;
        }

        public String getREALPAY_DATE() {
            return REALPAY_DATE;
        }

        public void setREALPAY_DATE(String REALPAY_DATE) {
            this.REALPAY_DATE = REALPAY_DATE;
        }

        public String getREALPAY_AMT() {
            return REALPAY_AMT;
        }

        public void setREALPAY_AMT(String REALPAY_AMT) {
            this.REALPAY_AMT = REALPAY_AMT;
        }

        public String getREALPREPAY_CPS() {
            return REALPREPAY_CPS;
        }

        public void setREALPREPAY_CPS(String REALPREPAY_CPS) {
            this.REALPREPAY_CPS = REALPREPAY_CPS;
        }

        public String getCHECK_MEMO() {
            return CHECK_MEMO;
        }

        public void setCHECK_MEMO(String CHECK_MEMO) {
            this.CHECK_MEMO = CHECK_MEMO;
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

        public String getBORROW_RATE() {
            return BORROW_RATE;
        }

        public void setBORROW_RATE(String BORROW_RATE) {
            this.BORROW_RATE = BORROW_RATE;
        }

        public String getSERVICE_PROP() {
            return SERVICE_PROP;
        }

        public void setSERVICE_PROP(String SERVICE_PROP) {
            this.SERVICE_PROP = SERVICE_PROP;
        }

        public Object getSERVICE_AMT() {
            return SERVICE_AMT;
        }

        public void setSERVICE_AMT(String SERVICE_AMT) {
            this.SERVICE_AMT = SERVICE_AMT;
        }

        public String getDEPOSIT_PROP() {
            return DEPOSIT_PROP;
        }

        public void setDEPOSIT_PROP(String DEPOSIT_PROP) {
            this.DEPOSIT_PROP = DEPOSIT_PROP;
        }

        public Object getDEPOSIT_AMT() {
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

        public String getBEGIN_DATE() {
            return BEGIN_DATE;
        }

        public void setBEGIN_DATE(String BEGIN_DATE) {
            this.BEGIN_DATE = BEGIN_DATE;
        }

        public String getEND_DATE() {
            return END_DATE;
        }

        public void setEND_DATE(String END_DATE) {
            this.END_DATE = END_DATE;
        }

        public String getSIGNATORY1() {
            return SIGNATORY1;
        }

        public void setSIGNATORY1(String SIGNATORY1) {
            this.SIGNATORY1 = SIGNATORY1;
        }

        public String getSIGNATORY2() {
            return SIGNATORY2;
        }

        public void setSIGNATORY2(String SIGNATORY2) {
            this.SIGNATORY2 = SIGNATORY2;
        }

        public String getCHECKUP_NAME() {
            return CHECKUP_NAME;
        }

        public void setCHECKUP_NAME(String CHECKUP_NAME) {
            this.CHECKUP_NAME = CHECKUP_NAME;
        }

        public String getCHECKUP_DATE() {
            return CHECKUP_DATE;
        }

        public void setCHECKUP_DATE(String CHECKUP_DATE) {
            this.CHECKUP_DATE = CHECKUP_DATE;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }
    }
}
