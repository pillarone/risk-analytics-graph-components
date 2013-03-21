package org.pillarone.riskanalytics.graph.pc.components.frequency;

import org.pillarone.riskanalytics.core.packets.SingleValuePacket;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
public class FrequencyPacket extends SingleValuePacket {

    public FrequencyPacket() {
    }

    public FrequencyPacket(double value) {
        super(value);
    }

    public double getFrequency() {
        return value;
    }

    public void setFrequency(int frequency) {
        this.value = frequency;
    }
}
