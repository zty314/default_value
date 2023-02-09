package com.diligent.gogogo;

import com.kedacom.mo.boot.application.MoBootApplicationServletInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GogogoApplication extends MoBootApplicationServletInitializer {

    @Override
    protected Class<? extends MoBootApplicationServletInitializer> getServletBootClass() {
        return GogogoApplication.class;
    }

    public static void main(String[] args) {
        runWebJar(GogogoApplication.class, args);
    }

}
