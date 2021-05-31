package com.timing.feedback.Exception;

import com.timing.feedback.vo.CustomizeResultCode;
import lombok.Data;

/**
 * @author cwh
 */
@Data
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 */
	protected String errorCode;
	/**
	 * 错误信息
	 */
	protected String errorMsg;

	public BizException() {
		super();
	}

	public BizException(CustomizeResultCode errorInfoInterface) {
		super(errorInfoInterface.getCode());
		this.errorCode = errorInfoInterface.getCode();
		this.errorMsg = errorInfoInterface.getMessage();
	}
	
	public BizException(CustomizeResultCode errorInfoInterface, Throwable cause) {
		super(errorInfoInterface.getCode(), cause);
		this.errorCode = errorInfoInterface.getCode();
		this.errorMsg = errorInfoInterface.getMessage();
	}
	
	public BizException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}
	
	public BizException(String errorCode, String errorMsg) {
		super(errorCode);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public BizException(String errorCode, String errorMsg, Throwable cause) {
		super(errorCode, cause);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	

	@Override
	public String getMessage() {
		return errorMsg;
	}

	@Override
	public Throwable fillInStackTrace() {
		return this;
	}

}
