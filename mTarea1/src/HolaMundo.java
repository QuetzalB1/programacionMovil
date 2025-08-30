import javax.imageio.plugins.tiff.ExifInteroperabilityTagSet;

public class HolaMundo {
    String nombre= "juan solo";

    public HolaMundo(){
        //saludar();
    }

    public void saludar(String nombre){
        this.nombre= nombre;

        System.out.println("HOLA MUNDO" + " " +  nombre);
    }

    public static void despedirse (){

        System.out.println("adios");
        //EXIT.orClose();

    }
}
