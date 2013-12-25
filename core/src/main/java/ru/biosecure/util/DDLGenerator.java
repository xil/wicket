package ru.biosecure.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.PersonToScan;
import ru.biosecure.wicket.global.core.entities.Scan;
import ru.biosecure.wicket.global.core.entities.scanner.ScannerTask;
import ru.biosecure.wicket.global.core.entities.security.Permission;
import ru.biosecure.wicket.global.core.entities.security.Role;
import ru.biosecure.wicket.global.core.entities.security.User;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 20.06.13
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public class DDLGenerator {

    public static void main(String[] args) {
        new DDLGenerator().execute(Dialect.MSSQL,
                ScannerTask.class,
                Role.class,
                Person.class,
                Permission.class,
                User.class,
                PersonToScan.class,
                Scan.class
        );
    }

    private void execute(Dialect dialect, Class<?>... classes) {
        Configuration configuration = new Configuration();
        configuration.setProperty(Environment.DIALECT, dialect.getClassName());
        for (Class<?> entityClass : classes) {
            configuration.addAnnotatedClass(entityClass);
        }
//        /home/inver/Development/ee/biosecure/wicket/core/src/main/db/mysql/10.create-db.sql
        SchemaExport schemaExport = new SchemaExport(configuration);
        schemaExport.setDelimiter(";");
        schemaExport.setOutputFile(String.format("core/src/main/db/%s/10.create-db.sql", new Object[]{dialect.name().toLowerCase()}));
        boolean consolePrint = true;
        boolean exportInDatabase = false;
        schemaExport.create(consolePrint, exportInDatabase);
    }


}
