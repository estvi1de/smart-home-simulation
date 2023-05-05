package cz.cvut.k36.omo.hw.hw04;

/**
 * Экземпляр реализующего PeerInterface представляет
 * локальный узел или узел, подключенный через сеть.
 *
 * Instance implementujici PeerInterface reprezentuje lokalni uzel nebo uzel
 * pripojeny pres sit.
 */
public interface PeerInterface {
    /**
     * Сообщите удаленному узлу, что узел-отправитель только что
     * получил блок с индексом blockIndex.
     *
     * Sdeli vzdalenemu uzlu, ze uzel sender prave obdrzel blok s indexem
     * blockIndex.
     */
    public void have(PeerInterface sender, int blockIndex);

    /**
     * Попросит удаленный узел дать блок с индексом blockIndex
     *
     * Pozada vzdaleny uzel o blok s indexem blockIndex.
     */
    public void request(PeerInterface sender, int blockIndex);

    /**
     * Отправляет блок с индексом blockIndex на удаленный узел.
     *
     * Zasle vzdalenemu uzlu blok s indexem blockIndex.
     */
    public void piece(PeerInterface sender, int blockIndex, byte[] data);
}