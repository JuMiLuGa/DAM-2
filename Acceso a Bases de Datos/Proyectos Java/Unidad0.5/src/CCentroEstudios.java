public class CCentroEstudios implements CentroEstudios {

    int aprobados;
    int suspensos;

    double notaMedia;

    @Override
    public int numeroDeAprobados(double[] notas) {
        aprobados = 0;

        for (double nota : notas) {
            if (nota >= 5.0) {
                aprobados++;
            }
        }
        return aprobados;
    }

    @Override
    public int numeroDeSuspensos(double[] notas) {
        suspensos = 0;
        for (double nota : notas) {
            if (nota < 5.0) {
                suspensos++;
            }
        }
        return suspensos;
    }

    @Override
    public double notaMedia(double[] notas) {
        notaMedia = 0;
        for (double nota : notas) {
            notaMedia += nota;
        }
        return notaMedia / notas.length;
    }
}

