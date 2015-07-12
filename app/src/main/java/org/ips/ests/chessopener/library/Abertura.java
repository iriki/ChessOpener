package org.ips.ests.chessopener.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Abertura {

	/**
	 * Helper class relativo aos item a apresentar (neste caso Aberturas)
	 * <p/>
	 */

	/**
	 * Um array de Aberturas.
	 */
	public static List<AberturaItem> ABERTURAS = new ArrayList<AberturaItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, AberturaItem> ABERTURAS_MAP = new HashMap<String, AberturaItem>();

	static {
		// Adicionar 3 Aberturas.
		adicionarAbertura(new AberturaItem("1", "Alekhine"));
		adicionarAbertura(new AberturaItem("2", "King's Pawn"));
		adicionarAbertura(new AberturaItem("3", "Indian Defense"));
	}

	private static void adicionarAbertura(AberturaItem item) {
		ABERTURAS.add(item);
		ABERTURAS_MAP.put(item.id, item);
	}

	/**
	 * Classe POJO representando um item Abertura.
	 */
	public static class AberturaItem {
		public String id;
		public String nome;

		public AberturaItem(String id, String nome) {
			this.id = id;
			this.nome = nome;
		}

		@Override
		public String toString() {
			return nome;
		}
	}
}
