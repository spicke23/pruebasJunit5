pipeline {
    agent any 

    tools { 
        maven 'mavenjenkins'
        jdk 'jenkisjava'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/MiguelAngelRamos/pruebasJunit5.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

    stage('Sonar Scanner') {
        steps {
            script {
                def sonarqubeScannerHome = tool name: 'sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                withCredentials([string(credentialsId: 'sonar', variable: 'sonarLogin')]) {
                    sh "${sonarqubeScannerHome}/bin/sonar-scanner -e -Dsonar.host.url=http://SonarQube:9000 -Dsonar.login=${sonarLogin} -Dsonar.projectName=gs-gradle -Dsonar.projectVersion=${env.BUILD_NUMBER} -Dsonar.projectKey=GS -Dsonar.sources=src/main/java/cl/awakelab/junitapp -Dsonar.tests=src/test/java/cl/awakelab/junitapp -Dsonar.language=java -Dsonar.java.binaries=."
                }
            }
        }
    }

    stage('nexus') {
        steps {
            script {
                  dir("target"){
                    def pom = readMavenPom file: "../pom.xml"
                                nexusArtifactUploader(
                                    nexusVersion: 'nexus3',
                                    protocol: 'http',
                                    nexusUrl: 'localhost:8081',
                                    groupId: pom.groupId,
                                    version: pom.version,
                                    repository: 'maven-snapshots',
                                    // credentialsId: 'nexuscredenciales',
                                    artifacts: [
                                        [artifactId: pom.artifactId,
                                        classifier: '',
                                        file: '/var/jenkins_home/workspace/NewJUnit5/target/proyectoJunit-0.0.1-SNAPSHOT.jar',
                                        type: 'jar']
                                    ]
                                )
                            }
            }
        }
    }

    }
}
