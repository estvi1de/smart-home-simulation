package cz.cvut.k36.omo.hw.hw04;

/**
 * Экземпляр класса MessageVisitor представляет посетителей, обрабатывающих сообщения.
 * <p>
 * Instance tridy MessageVisitor reprezentuji navstevniky zpracovavajici zpravy.
 */
public abstract class MessageVisitor {
    protected final Peer peer;

    public MessageVisitor(Peer peer) {
        this.peer = peer;
    }

    /*
     * Обрабатывает сообщение "Have": локальный узел указывает,
     * что блок с заданным индексом доступен для удаленного узла.
     *
     * Всегда возвращает False
     *
     * Zpracuje zpravu "have": v lokalnim uzlu vyznaci, ze dany vzdaleny uzel ma
     * k dispozici blok s danym indexem.
     *
     * Vzdy vrati false.
     */
    public abstract boolean visitHaveMessage(HaveMessage message);

    /*
     * Обрабатывает сообщение "Request": если запрошенный блок доступен локальному узлу,
     * он отправит его удаленному узлу с помощью сообщения "piece".
     * Если нет, он игнорирует просьбу.
     *
     * Всегда возвращает False
     *
     * Zpracuje zpravu "request": pokud ma lokalni uzel pozadovany blok k
     * dispozici, obratem ho posle vzdalenemu uzlu pomoci zpravy "piece". Pokud
     * ne, pozadavek ignoruje.
     *
     * Vzdy vrati false.
     */
    public abstract boolean visitRequestMessage(RequestMessage message);

    /*
     * Он обрабатывает сообщение "piece": сохраняет полученные данные на локальном узле,
     * увеличивает количество загруженных блоков и отправляет сообщение "Have"
     * на все удаленные узлы (включая тот, с которого он получил данные).
     *
     * Возвращает значение true, если локальный узел загрузил все блоки,
     * в противном случае значение false.
     *
     * Zpracuje zpravu "piece": ulozi obdrzena data do lokalniho uzlu, zvysi
     * pocet stazenych bloku a vsem vzdalenym uzlum (vcetne toho, od ktereho
     * data obdrzel) rozesle zpravu "have".
     *
     * Vrati true, pokud lokalni uzel stahl vsechny bloky, false jinak.
     */
    public abstract boolean visitPieceMessage(PieceMessage message);

    /*
     * Он обрабатывает сообщение "idle": выбирает наиболее ценный неустановленный
     * блок и запрашивает его у одного из его владельцев. Наиболее ценным блоком
     * является тот, который владеет наименее удаленным узлом.
     * Если их несколько, он выберет одного из них.
     *
     * Всегда возвращает false
     *
     * Zpracuje zpravu "idle": vybere nejvzacnejsi jeste nestazeny blok a zazada
     * o nej u nektereho z jeho vlastniku. Nejvzacnejsi blok je takovy, ktery
     * vlastni nejmene vzdalenych uzlu. Pokud je nejvzacnejsich bloku nekolik,
     * vybere jeden z nich.
     *
     * Vzdy vrati false.
     */
    public abstract boolean visitIdleMessage(IdleMessage message);
}