package com.supermarket.app.dto;

import java.io.Serializable;

/**
 * Generic class for API responses
 * 
 * @author egiraldo
 *
 */
public class ResultDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Defines whether the operation was succeeded or not
	 */
	private boolean success = false;
	/**
	 * Defines the message response
	 */
	private String msg = "";
	/**
	 * The Object returned for associated request
	 */
	private Object data = null;
	/**
	 * The total number of object returned
	 */
	private long total = 0;
	
	public ResultDTO() {
	}

	public ResultDTO(boolean success, String msg, Object data, long totalCount) {
		this.success = success;
		this.msg = msg;
		this.data = data;
		this.total = totalCount;
	}

	public ResultDTO(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
