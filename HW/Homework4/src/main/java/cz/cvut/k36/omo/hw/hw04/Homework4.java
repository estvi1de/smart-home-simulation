package cz.cvut.k36.omo.hw.hw04;

import java.util.Map;

public class Homework4 extends MessageVisitor {
    public Homework4(Peer peer) {
        super(peer);
    }

    @Override
    public boolean visitHaveMessage(HaveMessage message) {
        boolean[] ArrOfBlocks = peer.peers2BlocksMap.get(message.getSender());
        ArrOfBlocks[message.getBlockIndex()] = true;
        peer.peers2BlocksMap.put(message.getSender(), ArrOfBlocks);
        return false;
    }

    @Override
    public boolean visitRequestMessage(RequestMessage message) {
        if (this.peer.data[message.getBlockIndex()] != null) {
            message.getSender().piece(this.peer, message.getBlockIndex(), this.peer.data[message.getBlockIndex()]);
        }
        return false;
    }

    @Override
    public boolean visitPieceMessage(PieceMessage message) {
        peer.data[message.getBlockIndex()] = message.getData();
        peer.downloadedBlocksCount += 1;

        this.peer.peers2BlocksMap.forEach((sender, value) -> sender.have(this.peer, message.getBlockIndex()));
        return peer.downloadedBlocksCount == peer.totalBlocksCount;
    }

    @Override
    public boolean visitIdleMessage(IdleMessage message) {
        PeerInterface last = null;
        int count = peer.totalBlocksCount;
        int digit = 0;
        for (int i = 0; i < peer.totalBlocksCount; i++) {
            if (this.peer.data[i] == null) {
                int ans = 0;
                PeerInterface current = null;
                for (Map.Entry<PeerInterface, boolean[]> entry : this.peer.peers2BlocksMap.entrySet()) {
                    if (entry.getValue()[i]) {
                        ans += 1;
                        current = entry.getKey();
                    }
                }
                if (ans < count) {
                    count = ans;
                    digit = i;
                    last = current;
                }
            }
        }
        assert last != null;
        last.request(this.peer, digit);
        return false;
    }
}