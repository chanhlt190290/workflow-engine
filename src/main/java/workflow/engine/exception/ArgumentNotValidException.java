/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author trungchanh
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ArgumentNotValidException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String fieldName;

    public ArgumentNotValidException(String fieldName) {
        super(String.format("`%s` has a invalid value!", fieldName));
        this.fieldName = fieldName;
    }

    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @param fieldName the fieldName to set
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

}
