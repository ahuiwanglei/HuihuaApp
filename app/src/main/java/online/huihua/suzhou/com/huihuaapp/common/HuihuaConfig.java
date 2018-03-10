package online.huihua.suzhou.com.huihuaapp.common;

public class HuihuaConfig {

    public static String WY_UPDATE_APK_PATH = "/Xybus/Update/";

    public static String CONFIGNAME = "config_name";
    public static String TOKENKEY = "token";
    public static String EncryptKey = "EncryptKey";
    public static String USERID = "UserId";
    public static String CompanyNo = "CompanyNo";
    public static String Pwd = "Pwd";
    public static String UserName = "UserName";
    public static String ReportAuth = "ReportAuth";

    public static String REMBERPWD = "rember_pwd";
    public static String PASSWORD = "password";

    public static String DefultSecret = "!9.9^2@*L;qP";


    public static interface Http {
        public static final String baseUrl = "http://39.106.124.142:81/API/";

        public static final String login = baseUrl + "Account/Login";

        public static final String GetUserBaseInfo = baseUrl + "Account/GetUserBaseInfo";

        public static final String UpdateAppVersion = "UpdateAppVersion";

        public static final String MainContSelect = baseUrl +"MainCont/Select";

        public static final String MainContDetail = baseUrl + "MainCont/Detail";

        public static final String MainContCheck = baseUrl + "MainCont/Check";

        public static final String ContSelect  = baseUrl + "Cont/Select";
        public static final String ContDetail = baseUrl +"Cont/Detail";
        public static final String ContCheck = baseUrl +"Cont/Check";

        public static final String ExtContSelect  = baseUrl + "EXTCont/Select";
        public static final String ExtContDetail = baseUrl +"EXTCont/Detail";
        public static final String ExtContCheck = baseUrl +"EXTCont/Check";


        //借款
        public static final String ApplySelect = baseUrl + "APPLY/Select";
        public static final String ApplyDetail = baseUrl + "APPLY/Detail";
        public static final String ApplyCheck = baseUrl + "APPLY/Check";
        public static final String ApplyVeto = baseUrl + "APPLY/Veto/";

        //提前还款
        public static final String PrePaySelect = baseUrl + "PREPAY/Select";
        public static final String PrePayDetail = baseUrl + "PREPAY/Detail";
        public static final String PrePayCheck = baseUrl + "PREPAY/Check";
        public static final String PrePayVeto = baseUrl + "PREPAY/Veto/";

        //出货申请
        public static final String ExpmanualSelect = baseUrl + "EXPMANUAL/Select";
        public static final String ExpmanualDetail = baseUrl + "EXPMANUAL/Detail";
        public static final String ExpmanualCheck = baseUrl + "EXPMANUAL/Check";
        public static final String ExpmanualVeto = baseUrl + "EXPMANUAL/Veto/";

        //逾期违约调整
        public static final String OverdueSelect = baseUrl + "OVERDUE/Select";
        public static final String OverdueDetail = baseUrl + "OVERDUE/Detail";
        public static final String OverdueCheck = baseUrl + "OVERDUE/Check";
        public static final String OverdueVeto = baseUrl + "OVERDUE/Veto/";

        //保证金退还
        public static final String DepositSelect = baseUrl + "DEPOSIT/Select";
        public static final String DepositDetail = baseUrl + "DEPOSIT/Detail";
        public static final String DepositCheck = baseUrl + "DEPOSIT/Check";
        public static final String DepositVeto = baseUrl + "DEPOSIT/Veto/";


        public static final String  GetReport = baseUrl + "Account/GetReport";

        public static final String GetOwnerInfo = baseUrl + "Account/GetOwnerInfo";

        //获取员工仓库数据权限 所有参数都非明文
        public static final String userLoc = baseUrl + "AccountRole/GetUserLoc?WorkerNo=%s";

        //获取员工业主数据权限
        public static final String getUserOwner = baseUrl + "AccountRole/GetUserOwner?WorkerNo=%s";

        //获取用户审核权限
        public static final String getUserRole = baseUrl + "AccountRole/GetUserRole?LocNo=%s&WorkerNo=%s";

        //获取员工部门数据权限 所有参数都非明文
        public static final String getUserDept = baseUrl + "AccountRole/GetUserDept?LocNo=%s&OwnerNo=%s&WorkerNo=%s";

        //获取商品信息
        public static final String getGoods = baseUrl + "Goods/GetGoods?LocNo=%s&OwnerNo=%s&Page_No=%s&Page_Size=%s&QueryCondition=%s";

        //获取订单头档信息
        public static final String getOrderMasters = baseUrl + "Orders/GetOrderMasters?LocNo=%s&OwnerNo=%s&Page_No=%s&Page_Size=%s&QueryCondition=%s";

        //退出系统
        public static final String getLogout = baseUrl + "Account/LoginOut";

        //非审核订单取消,提交订单明细数据,提交内容为OrderMasterEntiy实列JSON后的加密字符串
        public static final String cancelOrder = baseUrl + "Orders/CancelOrder";

        //审核订单,提交订单明细数据,提交内容为OrderMasterEntiy实列JSON后的加密字符串 OrderMasterEntiy 说明参考方法
        public static final String auditOrder = baseUrl + "Orders/AuditOrder";

        public static final String getOrderDetail = baseUrl + "Orders/GetOrderDetail?LocNo=%s&OwnerNo=%s&SheetID=%s&Page_No=1&Page_Size=100000";


        //新增订单时获取订单号
        public static final String getOrderId = baseUrl + "Orders/GetOrderID?LocNo=%s&OwnerNo=%s";

        //提交订单明细数据,
        public static final String addOrderDetails = baseUrl +  "Orders/AddOrderDetails";

        //获取业主客户信息
        public static final String getUserCustomer = baseUrl + "AccountRole/GetUserCustomer?OwnerNo=%s&Page_No=%s&Page_Size=%s&QueryCondition=%s";

        //未审核订单列表
        public static final String getOrderMastersUnAduit = baseUrl + "Orders/GetOrderMastersUnAduit?LocNo=%s&OwnerNo=%s&Page_No=%s&Page_Size=%s&QueryCondition=%s";
        //未审核订单详情
        public static final String getOrderDetailUnAduit = baseUrl + "Orders/GetOrderDetailUnAduit?LocNo=%s&OwnerNo=%s&SheetID=%s&Page_No=1&Page_Size=100000";

        public static final int HttpCommonCode = 0;
        public static final int HttpErrorCode = -1;
        public static final int HttpSucessCode = 1;
    }
}
