package com.flightmanagement.flightmanagement.exception;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class BusinessException extends RuntimeException {
    private String code;
    private String message;

    public BusinessException(BaseError error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }
}
