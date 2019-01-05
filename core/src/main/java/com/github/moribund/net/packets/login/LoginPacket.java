package com.github.moribund.net.packets.login;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

@Value
public class LoginPacket implements OutgoingPacket {
    private String username;
    private String password;
}
