package org.pillarone.riskanalytics.graph.pc.components.claims;

import org.pillarone.riskanalytics.core.components.Component;
import org.pillarone.riskanalytics.core.components.ComponentCategory;
import org.pillarone.riskanalytics.core.packets.PacketList;
import org.pillarone.riskanalytics.core.wiring.WiringValidation;
import org.pillarone.riskanalytics.graph.pc.components.utils.PacketUtils;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Claims"})
public class ClaimsAggregator extends Component {

    @WiringValidation(connections = {1,Integer.MAX_VALUE},packets = {0,Integer.MAX_VALUE})
    private PacketList<ClaimPacket> inClaims = new PacketList<ClaimPacket>(ClaimPacket.class);
    private PacketList<ClaimPacket> outClaims = new PacketList<ClaimPacket>(ClaimPacket.class);
    
    @Override
    protected void doCalculation() {
        outClaims.add(new ClaimPacket(PacketUtils.sum(inClaims)));
    }

    public PacketList<ClaimPacket> getInClaims() {
        return inClaims;
    }

    public void setInClaims(PacketList<ClaimPacket> inClaims) {
        this.inClaims = inClaims;
    }

    public PacketList<ClaimPacket> getOutClaims() {
        return outClaims;
    }

    public void setOutClaims(PacketList<ClaimPacket> outClaims) {
        this.outClaims = outClaims;
    }
}
