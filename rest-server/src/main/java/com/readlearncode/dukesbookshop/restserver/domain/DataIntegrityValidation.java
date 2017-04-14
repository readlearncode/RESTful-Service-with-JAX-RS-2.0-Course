package com.readlearncode.dukesbookshop.restserver.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public class DataIntegrityValidation {

    private  Map<String, String> errorResponse = new HashMap<>();

    public DataIntegrityValidation(Map<String, String> errorResponse) {
        this.errorResponse = errorResponse;
    }

    public Map<String, String> getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(Map<String, String> errorResponse) {
        this.errorResponse = errorResponse;
    }
}