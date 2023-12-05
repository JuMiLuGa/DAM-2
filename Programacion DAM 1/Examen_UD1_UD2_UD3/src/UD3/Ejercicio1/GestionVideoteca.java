package UD3.Ejercicio1;

public class GestionVideoteca {
    public static void main(String[] args) {
        // Instancia cinco objetos de la clase Pelicula
        Pelicula pelicula1 = new Pelicula("El Padrino", "Francis Ford Coppola", "123-ABC", 1972);
        Pelicula pelicula2 = new Pelicula("INTERSTELLAR", "Christopher Nolan", "456-DEF", 2014);
        Pelicula pelicula3 = new Pelicula("El gran Lebowski", "Joel Coen", "789-GHI", 1998);
        Pelicula pelicula4 = new Pelicula("Trainspotting", "Danny Boyle", "012-JKL", 1996);
        Pelicula pelicula5 = new Pelicula("Blade Runner", " Ridley Scott ", "345-MNO", 1982);

        // Muestra por pantalla la información de cada película
        System.out.println(pelicula1.toString());
        System.out.println(pelicula2.toString());
        System.out.println(pelicula3.toString());
        System.out.println(pelicula4.toString());
        System.out.println(pelicula5.toString());

        // Operaciones con la clase String
        // Reemplaza el carácter "-" en el código de la película 1 por un espacio
        pelicula1.setCodigo(pelicula1.getCodigo().replace("-", " "));

        // Pasa a minúsculas el título de la película de Christopher Nolan excepto la primera letra
        pelicula2.setTitulo(pelicula2.getTitulo().substring(0, 1).toUpperCase() +
                pelicula2.getTitulo().substring(1).toLowerCase());

        // Extrae una parte del título de la película 3 para que muestre "Lebowski"
        pelicula3.setTitulo("Lebowski");

        // Saca por consola la posición (índice para Java) de la palabra "Runner" en la película de Ridley Scott
        int indiceRunner = pelicula5.getTitulo().indexOf("Runner");
        System.out.println("Posición de 'Runner' en Blade Runner: " + indiceRunner);

        // Imprime por consola el director de la película 'Blade Runner' eliminando los espacios en blanco del principio y el final
        String directorBladeRunner = pelicula5.getDirector().trim();
        System.out.println("Director de Blade Runner: " + directorBladeRunner);
    }
}
