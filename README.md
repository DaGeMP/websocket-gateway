# websocket-gateway
The aim of this project is to have a simple way to make applications communicate between them in real-time.

For achieving this goal, this project makes use of spring WebSockets with a simple controller that will forward any
message to the subscribers adding the time when the message was received.

Also, a service for "channel" creation has been provided. The purpose of this service is to have the availability to obtain
a pseudo-unique code to communicate along with other applications instead of broadcasting the message to all the subscribers
of one topic. The logic behind the code creation is very simple at the moment (See SimpleUUIDCodeGenerator class), it
should be enough for small applications although, it cannot ensure not to have collisions. I would like to encourage
anyone reading this documentation to contribute by providing new and more sophisticated ways to calculate that.

Here you have a [running instance](https://websockets-gateway.herokuapp.com/) of the service.

# How to run
websocket-gateway is a maven application, it will need maven to be installed. For creating the build run the following 
command at the root of the project.

<pre><code>mvn clean install
</code></pre>

In order to run the spring boot application use the command below:

<pre><code>java -jar .\application-layer\target\application-layer-0.0.1-SNAPSHOT.jar
</code></pre>

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring WebSocket guide](https://spring.io/guides/gs/messaging-stomp-websocket/)

