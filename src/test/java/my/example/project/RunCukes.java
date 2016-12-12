package my.example.project;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import de.abas.acceptanceTests.AbasAcceptanceRunner;
import de.abas.acceptanceTests.stepDefs.EDPOptions;


@RunWith(AbasAcceptanceRunner.class)
// verwende die setup.properties aus dem Classpath
@EDPOptions(classpath = "my/example/project/setup.properties")
@CucumberOptions(features = "src/test/resources",
// Tags mit Komma getrennt, die ausgeführt werden sollen
// tags = {"@Test1"}, 
// de.abas.acceptanceTests enthält die 'Standard-Schritte', zusätzlich wird noch 'my.example.project.cucumber' mit hinzugezogen
	glue = { "classpath:de.abas.acceptanceTests", "classpath:my.example.project.cucumber" },
// AbasFormatter Plugin macht das EDP-Logging einfacher, indem es in verschiedene Ordner gespeichert wird 
	plugin = { "de.abas.acceptanceTests.support.AbasFormatter", "pretty", "json:build/reports/cucumber.json", "html:build/reports/cucumber" },
// Fehler bei fehlenden Schritten
	strict = true,
// Farbige Ausgabe (nur in Verwendung mit einer entsprechenden Farbfähigen Konsole zu empfehlen. Für Eclipse gibt es z.b. ANSI Console Plugin)
	monochrome = false)
public class RunCukes {

}
