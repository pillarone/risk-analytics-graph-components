package org.pillarone.riskanalytics.graph.pc.components.reinsurance;

import org.pillarone.riskanalytics.core.components.ComponentCategory;
import org.pillarone.riskanalytics.core.packets.PacketList;
import org.pillarone.riskanalytics.graph.pc.components.claims.ClaimPacket;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Reinsurance"})
public class QuotaShareReinsuranceContract extends AbstractReinsuranceContract {

    private double parmQuota = 0d;

    @Override
    void initCessionFactors(PacketList<ClaimPacket> grossClaims) {
    }

    @Override
    ClaimPacket cededClaim(ClaimPacket grossClaim) {
        return new ClaimPacket(grossClaim.getUltimate() * parmQuota);
    }

    public double getParmQuota() {
        return parmQuota;
    }

    public void setParmQuota(double parmQuota) {
        this.parmQuota = parmQuota;
    }
}
