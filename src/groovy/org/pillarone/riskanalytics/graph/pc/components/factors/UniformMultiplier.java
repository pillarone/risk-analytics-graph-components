package org.pillarone.riskanalytics.graph.pc.components.factors;

import org.pillarone.riskanalytics.core.components.ComponentCategory;
import org.pillarone.riskanalytics.core.util.MathUtils;
import umontreal.iro.lecuyer.randvar.UniformGen;

/**
 * @author martin.melchior (at) fhnw (dot) ch
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
@ComponentCategory(categories={"Factor"})
public class UniformMultiplier extends AbstractMultiplier {

    private double parmA = 0d;
    private double parmB = 0d;

    private UniformGen generator = new UniformGen(MathUtils.getRandomStreamBase(), parmA, parmB);

    protected double factor() {
        return generator.nextDouble();
    }

    public double getParmA() {
        return parmA;
    }

    public void setParmA(double parmA) {
        this.parmA = parmA;
    }

    public double getParmB() {
        return parmB;
    }

    public void setParmB(double parmB) {
        this.parmB = parmB;
    }
}
