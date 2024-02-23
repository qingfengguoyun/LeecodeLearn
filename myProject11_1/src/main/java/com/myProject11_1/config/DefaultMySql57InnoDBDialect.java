package com.myProject11_1.config;

import org.hibernate.dialect.MySQL57InnoDBDialect;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.MySQLDialect;

public class DefaultMySql57InnoDBDialect extends MySQLDialect {
    @Override
    public String getTableTypeString(){
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci";
    };
}
