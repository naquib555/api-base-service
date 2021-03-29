package com.qubit.common.enums;

public enum RegistrationType {
    SELF_REG("SELF_REG"),
    ADMIN_REG("ADMIN_REG");

    RegistrationType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
