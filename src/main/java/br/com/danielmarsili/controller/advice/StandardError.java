package br.com.danielmarsili.controller.advice;

import java.io.Serializable;


/**
 * The Class StandardError.
 */
public class StandardError implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The code. */
    private Integer code;

    /** The msg. */
    private String msg;

    /**
     * Instantiates a new standard error.
     *
     * @param code the code
     * @param msg the msg
     */
    public StandardError(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Gets the msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets the msg.
     *
     * @param msg the new msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
