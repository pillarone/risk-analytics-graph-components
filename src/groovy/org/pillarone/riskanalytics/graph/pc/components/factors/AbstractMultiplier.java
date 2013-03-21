package org.pillarone.riskanalytics.graph.pc.components.factors;

import org.pillarone.riskanalytics.core.components.Component;
import org.pillarone.riskanalytics.core.packets.PacketList;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
abstract public class AbstractMultiplier extends Component {
    
    private PacketList<FactorPacket> inFactors = new PacketList<FactorPacket>(FactorPacket.class);
    private PacketList<FactorPacket> outFactors = new PacketList<FactorPacket>(FactorPacket.class);
    
    @Override
    protected void doCalculation() {
        if (isReceiverWired(inFactors)) {
            for (FactorPacket factor : inFactors) {
                outFactors.add(new FactorPacket(factor.getFactor() * factor()));
            }
        }
        else {
            outFactors.add(new FactorPacket(factor()));
        }
    }

    abstract protected double factor();

    public PacketList<FactorPacket> getInFactors() {
        return inFactors;
    }

    public void setInFactors(PacketList<FactorPacket> inFactors) {
        this.inFactors = inFactors;
    }

    public PacketList<FactorPacket> getOutFactors() {
        return outFactors;
    }

    public void setOutFactors(PacketList<FactorPacket> outFactors) {
        this.outFactors = outFactors;
    }
}
