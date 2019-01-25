package com.github.moribund.net.packets.login;

/**
 * The different types of responses to the {@link LoginPacket}, handled in the {@link LoginResponsePacket}.
 */
public enum LoginResponse {
    SUCCESS, INCORRECT_PASSWORD, NEW_ACCOUNT, ALREADY_LOGGED_IN
}
