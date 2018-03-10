package online.huihua.suzhou.com.huihuaapp.common;

/**
 * Created by wanglei on 2018/3/5.
 */

public enum ApplyStatusEnum {
//10 新建
//13 审核
//16 作废
//21 审批中
//22 审批通过
//23 审批通过

    NewCreate("10", "新建"),
    ContPass("13","审核"),
    Reviewing("16","作废"),
    ReviewPass("21", "审批中"),
    CheckFinish("22","审批通过"),
    SaveFinish("23", "否决");

    private String value;
    private String name;

    private ApplyStatusEnum(String value, String name){
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static ApplyStatusEnum findKey(String value){
        ApplyStatusEnum[] enums =  ApplyStatusEnum.values();
        for (ApplyStatusEnum e : enums ){
            if(e.getValue().equals(value)){
                return e;
            }
        }
        return NewCreate;
    }
}
