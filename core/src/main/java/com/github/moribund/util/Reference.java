package com.github.moribund.util;

public class Reference<T> {
    private T variable;

    public Reference(T variable) {
        this.variable = variable;
    }

    public Reference() {
        variable = null;
    }

    public T getVariable() {
        return variable;
    }

    public void setVariable(T variable) {
        this.variable = variable;
    }
}
