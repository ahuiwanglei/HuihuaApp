package online.huihua.suzhou.com.huihuaapp.model;

/**
 * Created by wanglei on 2018/3/4.
 */

public class CommonResultData {

    /**
     * ActionResults : 0
     * ErrorDesc : 审核合同失败,请稍后再试!
     * Signature : null
     */

    private int ActionResults;
    private String ErrorDesc;
    private Object Signature;

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
}
