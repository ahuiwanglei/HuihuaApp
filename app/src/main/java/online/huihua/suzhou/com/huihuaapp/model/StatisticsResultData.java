package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/4.
 */

public class StatisticsResultData  {

    /**
     * ActionResults : 1
     * ErrorDesc :
     * ActionResultsList : [{"COMPANY_NO":null,"OP_DATE":null,"CONT_NUM":null,"BORROW_AMT":0,"APPROVAL_AMT":0,"REALPAY_AMT":0,"REAL_PRINCIPAL":0,"REAL_INTEREST":0,"PDOVERDUE_INS":0,"PDPENALTY_AMT":0,"PREPAY_CPS":0,"REAL_QTY":0,"BOX_QTY":0,"RET_QTY":0,"OM_AMT":0}]
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
         * COMPANY_NO : null
         * OP_DATE : null
         * CONT_NUM : null
         * BORROW_AMT : 0.0
         * APPROVAL_AMT : 0.0
         * REALPAY_AMT : 0.0
         * REAL_PRINCIPAL : 0.0
         * REAL_INTEREST : 0.0
         * PDOVERDUE_INS : 0.0
         * PDPENALTY_AMT : 0.0
         * PREPAY_CPS : 0.0
         * REAL_QTY : 0.0
         * BOX_QTY : 0.0
         * RET_QTY : 0.0
         * OM_AMT : 0.0
         */

        private String COMPANY_NO;
        private String OP_DATE;
        private String CONT_NUM;
        private String BORROW_AMT;
        private String APPROVAL_AMT;
        private String REALPAY_AMT;
        private String REAL_PRINCIPAL;
        private String REAL_INTEREST;
        private String PDOVERDUE_INS;
        private String PDPENALTY_AMT;
        private String PREPAY_CPS;
        private String REAL_QTY;
        private String BOX_QTY;
        private String RET_QTY;
        private String OM_AMT;

        public String getCOMPANY_NO() {
            return COMPANY_NO;
        }

        public void setCOMPANY_NO(String COMPANY_NO) {
            this.COMPANY_NO = COMPANY_NO;
        }

        public String getOP_DATE() {
            return OP_DATE;
        }

        public void setOP_DATE(String OP_DATE) {
            this.OP_DATE = OP_DATE;
        }

        public String getCONT_NUM() {
            return CONT_NUM;
        }

        public void setCONT_NUM(String CONT_NUM) {
            this.CONT_NUM = CONT_NUM;
        }

        public String getBORROW_AMT() {
            return BORROW_AMT;
        }

        public void setBORROW_AMT(String BORROW_AMT) {
            this.BORROW_AMT = BORROW_AMT;
        }

        public String getAPPROVAL_AMT() {
            return APPROVAL_AMT;
        }

        public void setAPPROVAL_AMT(String APPROVAL_AMT) {
            this.APPROVAL_AMT = APPROVAL_AMT;
        }

        public String getREALPAY_AMT() {
            return REALPAY_AMT;
        }

        public void setREALPAY_AMT(String REALPAY_AMT) {
            this.REALPAY_AMT = REALPAY_AMT;
        }

        public String getREAL_PRINCIPAL() {
            return REAL_PRINCIPAL;
        }

        public void setREAL_PRINCIPAL(String REAL_PRINCIPAL) {
            this.REAL_PRINCIPAL = REAL_PRINCIPAL;
        }

        public String getREAL_INTEREST() {
            return REAL_INTEREST;
        }

        public void setREAL_INTEREST(String REAL_INTEREST) {
            this.REAL_INTEREST = REAL_INTEREST;
        }

        public String getPDOVERDUE_INS() {
            return PDOVERDUE_INS;
        }

        public void setPDOVERDUE_INS(String PDOVERDUE_INS) {
            this.PDOVERDUE_INS = PDOVERDUE_INS;
        }

        public String getPDPENALTY_AMT() {
            return PDPENALTY_AMT;
        }

        public void setPDPENALTY_AMT(String PDPENALTY_AMT) {
            this.PDPENALTY_AMT = PDPENALTY_AMT;
        }

        public String getPREPAY_CPS() {
            return PREPAY_CPS;
        }

        public void setPREPAY_CPS(String PREPAY_CPS) {
            this.PREPAY_CPS = PREPAY_CPS;
        }

        public String getREAL_QTY() {
            return REAL_QTY;
        }

        public void setREAL_QTY(String REAL_QTY) {
            this.REAL_QTY = REAL_QTY;
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

        public String getOM_AMT() {
            return OM_AMT;
        }

        public void setOM_AMT(String OM_AMT) {
            this.OM_AMT = OM_AMT;
        }
    }
}
