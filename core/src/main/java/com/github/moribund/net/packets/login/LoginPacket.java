package com.github.moribund.net.packets.login;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

/**
 * A packet sent by the client that a user is attempting to log in.
 */
@Value
public class LoginPacket implements OutgoingPacket {

    /**
     * The username inputted, lowercased.
     */
    private String username;

    /**
     * The password inputted.
     */
    private String password;
}
