package pms.entity;

public class OwnerModel {
	private Integer code;
	private String msg;
	private Integer count;
	private Owner data;

	public Owner getData() {
		return data;
	}

	public void setData(Owner data) {
		this.data = data;
	}

	public OwnerModel() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
