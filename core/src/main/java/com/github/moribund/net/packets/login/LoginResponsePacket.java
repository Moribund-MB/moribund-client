package com.github.moribund.net.packets.login;

import com.github.moribund.net.packets.IncomingPacket;

public final class LoginResponsePacket implements IncomingPacket {
    private LoginResponse loginResponse;

    private LoginResponsePacket() { }

    @Override
    public void process() {
        switch (loginResponse) {
            case SUCCESS:
                System.out.println("Success!");
                break;
            case INCORRECT_CREDENTIALS:
                System.out.println("Incorrect!");
                break;
            case NEW_ACCOUNT:
                System.out.println("Make new account!");
                break;
        }
    }
}
