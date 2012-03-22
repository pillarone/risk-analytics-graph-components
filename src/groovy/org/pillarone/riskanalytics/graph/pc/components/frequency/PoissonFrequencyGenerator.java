package org.pillarone.riskanalytics.graph.pc.components.frequency;

import org.pillarone.riskanalytics.core.components.ComponentCategory;
import org.pillarone.riskanalytics.core.util.MathUtils;
import umontreal.iro.lecuyer.randvar.PoissonGen;
import umontreal.iro.lecuyer.randvar.RandomVariateGenInt;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Generator"})
public class PoissonFrequencyGenerator extends AbstractFrequencyGenerator {

    private double parmMean = 1;

    @Override
    RandomVariateGenInt getFrequencyGenerator() {
        return new PoissonGen(MathUtils.getRandomStreamBase(), parmMean);
    }

    public double getParmMean() {
        return parmMean;
    }

    public void setParmMean(double parmMean) {
        this.parmMean = parmMean;
    }
}
