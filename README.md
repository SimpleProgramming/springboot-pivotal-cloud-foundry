# Spring Boot with Pivotal Cloud Foundry

A simple example demonstrating deploy Spring Boot Application in Pivotal Cloud Foundry and make use of 
the Pivotal's managed services

 - PCF is a Open source, PAAS, which can run as public or private cloud. 
 - It provides you On demand network access to shared resources like network, storage, app, services, servers. 
 - It is easy to provision and release on demand

# Cloud Computing
 - SAAS - you will be using the providers software, can be used in web, mobile, tablet. there is No access to 
underlying cloud infrastructure
 
 - PAAS - you will be using the provider tools to deploy or configure the application hosting 
environment(manage the application and data). but No access to underlying cloud infrastructure. 
CF falls under this model. Another example would be AWS Elastic Bean Stalk . Don’t have to worry about 
the traffic or scaling or hardware or operating system

 - IAAS - capability to provision, process system, storage etc. No access to underlying cloud 
infrastructure (i.e hardware) but can provision operating system , select storage, manage securities, 
take care of the system configurations above the hypervisor. AWS EC2, rack space cloud, etc are some of the examples

# PCF Architecture

 - Routing - The router routes incoming traffic to the appropriate component, which is the Cloud Controller component
 - Authentication - The OAuth2 server (the UAA) and Login Server work together to provide identity management.
 - App Life Cycle
    - Cloud Controller - The Cloud Controller (CC) directs the deployment of applications. To push an app to Cloud Foundry
    - Health Check - manages and monitors the health
 - Application Execution (DEA) - Droplet execution agent - run application, monitor and broadcast if it changes
    - Warden - container technology in cloud foundry
 - BlobStore - It is a repository for large binary files
 - Service Broker - provides third-party SaaS providers
 - Message Bus (NATs) - light weight public subscriber. used as a system level communication 
 - Log Aggregator - The Loggregator (log aggregator) system streams application logs to developers.
 - Metrics Collector - The metrics collector gathers metrics and statistics from the components

Organization - An org is a development account that an individual or multiple collaborators can own 
and use (typically a project space)

Spaces - Every application and service is scoped to a space. An org can contain multiple spaces (example environment)

Roles - group users in the environment

# How Application is deployed in Cloud Foundry Environment
     - When a CF push event happens, the cloud controller receives the push event. 
     - Cloud controller receives the raw source code and stores it in the BLOB
     - Cloud controller then starts the application. 
     - It then chooses a Execution Agent for the app. 
     - The Execution Agent uses the build pack info to start it up. 
     - Execution Agent streams out the app info around to other internal cloud services. 
     - Then the DEA creates a image of the app and stores in the BLOB. 
     - This image is a tarball file called droplet container
