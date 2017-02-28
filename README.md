# Beispiel Projekt für cucumber-jedp

## Setup

### Requirements
* java 1.6 oder höher
* gradle 2.0 oder höher
* eclipse Kepler oder höher
* eclipse Plugin cucumber von Natural/agileware

### Gradle Setup
Fügen sie die gradle.properties Datei zu ihrem $GRADLE_USER_HOME (<<Benutzerverzeichnis>>/.gradle/gradle.properties) hinzu.

```
#If you use a proxy add it here
http.proxyHost=webproxy.abas.de
http.proxyPort=8000
https.proxyHost=webproxy.abas.de
https.proxyPort=8000

org.gradle.daemon=true

nexusSnapshotURL=https://nexus3.abas-usa.com:8443/repository/abas.snapshots
nexusUser=<NexusUsername>
nexusPassword=<NexusPassword>

```
Nutzernamen und Passwort sind die extranet-Logins.

### Eclipse
Um ein eclipse Projekt zu bekommen kann gradle die benötigten Dateien selbst erzeugen. Dazu einfach im Projekt stehend folgenden Befehl in der shell ausführen:
```
gradle eclipse
```
Danach kann das Projekt einfach in eclipse importiert werden.

Für den einfacheren Gebrauch sollte zusätzlich noch das Plugin cucmber-editor von Natural/agileware vom eclipse Marketplace installiert werden.


## Verwendung
Das Projekt hat eine Feature-Datei als Beispiel mit dabei. Dabei wird im ersten Test die Verwendung von ein paar Testschritten gezeigt. Im zweiten Test sieht man wie eigene Testschritte hinzugefügt werden können. Dies geschieht in Verbindung mit der Klasse 'MyCustomSteps'.

Die RunCukes-Klasse ist eine JUnit-Klasse mit speziellem Runner ('AbasAcceptanceRunner') welcher eine einfacherer Integration mit abas und besseres Logging ermöglicht. Hierfür werden die Annotations EDPOptions und CucumberOptions verwendet.

Die Tests können entwedet in Eclipse über Run-JUnitTest gestartet werden oder über den Gradle Task 'test'.
```
gradle test
```
### EDPOptions
Hier können die Verbindungsdaten angegeben werden die im Test verwendet werden. Hierfür stehen mehrere Möglichkeiten bereit:
```
@EDPOptions(env=true)
```
EDP_HOST, EDP_PORT, EDP_CLIENT, EDP_PASSWORD werden aus der Umgebung gelesen.

```
@EDPOptions(envFile="myFileVariable")
```

Die Datei aus der Variable myFileVarialbe wird als Property-Datei eingelesen und die EDP_HOST, EDP_PORT, EDP_CLIENT, EDP_PASSWORD wird daraus entnommen.

```
@EDPOptions(file="/path/to/my/file.properties")
```

Die angegebene Datei wird direkt verwendet als Property-Datei eingelesen.

```
@EDPOptions(classpath="my/example/project/setup.properties")
```

Die angegebene Datei, welche im Klassenpfad liegen muss, wird als Property-Datei eingelesen.

Die Verbindungsdaten werden direkt übernommen.
```
@EDPOptions(EDP_HOST="myHost", EDP_PORT=6550, EDP_CLIENT="myClient", EDP_PASSWORD="myPassword")
```

Es können auch mehrere angegeben werden um zwischen verschiedenen Runtimes zu unterscheiden. Die Reihenfolge mit der nach den Verbindungsdaten gesucht wird, entspricht dann der hier angegebenen.
```
@EDPOptions(env=true, classpath="my/example/project/setup.properties")
```
Ist die Umgebung gesetzt, wird diese Verbindung verwendet. Ansonsten werden die Daten aus der Classpath-Datei verwendet.
