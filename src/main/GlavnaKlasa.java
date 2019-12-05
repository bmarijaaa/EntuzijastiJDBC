package main;

import java.util.List;
import java.util.Scanner;

import model.Entuzijasta;
import model.MetodeJdbc;
import model.Validacija;

public class GlavnaKlasa {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		/*System.out.println("Unesite prezime: ");
		String prezime = scanner.nextLine();
		
		System.out.println("Unesite id: ");
		int id = Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		MetodeJdbc.azurirajPoPrezimenu(prezime, id)*/;
		
		
		/*System.out.println("Unesite ime: ");
		String ime = scanner.nextLine();
		
		System.out.println("Unesite prezime: ");
		String prezime = scanner.nextLine();
		
		System.out.println("Unesite mail: ");
		String mail = scanner.nextLine();
		
		System.out.println("Unesite pozicija: ");
		int pozicija = Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		MetodeJdbc.ubaciUTabeluEntuzijasti(ime, prezime, mail, pozicija);*/
		
		/*System.out.println("Unesite id: ");
		int id = Integer.parseInt(scanner.nextLine());
		
		String ime = MetodeJdbc.dajImeEntuzijaste(id);
		System.out.println(ime);
		
		scanner.close();*/
		
		/*System.out.println("Unesite id: ");
		int id = Integer.parseInt(scanner.nextLine());
		
		List<String>imena = MetodeJdbc.dajImenaEntuzijasta(id);
		
		for (String s : imena) {
			System.out.println(s);
		}
		
		for (int i = 0; i < imena.size(); i++) {
			System.out.println(imena.get(i));
		}*/
		
		
		/*List<Entuzijasta> listaEntuzijasta = MetodeJdbc.dajSveEntuzijaste();
		
		System.out.println("id"+"    "+"ime"+"    "+"prezime"+"    "+"mail"+"    "+"pozicija");
		
		for (Entuzijasta e : listaEntuzijasta) {
			System.out.println(e.getIdEntuzijasta()+"  "+e.getIme()+"  "+e.getPrezime()+"  "+e.getMail()+"  "+e.getPozicija());
		}*/
		
		/*System.out.println("Unesite id: ");
		
		String proba = scanner.nextLine();
		
		if (Validacija.daLiJeBroj(proba)) {
			
			int id = Integer.parseInt(proba);
			Entuzijasta e = MetodeJdbc.dajEntuzijastu(id);
			
			if (e.getIdEntuzijasta() != 0) {
				System.out.println(e.getIdEntuzijasta()+"  "+e.getIme()+"  "+e.getPrezime()+"  "+e.getMail()+"  "+e.getPozicija());
			}else {
				System.out.println("Ne postoji taj id!");
			}
		}else {
			System.out.println("Los unos!");
		}*/
		
		
		System.out.println("Unesite id: ");
		
		int id = Integer.parseInt(scanner.nextLine());
		
		MetodeJdbc.izbrisiEntuzijastu(id);
		
		
		
		
		
		
		
		

	}

}
