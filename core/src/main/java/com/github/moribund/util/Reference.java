package com.github.moribund.util;

/**
 * The {@code Reference} class allows for a wrapper that
 * can allow a behavior very similar to a pass-by-reference variable.
 * @param <T> The type of the variable to pass-by-reference.
 */
public class Reference<T> {
    /**
     * The value of the pass-by-reference variable.
     */
    private T variable;

    /**
     * Initializes the {@link Reference#variable} with a value.
     * @param variable The value to initialize with.
     */
    public Reference(T variable) {
        this.variable = variable;
    }

    /**
     * Initializes the {@link Reference#variable} with null.
     */
    public Reference() {
        variable = null;
    }

    /**
     * Get the pass-by-reference value.
     * @return The pass-by-reference value.
     */
    public T getVariable() {
        return variable;
    }

    /**
     * Sets the pass-by-reference value.
     * @param variable The pass-by-reference value to set to.
     */
    public void setVariable(T variable) {
        this.variable = variable;
    }
}
