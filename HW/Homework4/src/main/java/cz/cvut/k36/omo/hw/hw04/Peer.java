package cz.cvut.k36.omo.hw.hw04;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Инстанция класса Peer представляет локальный узел.
 *
 * Instance tridy Peer reprezentuje lokalni uzel.
 */
public class Peer implements PeerInterface {
    /**
     * Очередь необработанных сообщений
     *
     * Fronta nezpracovanych zprav.
     */
    final Queue<Message> messageQueue = new LinkedBlockingQueue<>();
    /**
     * Сопоставление узла с растровым изображением определяет, какие блоки доступны узлу.
     *
     * Mapovani z uzlu na bitovou mapu urcujici ktere bloky ma dany uzel k
     * dispozici.
     */
    final Map<PeerInterface, boolean[]> peers2BlocksMap;
    /**
     * Общее количество блоков в загруженном файле.
     *
     * Celkovy pocet bloku ve stahovanem souboru.
     */
    final int totalBlocksCount;
    /**
     * Поле скачанных блоков.
     *
     * Pole se stazenymi bloky.
     */
    final byte[][] data;
    /**
     * Количество скачанных блоков.
     *
     * Pocet stazenych bloku.
     */
    int downloadedBlocksCount = 0;

    public Peer() {
        this.peers2BlocksMap = peers2BlocksMap;
        this.totalBlocksCount = totalBlocksCount;
        data = new byte[totalBlocksCount][];
    }

    /**
     * Принимает сообщение "have" и добавляет его в очередь сообщений.
     *
     * Prijme zpravu "have" a prida ji do fronty zprav.
     */
    public void have(PeerInterface sender, int blockIndex) {
        messageQueue.add(new HaveMessage(blockIndex, sender));
    }

    /**
     * Принимает сообщение "запрос" и добавляет его в очередь сообщений.
     *
     * Prijme zpravu "request" a prida ji do fronty zprav.
     */
    public void request(PeerInterface sender, int blockIndex) {
        messageQueue.add(new RequestMessage(blockIndex, sender));
    }

    /**
     * Принимает правильный "piece" и добавляет его в нужную очередь сообщений.
     *
     * Prijme zpravu "piece" a prida ji do fronty zprav.
     */
    public void piece(PeerInterface sender, int blockIndex, byte[] data) {
        messageQueue.add(new PieceMessage(blockIndex, data, sender));
    }

    /**
     * Он подбирает самые старые сообщения из очереди сообщений
     * и обрабатывает их с помощью указанного посетителя.
     * Если в очереди нет сообщения, он отправит сам себе и обработает сообщение "idle".
     * Если этот узел загрузил все блоки, он отправит true, в противном случае значение false.
     *
     * Vyzvedne nejstarsi zpravu z fronty zprav a zpracuje ji pomoci zadaneho
     * navstevnika. Pokud ve fronte zadna zprava neni, zasle sam sobe a zpracuje
     * zpravu "idle". Vrati true v pripade, ze tento uzel stahnul vsechny bloky,
     * false jinak.
     */
    public boolean processMessage(MessageVisitor visitor) {
        return (messageQueue.isEmpty() ? new IdleMessage(this) : messageQueue.poll()).accept(visitor);
    }
}