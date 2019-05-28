package proyecto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Database {
	INSTANCE;
	
	private Map<Integer,Especie> listaPoke = new TreeMap();
	private Map<Integer,Ataque> listaAta = new TreeMap();
	private Map<Integer, Tipo> listaTypes = new TreeMap();
	private Map<Tipo, Map<Tipo,Double>> listaEfec = new TreeMap();
	
	Database(){
		
		Stream<String> linea;
		try(BufferedReader objReader=new BufferedReader(new FileReader("FicheroTipos.csv"))){
			linea=objReader.lines();
			listaTypes=linea.map(x->x.split(";"))
			.collect(Collectors.toMap(k->Integer.parseInt(k[0]), x-> new Tipo(Integer.parseInt(x[0]),x[1])));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedReader objReader=new BufferedReader(new FileReader("FicheroEfectividades.csv"))){
			linea=objReader.lines();
			listaEfec=linea.map(x->x.split(";"))
//			.collect(Collectors.groupingBy(k->Integer.parseInt(k[0]),Collectors.toMap(p -> Integer.parseInt(p[1]), o -> Double.parseDouble(o[2]))));
			.collect(Collectors.groupingBy(k->listaTypes.get(Integer.parseInt(k[0])),Collectors.toMap(p -> listaTypes.get(Integer.parseInt(p[1])), o -> Double.parseDouble(o[2]))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try(BufferedReader objReader=new BufferedReader(new FileReader("FicheroMovimientos.csv"))){
			linea=objReader.lines();
			listaAta=linea.map(x->x.split(";"))
			.collect(Collectors.toMap(k->Integer.parseInt(k[0])
							,x-> new Ataque(Integer.parseInt(x[0])
							,x[1]
							,Integer.parseInt(x[2])
							,Integer.parseInt(x[3])
							,x[4]
							,listaTypes.get(Integer.parseInt(x[5]))
							,listaEfec.get(listaTypes.get(Integer.parseInt(x[5]))))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedReader objReader=new BufferedReader(new FileReader("FicheroEspecies.csv"))){
			linea=objReader.lines();
			listaPoke=linea.map(x->x.split(";"))
			.collect(Collectors.toMap(k->Integer.parseInt(k[0]), x-> new Especie(Integer.parseInt(x[0])
					,x[1]
					,Integer.parseInt(x[2])
					,Integer.parseInt(x[3])
					,Integer.parseInt(x[4])
					,Integer.parseInt(x[5])
					,Integer.parseInt(x[6])
					,Integer.parseInt(x[7])
					,listaTypes.get(Integer.parseInt(x[8]))
					,x[9].equals("")?null:listaTypes.get(Integer.parseInt(x[9]))
					,listaAta.get(Integer.parseInt(x[10]))
					,listaAta.get(Integer.parseInt(x[11]))
					,listaAta.get(Integer.parseInt(x[12]))
					,listaAta.get(Integer.parseInt(x[13])))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Map<Integer,Tipo> queryAllTypes(){
		return listaTypes;
	}
	public Map<Integer,Especie> queryAllSpecies(){
		return listaPoke;
	}
	public Map<Integer,Ataque> queryAllAttacks(){
		return listaAta;
	}
	public Map<Tipo, Map<Tipo,Double>> queryAllEffect(){
		return listaEfec;
	}
}
