package ddorcak.nekonecneHry.core;

import java.util.ArrayList;
import java.util.List;

public class PlayerOneEasy {
	
	
	public static List<DoubleInterval> rozdel(DoubleInterval zakladny, int turnCount) {
		List<DoubleInterval> vysledok = new ArrayList<>();
		double dlzka = zakladny.getLength() / (turnCount + 1);
		double posun = dlzka / 50;
		double hranicaL = zakladny.getBorderL();
		double hranicaR = zakladny.getBorderL();
		for (int i = 0; i < turnCount; i++) {
			hranicaR += dlzka;
			vysledok.add(new DoubleInterval(hranicaL - posun, hranicaR));
			hranicaL += dlzka;
		}
		hranicaR += dlzka;
		vysledok.add(new DoubleInterval(hranicaL - posun, hranicaR + posun));

		return vysledok;

	}

}
