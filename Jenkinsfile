pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                withMaven(maven: 'maven') {
                  sh "mvn clean verify"
                } 
                
            }
        }
        stage('Run Application Get APIs') {
            steps {
            withMaven(maven: 'maven') {
                /// Run the maven build
                
                    parallel([
                        RunApplication: {
                            sleep 2;
                            sh "mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081 -DskipTests -Dmaven.test.failure.ignore=true || true"
                        },
                        GetAPIDocument: {
                            sleep 20;
                            sh "curl  http://localhost:8081/v3/api-docs.yaml > ${env.GIT_REPO_NAME}.yaml";
                            sleep 5;
                            sh "cat ${env.GIT_REPO_NAME}.yaml";
                        },
                        StopApplication: {
                            sleep 40
                            sh '''#!/bin/bash
                                kill `netstat -ltnup | grep :8081 | tr -s " " "\n" | sed -n 7p | sed 's#/.*##'` || true
                            '''
                        }
                    ])
                    

            }
            }
    }

    }
}
