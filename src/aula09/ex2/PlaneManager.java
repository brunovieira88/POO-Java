package aula09.ex2;

import java.util.ArrayList;

public class PlaneManager {
    private ArrayList <Plane> planes;

    public PlaneManager(){
        this.planes = new ArrayList<>();
    }

    public void addPlane(Plane plane){
        if (plane != null ){
            planes.add(plane);
        }
    }

    public void removePlane(String id){
        for (Plane plane : planes){
            if (id.equals(plane.getId())){
                planes.remove(plane);
                return; 
            }
        }
        System.out.println("Aviao nao encontrado");
    }

    public Plane searchPlane(String id){
        for (Plane plane : planes) {
            if (plane.getId().equals(id)) {
                return plane;
            }
        }
        System.out.println("Aviao nao encontrado");
        return null;
    }

    public ArrayList<ComercialPlane> getComercialPlanes(){
        ArrayList<ComercialPlane> result = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ComercialPlane) {
                result.add((ComercialPlane) plane);
            }
        }
        return result;
    }

    public ArrayList<MilitaryPlane> getMilitaryPlanes(){
        ArrayList<MilitaryPlane> result = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                result.add((MilitaryPlane)plane);
            }
        }
        return result;
    }

    public void printAllPlanes(){
        for (Plane plane : planes){
            System.out.println(plane.toString());
        }
    }

    public Plane getFastestPlane(){
        Plane fastest = planes.get(1);
        for( Plane plane : planes){
            if (plane.getVmax() > fastest.getVmax()){
                fastest = plane;
            }
        }
        return fastest;
    }
}
