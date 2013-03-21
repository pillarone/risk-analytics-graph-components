package org.pillarone.riskanalytics.graph.pc.components.factors;

import org.pillarone.riskanalytics.core.components.ComponentCategory;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Factor"})
public class ConstantMultiplier extends AbstractMultiplier {

    private double parmFactor = 1d;

    protected double factor() {
        return parmFactor;
    }

    public double getParmFactor() {
        return parmFactor;
    }

    public void setParmFactor(double parmFactor) {
        this.parmFactor = parmFactor;
    }
}
