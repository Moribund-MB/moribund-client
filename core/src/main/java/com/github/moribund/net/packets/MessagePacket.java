package com.github.moribund.net.packets;

import lombok.Data;

@Data
public class MessagePacket {
    private String name;
    private String message;
}
