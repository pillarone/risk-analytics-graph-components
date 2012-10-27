package org.pillarone.riskanalytics.graph.pc.components.reinsurance;

import org.pillarone.riskanalytics.core.components.ComponentCategory;
import org.pillarone.riskanalytics.core.packets.PacketList;
import org.pillarone.riskanalytics.graph.pc.components.claims.ClaimPacket;
import org.pillarone.riskanalytics.graph.pc.components.utils.PacketUtils;

/**
 * One layer only, no reinstatments
 *
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Reinsurance"})
public class XLReinsuranceContract extends AbstractReinsuranceContract {

    private PacketList<LayerProbabilitiesPacket> outLayerProbabilities = new PacketList<LayerProbabilitiesPacket>(LayerProbabilitiesPacket.class);

    private double parmRetention = 0d;
    private double parmLimit = 0d;
    private double availableLimit = 0d;

    @Override
    protected void doCalculation() {
        availableLimit = parmLimit;
        super.doCalculation();
        if (isSenderWired(outLayerProbabilities)) {
            double totalCededClaim = PacketUtils.sum(getOutCededClaims());
            int layerEntryProbability = totalCededClaim > 0 ? 100 : 0;
            int layerExitProbability = totalCededClaim == parmLimit ? 100 : 0;
            outLayerProbabilities.add(new LayerProbabilitiesPacket(layerEntryProbability, layerExitProbability));
        }
    }

    @Override
    void initCessionFactors(PacketList<ClaimPacket> grossClaims) {
    }

    @Override
    ClaimPacket cededClaim(ClaimPacket grossClaim) {
        double cededValue = Math.min(availableLimit, Math.max(grossClaim.getUltimate() - parmRetention, 0));
        availableLimit = Math.max(0, availableLimit - cededValue);
        return new ClaimPacket(cededValue);
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

    public PacketList<LayerProbabilitiesPacket> getOutLayerProbabilities() {
        return outLayerProbabilities;
    }

    public void setOutLayerProbabilities(PacketList<LayerProbabilitiesPacket> outLayerProbabilities) {
        this.outLayerProbabilities = outLayerProbabilities;
    }
}
