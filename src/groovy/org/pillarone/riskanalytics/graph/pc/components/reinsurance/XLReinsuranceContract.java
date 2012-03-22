package org.pillarone.riskanalytics.graph.pc.components.reinsurance;

import org.pillarone.riskanalytics.core.components.ComponentCategory;
import org.pillarone.riskanalytics.core.packets.PacketList;
import org.pillarone.riskanalytics.graph.pc.components.claims.ClaimPacket;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Reinsurance"})
public class XLReinsuranceContract extends AbstractReinsuranceContract {

    private double parmRetention = 0d;
    private double parmLimit = 0d;

    @Override
    void initCessionFactors(PacketList<ClaimPacket> grossClaims) {
    }

    @Override
    ClaimPacket cededClaim(ClaimPacket grossClaim) {
        return new ClaimPacket(Math.min(parmLimit, Math.max(grossClaim.getUltimate() - parmRetention, 0)));
    }

    public double getParmRetention() {
        return parmRetention;
    }

    public void setParmRetention(double parmRetention) {
        this.parmRetention = parmRetention;
    }

    public double getParmLimit() {
        return parmLimit;
    }

    public void setParmLimit(double parmLimit) {
        this.parmLimit = parmLimit;
    }
}
