package online.huihua.suzhou.com.huihuaapp.common;

/**
 * Created by wanglei on 2018/3/5.
 */

public enum ContStatusEnum{
//    0 新建
//1 合同审批通过
//2 借款审批中
//3 借款审批通过
//4 质检完成
//5 入库验收完成
//6 放款审批中
//7 正常还款
//8 还款完成
//9 已退保证金
//    X 合同结束
//    Y 根本逾期
//    Z 作废

    NewCreate("0", "新建"),
    ContPass("1","合同审批通过"),
    Reviewing("2","借款审批中"),
    ReviewPass("3", "借款审批通过"),
    CheckFinish("4","质检完成"),
    SaveFinish("5", "入库验收完成"),
    FangKuanReview("6", "放款审批中"),
    Zhengchanghuankuan("7","正常还款"),
    Huankuanwancheng("8","还款完成"),
    YiTuibaozhengjin("9","已退保证金"),
    ContFinish("X", "合同结束"),
    Express("Y", "根本逾期"),
    Delete("Z","作废");

    private String value;
    private String name;

    private ContStatusEnum(String value, String name){
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static ContStatusEnum findKey(String value){
        ContStatusEnum[] enums =  ContStatusEnum.values();
        for (ContStatusEnum e : enums ){
            if(e.getValue().equals(value)){
                return e;
            }
        }
        return NewCreate;
    }
}
