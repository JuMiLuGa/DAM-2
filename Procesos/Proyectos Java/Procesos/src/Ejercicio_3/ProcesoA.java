package Ejercicio_3;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class ProcesoA {
    public static void main(String[] args, FileHandler fileHandler) {
        Logger logger = Logger.getLogger("ProcesoA");
        logger.setUseParentHandlers(false);

        try {
            logger.addHandler(fileHandler);

            logger.info("Iniciando Proceso A");

            Thread a1Thread = new Thread(() -> {
                logger.info("Iniciando Proceso A1");
                sleep(1000);
                logger.info("Terminando Proceso A1");
            });
            Thread a2Thread = new Thread(() -> {
                logger.info("Iniciando Proceso A2");
                sleep(1000);
                logger.info("Terminando Proceso A2");
            });
            Thread a3Thread = new Thread(() -> {
                logger.info("Iniciando Proceso A3");
                sleep(1000);
                logger.info("Terminando Proceso A3");
            });

            a1Thread.start();
            a2Thread.start();
            a3Thread.start();

            try {
                a1Thread.join();
                a2Thread.join();
                a3Thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            logger.info("Terminando Proceso A");
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
