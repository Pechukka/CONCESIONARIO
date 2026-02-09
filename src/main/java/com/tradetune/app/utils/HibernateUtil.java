package com.tradetune.app.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Creamos la configuración
            Configuration configuration = new Configuration();

            // Le decimos explícitamente dónde buscar el archivo (opcional si está en la raíz)
            // Si tu hibernate.cfg.xml está en resources directamente:
            // Le indicamos la ruta completa dentro de resources
            configuration.configure("com/tradetune/app/config/hibernate.cfg.xml");            // Si está dentro de una carpeta (como vi en tu foto: com.tradetune.app/config):
            // configuration.configure("com/tradetune/app/config/hibernate.cfg.xml");

            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Error crítico creando SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Solo necesitamos exponer la Fábrica.
    // Los Servicios se encargarán de pedirle sesiones (openSession).
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}