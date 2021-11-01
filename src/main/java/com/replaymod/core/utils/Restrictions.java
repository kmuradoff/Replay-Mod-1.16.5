package com.replaymod.core.utils;

import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SCustomPayloadPlayPacket;
import net.minecraft.util.ResourceLocation;


/**
 * Restrictions set by the server,
 *
 * @see <a href="https://gist.github.com/Johni0702/2547c463e51f65f312cb">Replay Restrictions Gist</a>
 */
public class Restrictions {
    public static final ResourceLocation PLUGIN_CHANNEL = new ResourceLocation("replaymod", "restrict");
    private boolean noXray;
    private boolean noNoclip;
    private boolean onlyFirstPerson;
    private boolean onlyRecordingPlayer;

    public String handle(SCustomPayloadPlayPacket packet) {
        PacketBuffer buffer = packet.getBufferData();
        while (buffer.isReadable()) {
            String name = buffer.readString(64);
            boolean active = buffer.readBoolean();
//            if ("no_xray".equals(name)) {
//                noXray = active;
//            } else if ("no_noclip".equals(name)) {
//                noNoclip = active;
//            } else if ("only_first_person".equals(name)) {
//                onlyFirstPerson = active;
//            } else if ("only_recording_player".equals(name)) {
//                onlyRecordingPlayer = active;
//            } else {
            return name;
//            }
        }
        return null;
    }

    public boolean isNoXray() {
        return noXray;
    }

    public boolean isNoNoclip() {
        return noNoclip;
    }

    public boolean isOnlyFirstPerson() {
        return onlyFirstPerson;
    }

    public boolean isOnlyRecordingPlayer() {
        return onlyRecordingPlayer;
    }
}
