Semestrální práce Smart Home (Belokon Nikita, Kozhemiakin Viktor)

Všechna dokumentace a popis konfigurace jsou v /doc 

  

F1 - Máme ty entity: 

Zařízení - Device,  

Domácí zvíře - Pet (Cat, Parrot, Dog),  

Jako Senzor máme možnost spočítat teplotu pro FireSignalization 

Auto – Car 

Patro – Level 

Dům - House 

Okno – Window (smart window, které můžeme zavírat = vypínat spotřebič) 

Kolo – bike 

A jiné, podrobný popis máme v popis modelu 

F2 - Můžeme měnit stav zařízení, například FreeObject, nebo zařízení nefunguje když je rozbité. FreeObject znamená, že když používáme té zařízení, nikdo jiný nemůže ho používat (například počítač). Lednice (Fridge) má jídlo, a můžeme vzít jídlo nebo přidat jej. 

F3 - Všechna spotřebiče mají spotřebu pro elektřinu. Ještě nějaké spotřebiče potřebují vodu (water pro WashingMachine), a plyn (gas pro GasCooker). Elektřina je připojena k pokoje, ale plyn a voda k spotřebiči. 

Příklad 1: GasDevice (Beko) is on 

Příklad 2: Power for Outdoor was on 

F4 - Všechna spotřebiče mají spotřebu (periodical consumption), kterou spočítáme každý krok cyklu, když používáme ten spotřebič. Máme celkový počet té spotřeby, který zvětšíme, pokud jsme použili ten spotřebič a píšeme to do reportů. 

Příklad: Electricity consumption for Samsung in BedroomForGrands - 6.50 (1.30 per turn) 

F5 – Osoba může vypnout zařízení, a když ještě někdo zkusí to udělat, tak uvidíme report, že nemůže, protože už je vypnuté. 

Příklad: Mother didn't turn off Dyson, because it's already off 

F6 - Každý krok cyklu generuje event: sporuje nebo používá zařízení. Osoba myslí na nějaké zařízení a jde do pokoji s tým zařízením, nebo může použít ho vzdáleně, pokud je smart a nikdo ho nepoužívá. Pokud místnost už nemá místo, tak nejde do té místnosti. Zařízení má atribut svého pokoje. 

Příklad 1: Guest5 can't use this device Tefal, because someone else uses it 

Příklad 2: Guest8 can't go to room Garage because it's busy 0 of 15 

F7 – V každém kroku cyklu máme 5% šance na Event: Požár, zkrat, problémy s vodou/plynem), v tomto případě smarthome zkusí zachránit náš dům a vypne zařízení, upozorní nás a zavolá hasiče (když potřebuje). 

Když máme ty 95%, po skončení kroku cyklu máme 10% šanci toho, že nějaký spotřebič bude rozbit. 

F8 - Máme report pro konfiguraci domu, pro aktivity se zařízením a pro consumption (water, gas, electricity) 

Generace vypada tak: 

1. Konfigurace 

2. Cyklus( 

	1. Eventy a aktivity (když máme mimořádnou událost: požár nebo zkrat, smarthome vypne všechno automaticky a napíše nám to, někdo prochází všechny pokoje a pak zapne elektřinu nebo plyn) 

	2. Consumption pro elektřinu 

	3. Consumption pro plyn 

	4. Consumption pro vodu 

) 

F9 - Když uživatel chce použit rozbité zařízení, nemůže, protože má opravit ho, a celý krok cyklu to opravuje. 

F10 - Když krok cyklu je sudý, sudý člověk rodiny dělá něco v domě, jiná polovina používá auto, kolo a lyže. Všechno sportovní spotřebiče mají omezení. Jezdit kolem nebo lyži může pouze jedna osoba, auto má svou kapacitu (capacity of persons).  

 

 

Design patterns 

Singleton 

Ten pattern mají: 

HouseCreator, protože žádná jiná třída nesmí generovat dům 

EventGenerator, protože generace eventů může být pouze jedna pro celý program. 

Visitor 

Používáme pro reporty konfigurace. Máme Interface CustomVisitor, a ReportVisitor implementuje ho, prochází všechny pokoje, patra, spotřebiče, osoby a transport. Ty třídy májí accept. 

Observer 

Používáme pro signalizační zařízení, protože může upozorňovat všech svých “observerů” a řídit jimi. Ještě spočítáme všechny spotřeby (consumption). 

Máme Observer, který má pouze update, každý Device je Observer. Ještě Observer má své interface - potomky GasDevice, WaterDevice. Udělali jsme to pro spočítání plynu a vody. 

PowerOutagesSignalization, WaterLeakSignalization a GasLeakSignalization implementují Observable. Observable má notifyObservers, subscribe, unsubscribe 

Hrdí jsme tím, že používáme Observer pro různé účely, a realizujeme ten pattern tak komplexně
