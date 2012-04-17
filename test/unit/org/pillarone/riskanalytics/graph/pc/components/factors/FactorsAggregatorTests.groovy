package org.pillarone.riskanalytics.graph.pc.components.factors

/**
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
class FactorsAggregatorTests extends GroovyTestCase{

    List<FactorPacket> factors = [new FactorPacket(1.8), new FactorPacket(2.2)]

    void testMultiplyFactors() {
        FactorsAggregator aggregator = new FactorsAggregator(parmMode : AggregationMode.MULTIPLY)
        aggregator.inFactors.addAll(factors)
        aggregator.doCalculation()
        assertEquals 'non trivial product', 1.8d * 2.2d, aggregator.outFactors[0].value
    }

    void testSumFactors() {
        FactorsAggregator aggregator = new FactorsAggregator(parmMode : AggregationMode.SUM)
        aggregator.inFactors.addAll(factors)
        aggregator.doCalculation()
        assertEquals 'non trivial sum', 4d, aggregator.outFactors[0].value
    }
}
