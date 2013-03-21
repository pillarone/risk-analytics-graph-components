package org.pillarone.riskanalytics.graph.pc.components.claims

/**
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
class ClaimAggregatorTests extends GroovyTestCase {

    void testUsage() {
        ClaimsAggregator aggregator = new ClaimsAggregator()
        aggregator.inClaims.add new ClaimPacket(4.5)
        aggregator.inClaims.add new ClaimPacket(5)
        aggregator.doCalculation()

        assertEquals 'one packet', 1, aggregator.outClaims.size()
        assertEquals 'summed claims', 9.5, aggregator.outClaims[0].value
    }
}
