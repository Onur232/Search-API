# Search API

An example project for making search at various social media sites. 

## Getting Started

The jar file created by this projects is used to get Rest response and show them as JSON objects in browser.

### Prerequisites

JAVA JRE 8 must be installed on system.
Browser is needed to communicate with software.
Must to be connected to internet in order to communicate with Twitter and Instagram APIs. 
Executed Jar file will listen for requests on localhost offline.
All dependencies will be inserted in jar file automatically.


### Installing

Just execute jar file and go to URIs stated in "Running the tests" part of this document. 

## Running the tests 

There is a jar file created by maven build called "searchapi-0.0.1-SNAPSHOT.jar" in \searchapi\target location. This file must be executed for testing. But due to constraints by github, it's not allowed to upload a jar file bigger then 25MB. So I uploaded zipped 
file of this JAR file called "searchapi-0.0.1-SNAPSHOT.jar.7z" in main branch of this project. This file must be unzipped and executed to use software.

There are two tests for testing Search API;

1-To use twitter API go to ;

http://localhost:8080/tweets?queryString=galatasaray

In this URI Query String is changable. So any other word can be written in order to search at twitter.
Software will do the search by using Twitter API and return wanted parameters in json format. For example purposes POJO class of TweetEntity and InstagramEntity kept short. 
But any other wanted information can be taken from twitter api and instagram api and parameters can be set to POJO classes. The objects are written to Embedded MongoDb repository
called flapdoodle and its working by starting jar file, no need to start MongoDb server seperately. For searching twitter,Twitter's official API dependency called "twitter4j-core" 
has used. Other details can be understood from source codes.

2-To use instagram API go to;

http://localhost:8080/instagram

However Instagram exposes many rest endpoints to use, its only available to get user information of users which we own in sandbox mode. So there is no option to search some keywords
and get responses. For example purposes I get my user informations from instagram and created a JSON response by setting my POJO class. As in searching twitter, here I also used 
an Embedded MongoDb repository called flapdoodle. 

By this software requests has been made to Instagram Endpoints and responses get and set to our POJO classes. Response as JSON are shown to end user in browser but it's available to
show in XML or any other format. Other details can be understood from source codes.


## Deployment

The output of software has created as JAR by Maven build. It can be built as WAR also. No need to deployment. Its just enough to execute JAR file and go to URI's that stated at 
"Running the tests" section of this document.

## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* twitter4j


## Contributing


## Versioning

No versioning.

## Authors

* **Onur Tas** - *Initial work* - (https://github.com/Onur232)


## License

This project has no license.

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
