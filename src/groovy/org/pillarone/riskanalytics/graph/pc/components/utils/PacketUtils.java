package org.pillarone.riskanalytics.graph.pc.components.utils;

import org.pillarone.riskanalytics.core.packets.PacketList;
import org.pillarone.riskanalytics.core.packets.SingleValuePacket;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
public class PacketUtils {

    public static double sum(PacketList<? extends SingleValuePacket> values) {
        double summedValues = 0;
        for (SingleValuePacket value : values) {
            summedValues += value.getValue();
        }
        return summedValues;
    }

    public static double product(PacketList<? extends SingleValuePacket> values) {
        double product = 1;
        for (SingleValuePacket value : values) {
            product *= value.getValue();
        }
        return product;
    }
}
