package org.pillarone.riskanalytics.graph.pc.components.factors;

import org.pillarone.riskanalytics.core.components.Component;
import org.pillarone.riskanalytics.core.components.ComponentCategory;
import org.pillarone.riskanalytics.core.packets.PacketList;
import org.pillarone.riskanalytics.core.wiring.WiringValidation;
import org.pillarone.riskanalytics.graph.pc.components.utils.PacketUtils;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Factor","Aggregator"})
public class FactorsAggregator extends Component {

    @WiringValidation(connections = {1,Integer.MAX_VALUE},packets = {0,Integer.MAX_VALUE})
    private PacketList<FactorPacket> inFactors = new PacketList<FactorPacket>(FactorPacket.class);
    private PacketList<FactorPacket> outFactors = new PacketList<FactorPacket>(FactorPacket.class);
    
    private AggregationMode parmMode = AggregationMode.MULTIPLY;
    
    @Override
    protected void doCalculation() {
        if (parmMode.equals(AggregationMode.MULTIPLY)) {
            outFactors.add(new FactorPacket(PacketUtils.product(inFactors)));
        }
        else {
            outFactors.add(new FactorPacket(PacketUtils.sum(inFactors)));
        }
    }

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

    public AggregationMode getParmMode() {
        return parmMode;
    }

    public void setParmMode(AggregationMode parmMode) {
        this.parmMode = parmMode;
    }
}
