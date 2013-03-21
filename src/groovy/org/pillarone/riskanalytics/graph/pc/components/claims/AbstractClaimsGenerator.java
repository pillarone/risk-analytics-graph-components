package org.pillarone.riskanalytics.graph.pc.components.claims;

import org.pillarone.riskanalytics.core.components.Component;
import org.pillarone.riskanalytics.core.packets.PacketList;
import org.pillarone.riskanalytics.graph.pc.components.factors.FactorPacket;
import org.pillarone.riskanalytics.graph.pc.components.frequency.FrequencyPacket;
import org.pillarone.riskanalytics.graph.pc.components.utils.PacketUtils;
import umontreal.iro.lecuyer.randvar.RandomVariateGen;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
abstract public class AbstractClaimsGenerator extends Component {

    private PacketList<FactorPacket> inFactors = new PacketList<FactorPacket>(FactorPacket.class);
    private PacketList<FrequencyPacket> inFrequency = new PacketList<FrequencyPacket>(FrequencyPacket.class);
    private PacketList<ClaimPacket> outClaims = new PacketList<ClaimPacket>(ClaimPacket.class);

    @Override
    protected void doCalculation() {
        double factor = 1;
        if (isReceiverWired(inFactors)) {
            factor = PacketUtils.sum(inFactors);
        }
        if (isReceiverWired(inFrequency)) {
            for (int i = 0; i < PacketUtils.sum(inFrequency); i++) {
                outClaims.add(new ClaimPacket(getSeverityGenerator().nextDouble() * factor));
            }
        }
        else {
            outClaims.add(new ClaimPacket(getSeverityGenerator().nextDouble() * factor));
        }
    }

    abstract RandomVariateGen getSeverityGenerator();

    public PacketList<FactorPacket> getInFactors() {
        return inFactors;
    }

    public void setInFactors(PacketList<FactorPacket> inFactors) {
        this.inFactors = inFactors;
    }

    public PacketList<FrequencyPacket> getInFrequency() {
        return inFrequency;
    }

    public void setInFrequency(PacketList<FrequencyPacket> inFrequency) {
        this.inFrequency = inFrequency;
    }

    public PacketList<ClaimPacket> getOutClaims() {
        return outClaims;
    }

    public void setOutClaims(PacketList<ClaimPacket> outClaims) {
        this.outClaims = outClaims;
    }
}
