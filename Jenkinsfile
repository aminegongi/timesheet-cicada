pipeline {
    agent any

    stages {
        stage('Ok') {
            steps {
                echo "Okkkkkkkkk"
            }
        }
        stage("Build") {
            steps {
                bat "mvn clean package"
            }
        }
        stage('Nexus deploy'){
            steps {
                bat 'mvn deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=1.1 -DgeneratePom=true -Dpackaging=jar  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-1.1.jar';
            }
        }
        stage('Sonar Test'){
            steps {
                bat 'mvn sonar:sonar';
            }
        }
    }
    
    post {
        always {
            cleanWs()
            mail bcc: '', 
            body: '''Build Done , please check result !''', cc: '', from: '', replyTo: '', subject: 'Build successfull', to: 'nour.dziri1@esprit.tn'
        }
    }
}