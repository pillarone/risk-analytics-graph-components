package org.pillarone.riskanalytics.graph.pc.components.utils

import org.pillarone.riskanalytics.graph.pc.components.claims.ClaimPacket
import org.pillarone.riskanalytics.core.packets.PacketList

/**
 * @author stefan.kunz (at) intuitive-collaboration (dot) com
 */
class PacketUtilsTests extends GroovyTestCase {

    void testSum() {
        PacketList list = new PacketList(ClaimPacket)
        list << new ClaimPacket(2) << new ClaimPacket(4.6)
        assertEquals 'correct sum', 6.6d, PacketUtils.sum(list)
    }

    void testProduct() {
        PacketList list = new PacketList(ClaimPacket)
        list << new ClaimPacket(2) << new ClaimPacket(4.6)
        assertEquals 'correct sum', 9.2d, PacketUtils.product(list)
    }
}
