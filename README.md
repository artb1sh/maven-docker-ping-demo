
# build jar and upload images do docker host
  - Build FAT-jar and container
    -`mvn package docker:build`
  - Build fat-jar, build container, start container, test, stop container, remove container
    - `mvn install`
  - Push container upstream (you would have to change the repository name in the maven plugin for proper authentication, thouhg)
  - `mvn package docker:push`

## run ping
`docker run -p 8080 -t -i --rm bee42/ping:1.0-SNAPSHOT java -Djava.security.egd=file:/dev/./urandom -jar /opt/ping/ping.jar`

## fix maven deps
  `mvn dependency:tree -Ddetail=true`


Peter Rossbach (peter.rossbach@bee42.com)
