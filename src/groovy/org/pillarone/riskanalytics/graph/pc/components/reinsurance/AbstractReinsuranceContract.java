package org.pillarone.riskanalytics.graph.pc.components.reinsurance;

import org.pillarone.riskanalytics.core.components.Component;
import org.pillarone.riskanalytics.core.packets.PacketList;
import org.pillarone.riskanalytics.core.wiring.WiringValidation;
import org.pillarone.riskanalytics.graph.pc.components.claims.ClaimPacket;

import java.util.List;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
abstract public class AbstractReinsuranceContract extends Component {

    @WiringValidation(connections = {1,Integer.MAX_VALUE},packets = {0,Integer.MAX_VALUE})
    private PacketList<ClaimPacket> inGrossClaims = new PacketList<ClaimPacket>(ClaimPacket.class);
    private PacketList<ClaimPacket> outCededClaims = new PacketList<ClaimPacket>(ClaimPacket.class);
    private PacketList<ClaimPacket> outRetainedClaims = new PacketList<ClaimPacket>(ClaimPacket.class);
    
    @Override
    protected void doCalculation() {
        initCessionFactors(inGrossClaims);
        for (ClaimPacket grossClaim : inGrossClaims) {
            ClaimPacket cededClaim = cededClaim(grossClaim);
            outCededClaims.add(cededClaim);
            outRetainedClaims.add(new ClaimPacket(grossClaim.getUltimate() - cededClaim.getUltimate()));
        }
    }

    abstract void initCessionFactors(PacketList<ClaimPacket> grossClaims);

    abstract ClaimPacket cededClaim(ClaimPacket grossClaim);

    public PacketList<ClaimPacket> getInGrossClaims() {
        return inGrossClaims;
    }

    public void setInGrossClaims(PacketList<ClaimPacket> inGrossClaims) {
        this.inGrossClaims = inGrossClaims;
    }

    public PacketList<ClaimPacket> getOutCededClaims() {
        return outCededClaims;
    }

    public void setOutCededClaims(PacketList<ClaimPacket> outCededClaims) {
        this.outCededClaims = outCededClaims;
    }

    public PacketList<ClaimPacket> getOutRetainedClaims() {
        return outRetainedClaims;
    }

    public void setOutRetainedClaims(PacketList<ClaimPacket> outRetainedClaims) {
        this.outRetainedClaims = outRetainedClaims;
    }
}
