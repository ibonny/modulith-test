package personal.bonnycasi.modulithtest;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

import personal.bonnycasi.modulithtest.base.ModulithTestApplication;

class ApplicationTests {
    @Test
    void writeDocumentationSnippets() {

        var modules = ApplicationModules.of(ModulithTestApplication.class).verify();

        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }
}