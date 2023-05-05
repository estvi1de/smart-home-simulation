package cz.cvut.k36.omo.hw.hw04;

import jdk.internal.org.objectweb.asm.tree.ParameterNode;

public class IdleMessage extends Message {
    public IdleMessage(PeerInterface sender) {
        super(sender);
    }

    @Override
    public boolean accept(MessageVisitor visitor) {
        return visitor.visitIdleMessage(this);
    }
}