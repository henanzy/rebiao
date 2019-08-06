package com.hnzy.datasource;

/**
 * @ClassName: DataSourceType 
 * @Description:数据库类型常量类
 * @author: libiao
 * @date: 2015-12-14 下午5:57:01
 */
public class DataSourceType {
	// 192.168.10.72:3307/100msh_admin
	public static final String dse = "dse";
	// 192.168.10.72:3308/100msh_partner
	public static final String ds = "ds";
	//用ThreadLocal来设置当前线程使用哪个dataSource
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }
    public static String getCustomerType() {
        String dataSource = contextHolder.get();
        if (dataSource!=null&&dataSource!="") {
            return dse;
        }else {
            return dataSource;
        }
    }
    public static void clearCustomerType() {
        contextHolder.remove();
    }
}
