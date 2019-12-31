# MenuSelection

### IDE : Spring Tool Suite 3 Version: 3.9.11.RELEASE
### Language : Java (JDK 1.8.0_231)
### Server : Tomcat 8.0
### Framework : Spring, Mybatis
### DB : MariaDB 10.4

### get 파라미터 한글 깨짐
server.xml
<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>
<Connector port="8009" protocol="AJP/1.3" redirectPort="8443" URIEncoding="UTF-8"/>

javascript
var param = encodeURIComponent("파라미터");
