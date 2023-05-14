# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM amazoncorretto:17
maintainer MR
COPY target/mr-0.0.1-SNAPSHOT.jar  mr-app.jar
ENTRYPOINT ["java","-jar","/mr-app.jar"] 
EXPOSE 8080
