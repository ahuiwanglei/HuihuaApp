package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/4.
 */

public class MainContDetailResultData {

    /**
     * ActionResults : 1
     * ErrorDesc :
     * ActionResultsList : [{"OWNER_NAME":"山西食源丰食品有限公司","MAINCONT_NO":"SHGY-2017-04-002","CREDITLINE":"490000","CREDITLINE_ABLE":"490000","BORROW_RATE":"12.%","SERVICE_PROP":"2.4%","DEPOSIT_PROP":"5.%","OVERDUE_PROP":"0.05%/天","PENALTY_PROP":"10.%","PREPAY_PROP":"5.%","SIGNATORY1":"李秀文","SIGNATORY2":"田艳国","SIGN_DATE":"2017/4/1  ","CHECKUP_NAME":"admin","CHECKUP_DATE":"2017/12/13 15:54:41","STATUS":"合同审批通过"}]
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
         * OWNER_NAME : 山西食源丰食品有限公司
         * MAINCONT_NO : SHGY-2017-04-002
         * CREDITLINE : 490000
         * CREDITLINE_ABLE : 490000
         * BORROW_RATE : 12.%
         * SERVICE_PROP : 2.4%
         * DEPOSIT_PROP : 5.%
         * OVERDUE_PROP : 0.05%/天
         * PENALTY_PROP : 10.%
         * PREPAY_PROP : 5.%
         * SIGNATORY1 : 李秀文
         * SIGNATORY2 : 田艳国
         * SIGN_DATE : 2017/4/1
         * CHECKUP_NAME : admin
         * CHECKUP_DATE : 2017/12/13 15:54:41
         * STATUS : 合同审批通过
         */

        private String OWNER_NAME;
        private String MAINCONT_NO;
        private String CREDITLINE;
        private String CREDITLINE_ABLE;
        private String BORROW_RATE;
        private String SERVICE_PROP;
        private String DEPOSIT_PROP;
        private String OVERDUE_PROP;
        private String PENALTY_PROP;
        private String PREPAY_PROP;
        private String SIGNATORY1;
        private String SIGNATORY2;
        private String SIGN_DATE;
        private String CHECKUP_NAME;
        private String CHECKUP_DATE;
        private String STATUS;
        private String CHECK_MEMO;

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

        public String getMAINCONT_NO() {
            return MAINCONT_NO;
        }

        public void setMAINCONT_NO(String MAINCONT_NO) {
            this.MAINCONT_NO = MAINCONT_NO;
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

        public String getDEPOSIT_PROP() {
            return DEPOSIT_PROP;
        }

        public void setDEPOSIT_PROP(String DEPOSIT_PROP) {
            this.DEPOSIT_PROP = DEPOSIT_PROP;
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

        public String getSIGN_DATE() {
            return SIGN_DATE;
        }

        public void setSIGN_DATE(String SIGN_DATE) {
            this.SIGN_DATE = SIGN_DATE;
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
