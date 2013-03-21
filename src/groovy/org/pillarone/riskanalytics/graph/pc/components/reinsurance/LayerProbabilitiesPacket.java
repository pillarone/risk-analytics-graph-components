package org.pillarone.riskanalytics.graph.pc.components.reinsurance;

import org.pillarone.riskanalytics.core.packets.MultiValuePacket;

/**
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
public class LayerProbabilitiesPacket extends MultiValuePacket {

    private int layerEntryProbability;
    private int layerExitProbability;

    public LayerProbabilitiesPacket() {
    }

    public LayerProbabilitiesPacket(int layerEntryProbability, int layerExitProbability) {
        this.layerEntryProbability = layerEntryProbability;
        this.layerExitProbability = layerExitProbability;
    }

    public int getLayerEntryProbability() {
        return layerEntryProbability;
    }

    public void setLayerEntryProbability(int layerEntryProbability) {
        this.layerEntryProbability = layerEntryProbability;
    }

    public int getLayerExitProbability() {
        return layerExitProbability;
    }

    public void setLayerExitProbability(int layerExitProbability) {
        this.layerExitProbability = layerExitProbability;
    }
}
