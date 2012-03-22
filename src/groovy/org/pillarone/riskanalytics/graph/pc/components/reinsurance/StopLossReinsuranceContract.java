package org.pillarone.riskanalytics.graph.pc.components.reinsurance;

import org.pillarone.riskanalytics.core.components.ComponentCategory;
import org.pillarone.riskanalytics.core.packets.PacketList;
import org.pillarone.riskanalytics.graph.pc.components.claims.ClaimPacket;
import org.pillarone.riskanalytics.graph.pc.components.utils.PacketUtils;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Reinsurance"})
public class StopLossReinsuranceContract extends AbstractReinsuranceContract {
    
    private double parmAttachmentPoint = 0d;
    private double parmLimit = 0d;
    
    private double cessionRate = 0d;

    @Override
    void initCessionFactors(PacketList<ClaimPacket> grossClaims) {
        double totalGrossClaim = PacketUtils.sum(grossClaims);
        double totalCededClaim = Math.min(parmLimit, Math.max(totalGrossClaim - parmAttachmentPoint, 0));
        cessionRate = totalCededClaim / totalGrossClaim;
    }

    @Override
    ClaimPacket cededClaim(ClaimPacket grossClaim) {
        return new ClaimPacket(grossClaim.getUltimate() * cessionRate);
    }

    public double getParmAttachmentPoint() {
        return parmAttachmentPoint;
    }

    public void setParmAttachmentPoint(double parmAttachmentPoint) {
        this.parmAttachmentPoint = parmAttachmentPoint;
    }

    public double getParmLimit() {
        return parmLimit;
    }

    public void setParmLimit(double parmLimit) {
        this.parmLimit = parmLimit;
    }
}
