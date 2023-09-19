import java.util.Random;

public class PruebaCCentroEstudios {
    public static void main(String[] args){
    CCentroEstudios CCE = new CCentroEstudios();

    double[] notas = generadorNotas(30);

    int aprobados = CCE.numeroDeAprobados(notas);
        int suspensos = CCE.numeroDeSuspensos(notas);
        double media = CCE.notaMedia(notas);

        System.out.println("Numero de Aprobados = " + aprobados);
        System.out.println("Numero de Suspensos = " + suspensos);
        System.out.println("Nota Media = " + media);

        System.out.println("Numero de pisos = " + CentroEstudios.numeroDePisos);
        System.out.println("Numero de Aulas = " + CentroEstudios.numeroDeAulas);
        System.out.println("Numero de Despachos = " + CentroEstudios.numeroDeDespachos);


    }

    private static double[] generadorNotas(int cantidad) {

        double[] notas = new double[cantidad];
        Random random = new Random();

        for( int i = 0 ; i < cantidad ; i++ ){
            double nota = random.nextDouble() * 10;
            notas[i] = nota;
        }
        return notas;
    }
}
