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
                    steps {
                         forget 'my lambda'
                    }
                
        }

    }
}
