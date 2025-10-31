https://graphviz.org/download/

mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false -Dscope=compile "-Dincludes=com.xgaslan*:*"

in docker compose directory run:

```
 docker compose -f common.yml -f zookeeper.yml up   
```

after that run we can check zookeeper is running healthy by executing:

```
echo ruok | nc localhost 2181
```

If the zookeeper is running healthy it should return "imok"

then we can run kafka cluster by executing:

```
 docker compose -f common.yml -f kafka_cluster.yml up   
```

after that we can run init script to create topics and produce/consume messages:

```
 docker compose -f common.yml -f init_kafka.yml up   
```

To generate avro classes in kafka-module path run that command

```
mvn clean install
```
