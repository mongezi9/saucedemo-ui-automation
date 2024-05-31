pipeline {
    agent any
    tools {
        maven "M3"
    }
    parameters {
        choice(name: 'TEST_SUITE', choices: ['login', 'endtoend'], description: 'Choose which test suite to run')
    }
    stages {

        stage('Clone Repository') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']],
                userRemoteConfigs: [[url: 'https://github.com/mongezi9/saucedemo-ui-automation.git']]])
            }
        }

        stage('Run Test') {
            steps {
                script {
                    sh "mvn clean test -DsuiteXmlFile=src/test/resources/runner/testng.ci.xml"
                }
            }
        }

         stage('Report') {
                    steps {
                        publishHTML(target: [
                            allowMissing: false,
                            alwaysLinkToLastBuild: true,
                            keepAll: true,
                            reportDir: 'target/cucumber-reports',
                            reportFiles: 'index.html',
                            reportName: 'Cucumber HTML Report'
                        ])
                    }
         }
    }
}