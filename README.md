<<< cake.wizard>>>>
============================================================

SOA and IR project about cakes ;)
------------
Basic instructions for installing and running:

- tomcat 6.0.26 server (customly patched for mysql, jaxrs and jax-ws integration)
- apache-cxf-2.7.5 runtime library added to eclipse

----------------------
SERVICES


DAO service:
- reads/writes from table "cake_recipes" in MySQL
- exposed as REST service
- deployed as WAR
- can be reached here: http://localhost:8080/bg.cakerecipes.daoservices/rest/cakes
API
- all cakes /cakes
- perticular cake id -> /cakes?id=1
- multiple cakes ids: -> /cakes?id=1&id=26


DataRetrieval Service (DrService)
- reads data from a json file
- fetches data from WWW sites (IN-PROGRESS)
- exposed as REST service
- deployed as WAR
- can be reached here: http://localhost:8080/bg.cakerecipes.drservices/rest/raw-cakes


SearchService 
- provides searching capabilities
- generates indexTrees and queries them (IN-PROGRESS)
- exposed as JAX-WS service using CXF runtime
- deployed as WAR
- WSDL reachable here: http://localhost:8080/bg.cakerecipes.searchservices/services/SearchServiceImplPort?wsdl

API
- List<id, rank> query(keyword)
- void buildIndexTrees()


----------------------
UI

TestServlet
- displays information from each service
- nice shiny HTML (IN-PROGRESS)
- consumes the other 2 WARS and 1 WSDL
- deployed as WAR
- can be reach here: http://localhost:8080/bg.cakerecipes.client/TestServlet