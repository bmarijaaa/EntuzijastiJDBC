package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MetodeJdbc {
	
	public static Connection konektujSe (String imeBaze) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/"+imeBaze+"?useSSL=false";
		String user = "root";
		String password = "marija";
		
		return DriverManager.getConnection(url, user, password);
		
	}
	
	public static void azurirajPoPrezimenu (String prezime, int id) {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		
		try {
			konekcija = konektujSe("skola_programiranja");
			System.out.println("Uspesna konekcija!");
			
			String query = "UPDATE entuzijasti SET prezime = ? WHERE id_entuzijasti = ? ";
			pst = konekcija.prepareStatement(query);
			pst.setString(1, prezime);
			pst.setInt(2, id);
			pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Neuspesna konekcija!");
		}finally {
			if (pst !=null) {
				try {
					pst.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			if (konekcija != null) {
				try {
					konekcija.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
	
	
	
	public static void ubaciUTabeluEntuzijasti (String ime, String prezime, String mail, int pozcija) {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		
		try {
			konekcija = konektujSe("skola_programiranja");
			System.out.println("Uspesna konekcija!");
			
			String query = "INSERT INTO entuzijasti VALUES (NULL,?,?,?,?)";
			pst = konekcija.prepareStatement(query);
			pst.setString(1, ime);
			pst.setString(2, prezime);
			pst.setString(3, mail);
			pst.setInt(4, pozcija);
			pst.execute();
			
		} catch (Exception e) {
			System.out.println("Neuspesna konekcija!");
		}finally {
			if(pst!=null) {
				try {
					pst.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if (konekcija!=null) {
				try {
					konekcija.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
	
	
	
	public static String dajImeEntuzijaste (int id) {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		String vracenoIme = null;
		
		try {
			konekcija = konektujSe("skola_programiranja");
			System.out.println("Uspesna konekcija!");
			
			String query = "SELECT ime FROM entuzijasti WHERE id_entuzijasti = ?";
			pst = konekcija.prepareStatement(query);
			pst.setInt(1, id);
			res = pst.executeQuery();
			
			while (res.next()) {
				vracenoIme = res.getString("ime");
			}
			return vracenoIme;
			
		} catch (Exception e) {
			System.out.println("Neuspesna konekcija!");
			return null;
		}finally {
			try {
				pst.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			try {
				res.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			try {
				konekcija.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	
	public static List<String>dajImenaEntuzijasta (int id){
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		List<String> vracenaImena = new ArrayList<String>();
		
		try {
			konekcija = konektujSe("skola_programiranja");
			System.out.println("Uspesna konekcija!");
			String query = "SELECT ime FROM entuzijasti WHERE id_entuzijasti>?";
			pst = konekcija.prepareStatement(query);
			      pst.setInt(1, id);
			res = pst.executeQuery();
			
			while (res.next()) {
				vracenaImena.add(res.getString("ime"));
			}
			return vracenaImena;
			
		} catch (Exception e) {
			System.out.println("Neuspesna konekcija!");
			return null;
		}finally {
			
			try {
				res.close();
			} catch (Exception e2) {
			}
			
			try {
				pst.close();
				} catch (Exception e2) {
			}
			
			try {
			konekcija.close();	
			} catch (Exception e2) {
		}
	}
	}
	
	
	
	
	public static Entuzijasta dajEntuzijastu (int id) {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		Entuzijasta entuzijasta = new Entuzijasta();
		
		try {
			konekcija = konektujSe("skola_programiranja");
			System.out.println("Uspesna konekcija!");
			String query = "SELECT * FROM entuzijasti WHERE id_entuzijasti = ?";
			pst = konekcija.prepareStatement(query);
			pst.setInt(1, id);
			res = pst.executeQuery();
			
			while (res.next()) {
				entuzijasta.setIdEntuzijasta(res.getInt("id_entuzijasti"));
				entuzijasta.setIme(res.getString("ime"));
				entuzijasta.setPrezime(res.getString("prezime"));
				entuzijasta.setMail(res.getString("mail"));
				entuzijasta.setPozicija(res.getInt("pozicija"));
			}
			
			return entuzijasta;
		
		} catch (Exception e) {
			System.out.println("Neuspesna konekcija!");
			return null;
		}finally {
			try {
				res.close();
			} catch (Exception e2) {

			}
			
			try {
				pst.close();
			} catch (Exception e2) {
				
			}
			
			try {
				konekcija.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	
	public static List<Entuzijasta> dajSveEntuzijaste () {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		List<Entuzijasta> listaEntuzijasta = new ArrayList<Entuzijasta>();
		
		try {
			konekcija =  konektujSe("skola_programiranja");
			System.out.println("Uspesna konekcija!");
			String query = "SELECT * FROM entuzijasti";
			pst = konekcija.prepareStatement(query);
			res = pst.executeQuery();
			
			while (res.next()) {
				Entuzijasta entuzijasta = new Entuzijasta();
				
				entuzijasta.setIdEntuzijasta(res.getInt("id_entuzijasti"));
				entuzijasta.setIme(res.getString("ime"));
				entuzijasta.setPrezime(res.getString("prezime"));
				entuzijasta.setMail(res.getString("mail"));
				entuzijasta.setPozicija(res.getInt("pozicija"));
				
					listaEntuzijasta.add(entuzijasta);
			}
			return listaEntuzijasta;
			
		} catch (Exception e) {
			System.out.println("Neuspesna konekcija!");
			return null;
		}finally {
			try {
				res.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			try {
				pst.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			try {
				konekcija.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	
	
	public static void izbrisiEntuzijastu (int id) {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		
		try {
			konekcija = konektujSe("skola_programiranja");
			System.out.println("Uspesna konekcija!");
			String query = "DELETE FROM entuzijasti WHERE id_entuzijasti = ?";
			pst = konekcija.prepareStatement(query);
			pst.setInt(1, id);
			pst.execute();
			
		} catch (Exception e) {
			System.out.println("Neuspesna konekcija!");
		}finally {
			try {
				pst.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			try {
				konekcija.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		
		
	}
	
	
	
	
	
	
	
	

}
