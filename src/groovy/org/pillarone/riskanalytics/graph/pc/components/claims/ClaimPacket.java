package org.pillarone.riskanalytics.graph.pc.components.claims;

import org.pillarone.riskanalytics.core.packets.SingleValuePacket;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
public class ClaimPacket extends SingleValuePacket {

    public ClaimPacket(double value) {
        super(value);
    }

    public double getUltimate() {
        return value;
    }

    public void setUltimate(double ultimate) {
        this.value = ultimate;
    }
}
