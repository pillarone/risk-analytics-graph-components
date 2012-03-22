package org.pillarone.riskanalytics.graph.pc.components.frequency;

import org.pillarone.riskanalytics.core.components.ComponentCategory;
import org.pillarone.riskanalytics.core.util.MathUtils;
import umontreal.iro.lecuyer.randvar.NegativeBinomialGen;
import umontreal.iro.lecuyer.randvar.RandomVariateGenInt;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Generator"})
public class NegativeBinomialFrequencyGenerator extends AbstractFrequencyGenerator {

    private double parmGamma = 0.5;
    private double parmP = 0.5;

    @Override
    RandomVariateGenInt getFrequencyGenerator() {
        return new NegativeBinomialGen(MathUtils.getRandomStreamBase(), parmGamma, parmP);
    }

    public double getParmGamma() {
        return parmGamma;
    }

    public void setParmGamma(double parmGamma) {
        this.parmGamma = parmGamma;
    }

    public double getParmP() {
        return parmP;
    }

    public void setParmP(double parmP) {
        this.parmP = parmP;
    }
}
