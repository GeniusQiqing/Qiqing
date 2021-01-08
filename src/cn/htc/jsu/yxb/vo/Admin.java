package cn.htc.jsu.yxb.vo;
/**
 * 登录注册用户实体类
 */
public class Admin {
	public String id;                 //编号
	public String password;      //密码
	public void setID(String id) {
	    this.id=id;
	}
	public void setPassword(String password) {
	    this.password=password;
	}
	
	public String getID() {
	    return this.id;
	}
	public String getPassword() {
	    return this.password;
	}
}
