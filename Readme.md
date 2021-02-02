# Calculator client

TCP client providing a service for performing simple arithmetic calculations
You can find the server code at the link https://github.com/ArtemDruzhilov/CalculatorServer

Build

```bash
./gradlew build
```

Allow script execution
```bash
chmod +x ./calculatorClient 
```

See help
```bash
./calculatorClient -h
```

Run application with default params (host = localhost, port = 4567)
```bash
./calculatorClient 
```

Run application with custom params (for example, host = 192.168.1.14, port = 9999)
```bash
./calculatorClient --host 192.168.1.14 --port 9999 
```

Run application using only jar file with default params (host = localhost, port = 4567)
```bash
java -jar ./build/libs/CalculatorClient-1.0-all.jar 
```

Run application using only jar file with custom params (for example, host = 192.168.1.14, port = 9999)
```bash
java -jar ./build/libs/CalculatorClient-1.0-all.jar --host 192.168.1.14 --port 9999
```

Exit command
```bash
q
```

### Technologies

* Java 11
* Gradle
* Picocli


    