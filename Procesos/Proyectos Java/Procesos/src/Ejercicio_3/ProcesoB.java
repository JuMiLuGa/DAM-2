package Ejercicio_3;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class ProcesoB {
    public static void main(String[] args, FileHandler fileHandler) {
        Logger logger = Logger.getLogger("ProcesoB");
        logger.setUseParentHandlers(false);

        try {
            logger.addHandler(fileHandler);

            logger.info("Iniciando Proceso B");

            Thread b1Thread = new Thread(() -> {
                logger.info("Iniciando Proceso B1");
                sleep(1000);
                logger.info("Terminando Proceso B1");
            });
            Thread b2Thread = new Thread(() -> {
                logger.info("Esperando a que Proceso A2 termine");
                logger.info("Iniciando Proceso B2");
                sleep(1000);
                logger.info("Terminando Proceso B2");
            });
            Thread b3Thread = new Thread(() -> {
                logger.info("Iniciando Proceso B3");
                sleep(1000);
                logger.info("Terminando Proceso B3");
            });

            b1Thread.start();
            b2Thread.start();
            b3Thread.start();

            try {
                b1Thread.join();
                b2Thread.join();
                b3Thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            logger.info("Terminando Proceso B");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
