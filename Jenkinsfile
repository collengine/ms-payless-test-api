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
            parallel {
                stage('RunApplication') {
                    steps {
                        sleep 2;
                        sh "mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081 -DskipTests -Dmaven.test.failure.ignore=true || true"
                    }
                }
                stage('GetAPIDocument') {
                    steps {
                        sleep 20;
                        sh "curl  http://localhost:8081/v3/api-docs.yaml > ${env.GIT_REPO_NAME}.yaml";
                        sleep 5;
                        sh "cat ${env.GIT_REPO_NAME}.yaml";
                    }
                }
                stage('StopApplication') {
                    steps {
                        sleep 20
                        sh '''#!/bin/bash
                            sudo lsof -i -n -P | grep TCP | grep :8081 | tr -s " " "\n" | sed -n 2p | sed 's#/.*##'
                        '''
                    }
                }
            }
        }

    
}
