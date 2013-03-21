package org.pillarone.riskanalytics.graph.pc.components.frequency;

import org.pillarone.riskanalytics.core.components.Component;
import org.pillarone.riskanalytics.core.packets.PacketList;
import org.pillarone.riskanalytics.graph.pc.components.factors.FactorPacket;
import org.pillarone.riskanalytics.graph.pc.components.utils.PacketUtils;
import umontreal.iro.lecuyer.randvar.RandomVariateGenInt;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
abstract public class AbstractFrequencyGenerator extends Component {
    
    private PacketList<FactorPacket> inFactors = new PacketList<FactorPacket>(FactorPacket.class);
    private PacketList<FrequencyPacket> outFrequency = new PacketList<FrequencyPacket>(FrequencyPacket.class);

    @Override
    protected void doCalculation() {
        double factor = 1;
        if (isReceiverWired(inFactors)) {
            factor = PacketUtils.sum(inFactors);
        }
        outFrequency.add(new FrequencyPacket(getFrequencyGenerator().nextInt() * factor));
    }
    
    abstract RandomVariateGenInt getFrequencyGenerator();

    public PacketList<FactorPacket> getInFactors() {
        return inFactors;
    }

    public void setInFactors(PacketList<FactorPacket> inFactors) {
        this.inFactors = inFactors;
    }

    public PacketList<FrequencyPacket> getOutFrequency() {
        return outFrequency;
    }

    public void setOutFrequency(PacketList<FrequencyPacket> outFrequency) {
        this.outFrequency = outFrequency;
    }
}
