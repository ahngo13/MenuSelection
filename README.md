# MenuSelection

### 개발환경

OS : Windows 10

Web Browser : Google Chrome

IDE : Spring Tool Suite 3 Version: 3.9.11.RELEASE

Language : Java (JDK 1.8.0_231), javascirpt, JSP

Skill : Ajax, CSS

Server : Tomcat 8.0

Framework : Spring, Mybatis, JQuery, Bootstrap

DBMS : MariaDB 10.4

Configuration Management : Git



### Spring Framework 개발환경 세팅 시 참고 사이트

https://hanazuou.tistory.com/159



### 개발시 에로사항



#### get parameter 한글 깨짐

server.xml

~~~xml
server.xml
<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>
<Connector port="8009" protocol="AJP/1.3" redirectPort="8443" URIEncoding="UTF-8"/>
~~~

위와 같이 적용했으나 IE에서는 동일하게 깨짐 현상 발생

javascript로 적용하는 방법 참고

~~~javascript
var param = encodeURIComponent("파라미터");
~~~



#### 현재 위치 가져오기시 문제사항

PC Web에서 현재위치를 가져올 때 geolocation API를 사용하는데 정확성이 떨어지는 것으로 확인됨.

키워드로 검색해서 주변 음식점을 검색하는 것으로 개발 추진해야할 것으로 보임.



#### 부트스트랩 컴포넌트 사용 방법

참고해서 디자인하는데 활용하면 됨

https://demos.creative-tim.com/get-shit-done/components.html



#### 카카오맵 데이터 조회 관련

카테고리 조회시 총 45개까지 데이터를 가져올 수 있도록 제한되어있고

카테고리명으로 상세조회를 구현하려고 하였으나 카카오측에서 전체 카테고리 분류를

알려줄 수 없다고 하여 제한된 기능으로 개발 필요.


#### 데이터베이스 board 테이블 생성

데이터베이스 생성

`create database menuselection;`

<br>

board테이블 생성

```sql
create table menuselection.board (
	bno int auto_increment,
	title varchar(1000),
	content varchar(5000),
	writer varchar(20),
	passwd varchar(20),
	primary key (bno)
);
```

<br>

insert test data

`insert into board values(null, 'title', 'content', 'writer', 'passwd');`
