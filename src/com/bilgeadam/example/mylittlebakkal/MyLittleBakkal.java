package com.bilgeadam.example.mylittlebakkal;

import java.util.LinkedList;
import java.util.TreeMap;

public class MyLittleBakkal {
	private LinkedList<Product> products;
	
	public MyLittleBakkal() {
		this.products = new LinkedList<>();
	}
	
	public static void main(String[] args) {
		
		BAUtils.header("B E N İ M   B A K K A L I M");
		
		MyLittleBakkal bakkal = new MyLittleBakkal();
		TreeMap<Integer, String> menu = bakkal.initMenu();
		boolean cont = true;
		do {
			int selection = BAUtils.menu(menu);
			cont = bakkal.processMenu(selection);
		} while (cont);
		
		BAUtils.footer();
		
	}
	
	private boolean processMenu(int selection) {
		
		boolean retVal = switch (selection) {
			case 2: {
				productList();
				yield true;
			}
			case 8: {
				enterNewProduct();
				yield true;
			}
			case 99: {
				yield false;
			}
			default: {
				System.out.println(selection + " seçildi");
				yield true;
			}
		};
		return retVal;
	}
	
	private void productList() {
		int size = this.products.size();
		System.out.println("Bakkalda " + size + " ürün var");
		for (int i = 0; i < size; i++) {
			Product product = products.get(i);
			
			if (product instanceof PackagedGood) {
				PackagedGood pG = (PackagedGood) product;
				System.out.println(pG.isSpoiled());
			}
			System.out.println(products.get(i));
		}
	}
	
	private void enterNewProduct() {
		BAUtils.header("Ürün Girişi");
		
		String ean = BAUtils.readString("Lütfen EAN kodunu giriniz");
		String name = BAUtils.readString("Lütfen ürün adını giriniz");
		float price = (float) BAUtils.readDouble("Lütfen ürün fiyatını giriniz");
		int vat = BAUtils.readInt("Lütfen KDV oranını giriniz");
		int minStock = BAUtils.readInt("Lütfen asgari ürün miktarını giriniz");
		String packed = BAUtils.readString("Ürün paketli mi? (evet/hayır)");
		if (packed.equalsIgnoreCase("evet")) {
			int experationDate = BAUtils.readInt("Lütfen raf ömrünü giriniz");
			PackagedGood good = new PackagedGood(ean, name, price, vat, minStock, experationDate);
			this.products.add(good);
		} else {
			String origin = BAUtils.readString("Lütfen ürün menşeini giriniz");
			float volume = (float) BAUtils.readDouble("Lütfen ürün hacmini giriniz");
			PackedUnpackedProduct good = new PackedUnpackedProduct(ean, name, price, vat, minStock, false);
			good.setOrigin(origin);
			good.setVolume(volume);
			this.products.add(good);
			// private Unit unit;
		}
	}
	
	private TreeMap<Integer, String> initMenu() {
		TreeMap<Integer, String> menu = new TreeMap<>();
		menu.put(1, "Çalışan girişi");
		menu.put(2, "Ürün Listele");
		menu.put(8, "Ürün gir");
		menu.put(23, "Stok sorgula");
		menu.put(6, "Fiyat güncelle");
		menu.put(7, "Müşteri tanımla");
		menu.put(3, "Müşteri listesi");
		menu.put(4, "Ürün listesi");
		menu.put(99, "Programı bitir");
		return menu;
	}
	
}
