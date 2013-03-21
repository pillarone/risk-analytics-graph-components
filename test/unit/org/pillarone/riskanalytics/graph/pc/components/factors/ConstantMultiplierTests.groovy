package org.pillarone.riskanalytics.graph.pc.components.factors

/**
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
class ConstantMultiplierTests extends GroovyTestCase {

    List<FactorPacket> factors = [new FactorPacket(1.8), new FactorPacket(2.2)]

    void testInChannelNotWired() {
        ConstantMultiplier multiplier = new ConstantMultiplier(parmFactor: 2.4)
        multiplier.inFactors.addAll(factors)
        multiplier.doCalculation()
        assertEquals 'multiplied factors', [2.4], multiplier.outFactors*.value
    }
}
