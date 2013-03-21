package org.pillarone.riskanalytics.graph.pc.components.factors;

import org.pillarone.riskanalytics.core.packets.SingleValuePacket;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
public class FactorPacket extends SingleValuePacket {

    public FactorPacket(double value) {
        super(value);
    }

    public double getFactor() {
        return value;
    }

    public void setFactor(double factor) {
        this.value = factor;
    }
}
