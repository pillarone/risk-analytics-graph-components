package org.pillarone.riskanalytics.graph.pc.components.claims;

import org.pillarone.riskanalytics.core.components.ComponentCategory;
import org.pillarone.riskanalytics.core.util.MathUtils;
import umontreal.iro.lecuyer.randvar.ParetoGen;
import umontreal.iro.lecuyer.randvar.RandomVariateGen;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Claims","Generator"})
public class ParetoClaimsGenerator extends AbstractClaimsGenerator {

    private double parmAlpha = 2d;
    private double parmBeta = 1000d;

    @Override
    RandomVariateGen getSeverityGenerator() {
        return new ParetoGen(MathUtils.getRandomStreamBase(), parmAlpha, parmBeta);
    }

    public double getParmAlpha() {
        return parmAlpha;
    }

    public void setParmAlpha(double parmAlpha) {
        this.parmAlpha = parmAlpha;
    }

    public double getParmBeta() {
        return parmBeta;
    }

    public void setParmBeta(double parmBeta) {
        this.parmBeta = parmBeta;
    }
}
