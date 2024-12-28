pipeline {
    agent any
   

    environment {
        GIT_REPO_NAME = 'test'
    }
    stages {
        // stage('Checkout') { 
        //     steps {
        //         cleanWs()
        //         scmVars = checkout(scm)
        //         BRANCH_NAME = scmVars.GIT_BRANCH
        //         SHORT_COMMIT = "${scmVars.GIT_COMMIT[0..7]}"
        //         GIT_REPO_NAME = scmVars.GIT_URL.replaceFirst(/^.*\/([^\/]+?).git$/, '$1')

                
        //     }
        // }
        stage('Build') { 
            steps {
                withMaven(maven: 'maven') {
                  sh "mvn clean verify"
                } 
                
            }
        }
        
        stage('Run Application Get APIs') {
            parallel {
                stage('RunApplication') {
                    steps {
                        sleep 2;
                        withMaven(maven: 'maven') {
                            sh "mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081 -DskipTests -Dmaven.test.failure.ignore=true || true" && \
                            sleep 20 && \
                            sh "curl  http://localhost:8081/v3/api-docs.yaml > ${GIT_REPO_NAME}.yaml" && \
                            sleep 5 && \
                            sh "cat ${GIT_REPO_NAME}.yaml" && \
                            sudo kill -9 `sudo lsof -i -n -P | grep TCP | grep :8081 | tr -s " " "\n" | sed -n 2p | sed 's#/.*##'`  
                        }
                    }
                }
                // stage('GetAPIDocument') {
                //     steps {
                //         sleep 20;
                //         sh "curl  http://localhost:8081/v3/api-docs.yaml > ${GIT_REPO_NAME}.yaml";
                //         sleep 5;
                //         sh "cat ${GIT_REPO_NAME}.yaml";
                //     }
                // }
                // stage('StopApplication') {
                //     steps {
                //         sleep 40
                //         sh '''#!/bin/bash
                //             sudo kill -9 `sudo lsof -i -n -P | grep TCP | grep :8081 | tr -s " " "\n" | sed -n 2p | sed 's#/.*##'`  
                            
                //         '''
                //     }
                // }
            }
        }

    }
}
