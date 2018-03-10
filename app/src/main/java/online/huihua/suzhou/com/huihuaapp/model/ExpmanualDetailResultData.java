package online.huihua.suzhou.com.huihuaapp.model;

import java.util.List;

/**
 * Created by wanglei on 2018/3/6.
 */

public class ExpmanualDetailResultData {

    /**
     * ActionResults : 1
     * ErrorDesc : 
     * ActionResultsList : [{"SHEET_ID":"180307001","LOCNO":"1000","SHEET_DATE":"2018-03-07","OWNER_NAME":"app测试3","MAINCONT_NO":"TEST2018-03-003","REQUEST_DATE":"2018-03-07","CUSTOMER_NAME":null,"ALLOW_AMT":"16665","OM_AMT":"1500","CHECK_STATUS":"1审批中,admin审批中,","CHECK_MEMO":null,"STATUS":"21","ARTICLE_NAME":"007-001测试商品1","PACKING_QTY":"10","BOX_QTY":"10","RET_QTY":"0","IMPAWN_PRICE":"10","ARTICLE_AMT":"1000"},{"SHEET_ID":"180307001","LOCNO":"1000","SHEET_DATE":"2018-03-07","OWNER_NAME":"app测试3","MAINCONT_NO":"TEST2018-03-003","REQUEST_DATE":"2018-03-07","CUSTOMER_NAME":null,"ALLOW_AMT":"16665","OM_AMT":"1500","CHECK_STATUS":"1审批中,admin审批中,","CHECK_MEMO":null,"STATUS":"21","ARTICLE_NAME":"007-002测试商品2","PACKING_QTY":"10","BOX_QTY":"10","RET_QTY":"0","IMPAWN_PRICE":"5","ARTICLE_AMT":"500"}]
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
         * SHEET_ID : 180307001
         * LOCNO : 1000
         * SHEET_DATE : 2018-03-07
         * OWNER_NAME : app测试3
         * MAINCONT_NO : TEST2018-03-003
         * REQUEST_DATE : 2018-03-07
         * CUSTOMER_NAME : null
         * ALLOW_AMT : 16665
         * OM_AMT : 1500
         * CHECK_STATUS : 1审批中,admin审批中,
         * CHECK_MEMO : null
         * STATUS : 21
         * ARTICLE_NAME : 007-001测试商品1
         * PACKING_QTY : 10
         * BOX_QTY : 10
         * RET_QTY : 0
         * IMPAWN_PRICE : 10
         * ARTICLE_AMT : 1000
         */

        private String SHEET_ID;
        private String LOCNO;
        private String SHEET_DATE;
        private String OWNER_NAME;
        private String MAINCONT_NO;
        private String REQUEST_DATE;
        private String CUSTOMER_NAME;
        private String ALLOW_AMT;
        private String OM_AMT;
        private String CHECK_STATUS;
        private String CHECK_MEMO;
        private String STATUS;
        private String ARTICLE_NAME;
        private String PACKING_QTY;
        private String BOX_QTY;
        private String RET_QTY;
        private String IMPAWN_PRICE;
        private String ARTICLE_AMT;

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

        public String getREQUEST_DATE() {
            return REQUEST_DATE;
        }

        public void setREQUEST_DATE(String REQUEST_DATE) {
            this.REQUEST_DATE = REQUEST_DATE;
        }

        public String getCUSTOMER_NAME() {
            return CUSTOMER_NAME;
        }

        public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
            this.CUSTOMER_NAME = CUSTOMER_NAME;
        }

        public String getALLOW_AMT() {
            return ALLOW_AMT;
        }

        public void setALLOW_AMT(String ALLOW_AMT) {
            this.ALLOW_AMT = ALLOW_AMT;
        }

        public String getOM_AMT() {
            return OM_AMT;
        }

        public void setOM_AMT(String OM_AMT) {
            this.OM_AMT = OM_AMT;
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

        public String getIMPAWN_PRICE() {
            return IMPAWN_PRICE;
        }

        public void setIMPAWN_PRICE(String IMPAWN_PRICE) {
            this.IMPAWN_PRICE = IMPAWN_PRICE;
        }

        public String getARTICLE_AMT() {
            return ARTICLE_AMT;
        }

        public void setARTICLE_AMT(String ARTICLE_AMT) {
            this.ARTICLE_AMT = ARTICLE_AMT;
        }
    }
}
