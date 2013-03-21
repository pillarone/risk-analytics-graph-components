package org.pillarone.riskanalytics.graph.pc.components.factors;

import org.pillarone.riskanalytics.core.components.ComponentCategory;
import org.pillarone.riskanalytics.core.util.MathUtils;
import umontreal.iro.lecuyer.randvar.NormalGen;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Factor"})
public class GaussMultiplier extends AbstractMultiplier {

    private double parmMean = 1d;
    private double parmStdev = 1d;

    private NormalGen generator = new NormalGen(MathUtils.getRandomStreamBase(), parmMean, parmStdev);

    protected double factor() {
        return generator.nextDouble();
    }

    public double getParmMean() {
        return parmMean;
    }

    public void setParmMean(double parmMean) {
        this.parmMean = parmMean;
    }

    public double getParmStdev() {
        return parmStdev;
    }

    public void setParmStdev(double parmStdev) {
        this.parmStdev = parmStdev;
    }
}
