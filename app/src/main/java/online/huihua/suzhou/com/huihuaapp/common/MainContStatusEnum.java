package online.huihua.suzhou.com.huihuaapp.common;

/**
 * Created by wanglei on 2018/3/5.
 */

public enum MainContStatusEnum {
    NewCreate("0", "新建"),
    ReviewPass("1","合同审批通过"),
    ContFinish("X", "合同结束"),
    Express("Y", "根本逾期"),
    Delete("Z","作废");

    private String value;
    private String name;

    private MainContStatusEnum(String value, String name){
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static MainContStatusEnum findKey(String value){
        MainContStatusEnum[] enums =  MainContStatusEnum.values();
        for (MainContStatusEnum e : enums ){
            if(e.getValue().equals(value)){
                return e;
            }
        }
        return NewCreate;
    }


}
