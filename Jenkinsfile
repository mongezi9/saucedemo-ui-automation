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
                    def testSuite = ''
                    if (params.TEST_SUITE == 'login') {
                        testSuite = 'src/test/resources/runner/testng.login.xml'
                    } else if (params.TEST_SUITE == 'endtoend') {
                        testSuite = 'src/test/resources/runner/testng.e2e.xml'
                    }

                    sh "mvn clean test -DsuiteXmlFile=${testSuite} -Dbrowser=chrome -Durl=https://www.saucedemo.com/"
                }
            }
        }

        stage('Publish Reports') {
            steps {
                sh 'echo Generating TestNG Report'
            }
            post {
                always {
                    step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
                }
            }
        }
    }
}