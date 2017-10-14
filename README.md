# ds2

Compileren:
```bash
mkdir build
javac -d build src/ds2/*.java
```

Bank runnen:
```bash
cd build
rmiregistry
```
```bash
java -classpath build -Djava.rmi.server.codebase=file:/ ds2.Bank
```


ATM runnen:
```bash
java -classpath build -Djava.rmi.server.codebase=file:/ ds2.ATM deposit BE1 10
java -classpath build -Djava.rmi.server.codebase=file:/ ds2.ATM withdraw BE1 10
java -classpath build -Djava.rmi.server.codebase=file:/ ds2.ATM balance BE2
```

De `java.rmi.server.codebase` is relatief aan de directory waarin `rmiregistry` is gestart, dus `/`.


```bash
cd out/production/ds2
rmiregistry
```
```bash
java -jar out/artifacts/bank_jar/bank.jar
```
```bash
java -jar out/artifacts/atm_jar/atm.jar
```
